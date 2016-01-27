package uic.edu.ids517.bmibean;

public class DbUserInfo  {

	//enter ther user and password you use to connect to MySql on your machine
	/*
	private String userName = "root";
	private String password = "root";
	private String dbms;
	private String dbmsHost = "localhost";
	private String databaseSchema = "feedback";
		*/
		
	private String userName ;
	private String password ;
	private String dbms;
	private String dbmsHost ;
	private String databaseSchema;
	
	/*
	// details needed to connect the Mysql server on 131.193.209.54 
	private String userName = "s15g101";
	private String password = "s15g101QRcdX";
	private String dbms;
	//private String dbmsHost = "131.193.209.54";
	private String dbmsHost = "131.193.209.57";
	private String databaseSchema = "feedback"; 
	*/
	
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
	public String getDbms() {
		return dbms;
	}
	public void setDbms(String dbms) {
		this.dbms = dbms;
	}
	public String getDbmsHost() {
		return dbmsHost;
	}
	public void setDbmsHost(String dbmsHost) {
		this.dbmsHost = dbmsHost;
	}
	public String getDatabaseSchema() {
		return databaseSchema;
	}
	public void setDatabaseSchema(String databaseSchema) {
		this.databaseSchema = databaseSchema;
	}
	
	
	
}
