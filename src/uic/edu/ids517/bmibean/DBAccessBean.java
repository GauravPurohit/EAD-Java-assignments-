package uic.edu.ids517.bmibean;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.jsp.jstl.sql.ResultSupport;
import javax.servlet.jsp.jstl.sql.Result;

import uic.edu.ids.actionbean.SQLConstants;

public class DBAccessBean {

	private DbUserInfo dbUserInfo;

	private String userName;
	private String password;
	private String host;
	private String url;
	private String dbSchema;
	private String dbms;
	private String jdbcDriver;

	private boolean status = false;

	// private String queryType;
	// private String sqlQuery;

	private Connection connection;
	private DatabaseMetaData databaseMetaData;
	private Statement statement;
	private ResultSet resultSet, rs;
	// private ResultSetMetaData resultSetMetaData;
	
	private String queryType; 
	private String sqlQuery; 
	private String message;
	
	private Result result; 
	private ArrayList<String>columnNames; 
	private int numberColumns; 
	private ResultSet MetaDatarsmd; 
	private int numberRows; 

	private boolean renderResult; 
	
	

	private static final String[] TABLE_TYPES = { "TABLE", "VIEW" };

	public boolean connectToDB() throws SQLException {

		DbUserInfo userInfo = new DbUserInfo();
/*
		userName = userInfo.getUserName();
		password = userInfo.getPassword();
		host = userInfo.getDbmsHost();
		dbSchema = userInfo.getDatabaseSchema();
		dbms = userInfo.getDbms();
	*/	
		System.out.println("Database Details: "+host+":"+dbSchema);

		/*
		 * //DB2 jdbcDriver = "com.ibm.db2.jcc.DB2Driver"; url = "jdbc:db2://" +
		 * host + ":50000/" + dbSchema;
		 * 
		 * //ORACLE jdbcDriver = "oracle.jdbc.driver.OracleDriver"; url =
		 * "jdbc:oracle:thin:@" + host + ":1521:" + dbSchema;
		 */

		// MYSQL
		jdbcDriver = "com.mysql.jdbc.Driver";
		url = "jdbc:mysql://" + host + ":3306/" + dbSchema;
		
		/*url = "jdbc:mysql://localhost:3306/feedback";
		userName = "root";
		password = "raghav333";*/
		

		try {
			Class.forName(jdbcDriver);
			connection = DriverManager.getConnection(url, userName, password);
			statement = connection.createStatement(
					ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_UPDATABLE);
			databaseMetaData = connection.getMetaData();
			status = true;
		} catch (ClassNotFoundException e) {
			System.err.println("Error: "
					+ ((ClassNotFoundException) e).getMessage()
					+ " -> Could not load JDBC driver");
			status = false;
		} catch (SQLException e) {
			System.err.println("SQLException information: ");
			while (e != null) {
				System.err.println("Error message: " + e.getMessage());
				System.err.println("SQLSTATE: " + e.getSQLState());
				System.err.println("Error Code: " + e.getErrorCode());
				e.printStackTrace();
				e = e.getNextException();
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			status = false;
		}

		return status;
	}

	public boolean closeConnection() {
		try {
			// rs.close();
			statement.close();
			connection.close();
			System.out.println("Connection Closed");
			status = true;
		} catch (SQLException ex) {
			System.err.println("SQLException information");
			while (ex != null) {
				System.err.println("Error message: " + ex.getMessage());
				System.err.println("SQLSTATE: " + ex.getSQLState());
				System.err.println("Error Code: " + ex.getErrorCode());
				ex.printStackTrace();
				ex = ex.getNextException();
				status  = false;
			}
		}
		return status;
	}

	public boolean execSQLStatement(String sqlQuery) {

		String queryType = sqlQuery.substring(0, 6);
		System.out.println(queryType);

		if (!queryType.equalsIgnoreCase("SELECT")) {
			try {
				statement.executeUpdate(sqlQuery);
				System.out.println(sqlQuery + "executed");

				return true;
			} catch (SQLException e) {
				System.err.println("SQLState: "
						+ ((SQLException) e).getSQLState());
				System.err.println("Error Code: "
						+ ((SQLException) e).getErrorCode());
				System.err.println("Message: " + e.getMessage());
				return false;
			}
		}
		// select
		else if (queryType.equalsIgnoreCase("select")) {
			try {
				rs = statement.executeQuery(sqlQuery);
				ResultSetMetaData rsmd = rs.getMetaData();
				System.out.println("SQL Query Executed:" + sqlQuery);
				numberColumns = rsmd.getColumnCount();

				return true;
			} catch (SQLException e) {
				e.printStackTrace();
				return false;
			}
		}
		return true;
	}

	public boolean displayResults(String tableName) 
	{
		try {

			while (rs.next()) {
				for (int i = 1; i <= numberColumns; i++) {
					if (i > 1)
						System.out.print(",  ");
					String columnValue = rs.getString(i);
					System.out.print(columnValue);
				}
				System.out.println("");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return true;
	}

	public List<String> listTables() {
		List<String> tableList = null;
		try {

			resultSet = databaseMetaData.getTables(null, userName, null, TABLE_TYPES);
			resultSet.last();
			int numberRows = resultSet.getRow();
			tableList = new ArrayList<String>(numberRows);

			resultSet.beforeFirst();

			String tableName = "";
			if (resultSet != null) {
				while (resultSet.next()) {
					tableName = resultSet.getString("TABLE_NAME"); // what is table
															// Name

					if (tableName.length() < 4)
						tableList.add(tableName);
					else if (!tableName.substring(0, 4)
							.equalsIgnoreCase("BIN$"))
						tableList.add(tableName);
				}
			}
		} catch (SQLException e) {
			System.err.println("SQLState: " + ((SQLException) e).getSQLState());
			System.err.println("Error Code: "
					+ ((SQLException) e).getErrorCode());
			System.err.println("Message: " + e.getMessage());

		}
		System.out.println("table list = " + tableList);
		return tableList;
	}

	public int countColumnsAndRows() {
		int colCount = 0;
		int rowCount = 0;
		try {

			colCount = rs.getMetaData().getColumnCount();
			System.out.println("Column Count = " + colCount);
			rs.last();
			rowCount = rs.getRow();
			
			System.out.println("Row Count = " + rowCount);

		} catch (SQLException e) {
			System.err.println("SQLState: " + ((SQLException) e).getSQLState());
			System.err.println("Error Code: "
					+ ((SQLException) e).getErrorCode());
			System.err.println("Message: " + e.getMessage());

		}
		return colCount;
	}
	
	
	
	
	public boolean executeSQL(String sqlQuery) {
		// TODO Auto-generated method stub
		
		this.sqlQuery = sqlQuery;
		// System.out.println("queryType:" + queryType);
		int result=0;
		if(status== false) {
		System.out.println("Not connected to database");
		return false;
		}
		
		if (!queryType.equalsIgnoreCase("select")) 
		{ // not SELECT
			try {
				//statement.executeUpdate(sqlQuery);
				if (queryType.equalsIgnoreCase("create")) {
					try {
						result = statement.executeUpdate(sqlQuery);
						message = " Table created successfully";
					} catch (Exception e) {
						message = " Table already exists";
					}

				}
				if (queryType.equalsIgnoreCase("insert")) {
					try {
						statement.executeUpdate(sqlQuery);
						message = "Table row inserted successfully";
					} catch (Exception e) {
						message = " insert failed";
					}

				} if (queryType.equalsIgnoreCase("drop")) {
					try {
						statement.executeUpdate(sqlQuery);
						message = " Table dropped successfully";
					} catch (Exception e) {
						message = " No such table exists";
					}

				}else if (queryType.equalsIgnoreCase("truncate")) {
					try {
						statement.executeUpdate(sqlQuery);
						message = " Table truncated successfully";
					} catch (Exception e) {
						message = " No such table exists";
					}

				}
				return true;
			}
		catch(NullPointerException e) {
			message = "Error";
			e.printStackTrace();
		return false;
		}
		
		}
		else
		{
			// SELECT
			try {
			resultSet = statement.executeQuery(sqlQuery);
			rs = resultSet;
			
			// printException("SQL query executed:" + sqlQuery);
			return true;
			}
			catch(SQLException e) {
				e.printStackTrace();
			return false;
			}
		}
		
		
	}
	
	
	public boolean generateResult() {

		renderResult = true;

		try {
		result =  ResultSupport.toResult(rs);
		ResultSetMetaData rsmd = rs.getMetaData();
		numberColumns = rsmd.getColumnCount();
		numberRows =  result.getRowCount();
		}
		catch (SQLException e) {
		// TODO Auto-generated catch block
		// e.printStackTrace();
		renderResult = false;
		return false;
		}
		catch (Exception e) {
		// TODO Auto-generated catch block
		// e.printStackTrace();
		renderResult = false;
		return false;
		}
		String columnNameList [] = result.getColumnNames();
		columnNames = new ArrayList<String>(numberColumns);
		for(int i=0; i<numberColumns; i++) {
		columnNames.add(columnNameList[i]);
		}
		return true;
		}

	public DbUserInfo getDbUserInfo() {
		return dbUserInfo;
	}

	public void setDbUserInfo(DbUserInfo dbUserInfo) {
		this.dbUserInfo = dbUserInfo;
	}

	public Result getResult() {
		return result;
	}

	public void setResult(Result result) {
		this.result = result;
	}

	public ResultSet getRs() {
		return rs;
	}

	public void setRs(ResultSet rs) {
		this.rs = rs;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public String getDbSchema() {
		return dbSchema;
	}

	public void setDbSchema(String dbSchema) {
		this.dbSchema = dbSchema;
	}

	public String getDbms() {
		return dbms;
	}

	public void setDbms(String dbms) {
		this.dbms = dbms;
	}
	
	/**
	 * @return the queryType
	 */
	public String getQueryType() {
		return queryType;
	}





	/**
	 * @param queryType the queryType to set
	 */
	public void setQueryType(String queryType) {
		this.queryType = queryType;
	}

	public String getSqlQuery() {
		return sqlQuery;
	}

	public void setSqlQuery(String sqlQuery) {
		this.sqlQuery = sqlQuery;
	}

	public ResultSet getMetaDatarsmd() {
		return MetaDatarsmd;
	}

	public void setMetaDatarsmd(ResultSet metaDatarsmd) {
		MetaDatarsmd = metaDatarsmd;
	}

	public int getNumberRows() {
		return numberRows;
	}

	public void setNumberRows(int numberRows) {
		this.numberRows = numberRows;
	}

	public boolean isRenderResult() {
		return renderResult;
	}

	public void setRenderResult(boolean renderResult) {
		this.renderResult = renderResult;
	}
	/**
	 * @return the columnNames
	 */
	public ArrayList<String> getColumnNames() {
		return columnNames;
	}
	/**
	 * @return the numberColumns
	 */
	public int getNumberColumns() {
		return numberColumns;
	}

	/**
	 * @param numberColumns the numberColumns to set
	 */
	public void setNumberColumns(int numberColumns) {
		this.numberColumns = numberColumns;
	}




	/**
	 * @param columnNames the columnNames to set
	 */
	public void setColumnNames(ArrayList<String> columnNames) {
		this.columnNames = columnNames;
	}
	/**
	 * @return the resultSet
	 */
	public ResultSet getResultSet() {
		return resultSet;
	}





	/**
	 * @param resultSet the resultSet to set
	 */
	public void setResultSet(ResultSet resultSet) {
		this.resultSet = resultSet;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}


}
