package uic.edu.ids.actionbean;


import uic.edu.ids517.bmibean.BmiBean;
import uic.edu.ids517.bmibean.DBAccessBean;
import uic.edu.ids517.bmibean.MessageBean;

	
	
	public class ActionBeanDatabaseAccess { 

	private DBAccessBean dbaccess; 
	private MessageBean messageBean; 
	private BmiBean bmibean;
	private String tableName;

		
		public String createTables() {
		messageBean.setMessage("");
		messageBean.setErrorMessage("");
		dbaccess.setQueryType("CREATE");
		
		if(tableName.equalsIgnoreCase("bmi"))
		{
			dbaccess.executeSQL(SQLConstants.CREATE_BMI_TABLE);
		}
		
		else if(tableName.equalsIgnoreCase("loanCalc"))
		{
			dbaccess.executeSQL(SQLConstants.CREATE_Loan_TABLE);
		}
			
		else if(tableName.equalsIgnoreCase("Dummy"))
		{
			dbaccess.executeSQL(SQLConstants.CREATE_DUMMY_TABLE);
		}
		
		return "SUCCESS";
		}
		

		public String insertTable_bmi() {
		messageBean.setMessage("");
		messageBean.setErrorMessage("");
		dbaccess.setQueryType("INSERT");
		dbaccess.executeSQL(SQLConstants.INSERT_USER_BMITABLE);
		return "SUCCESS";
		}
		
//		public String insertTable_bmitry() {
//			messageBean.setMessage("");
//			messageBean.setErrorMessage("");
//			dbaccess.setQueryType("INSERT");
//			dbaccess.executeSQL("insert into bmi values('Gaurav','"+bmibean.getUnits()+"',"+bmibean.getWeight()+","+bmibean.getHeight()+","+bmibean.getBmi()+","+bmibean.getBmiPrime()+",'"+bmibean.getCategory()+"'");
//			return "SUCCESS";
//			}
		
		public String truncateTables() 
		{
			
			messageBean.setMessage("");
			messageBean.setErrorMessage("");
			dbaccess.setQueryType("TRUNCATE");
			if(tableName.equalsIgnoreCase("bmi"))
			{
				dbaccess.executeSQL(SQLConstants.TRUNCATE_BMI_TABLE);
			}
			
			else if(tableName.equalsIgnoreCase("loanCalc"))
			{
				dbaccess.executeSQL(SQLConstants.TRUNCATE_Loan_TABLE);
			}
				
			else if(tableName.equalsIgnoreCase("Dummy"))
			{
				dbaccess.executeSQL(SQLConstants.TRUNCATE_DUMMY_TABLE);
			}
			return "SUCCESS";
		}
		
		
		public String insertTempData() 
		{
			
			messageBean.setMessage("");
			messageBean.setErrorMessage("");
			dbaccess.setQueryType("INSERT");
			if(tableName.equalsIgnoreCase("bmi"))
			{
				dbaccess.executeSQL(SQLConstants.INSERT_TEMP_BMITABLE);
			}
			
			else if(tableName.equalsIgnoreCase("loanCalc"))
			{
				dbaccess.executeSQL(SQLConstants.INSERT_TEMP_LoanTABLE);
			}
				
			else if(tableName.equalsIgnoreCase("Dummy"))
			{
				dbaccess.executeSQL(SQLConstants.INSERT_TEMP_DUMMYTABLE);
			}
			return "SUCCESS";
		}
		

		public String insertTable_loan() {
		messageBean.setMessage("");
		messageBean.setErrorMessage("");
		dbaccess.setQueryType("INSERT");
		dbaccess.executeSQL(SQLConstants.INSERT_USER_LOANTABLE);
		return "SUCCESS";
		}
		
		
		
		public String displayContents() 
		{
			messageBean.setMessage("");
			messageBean.setErrorMessage("");
			dbaccess.setQueryType("SELECT");
			
			if(tableName.equalsIgnoreCase("bmi"))
			{
				messageBean.setMessage("");
				messageBean.setErrorMessage("");
				dbaccess.setQueryType("SELECT");
				dbaccess.executeSQL(SQLConstants.SELECT_USER_BMITABLE);
				dbaccess.generateResult();
//				dbaccess.displayResults("BMI");
				return "SUCCESS";
			}
			else if(tableName.equalsIgnoreCase("loanCalc"))
			{
				messageBean.setMessage("");
				messageBean.setErrorMessage("");
				dbaccess.setQueryType("SELECT");
				dbaccess.executeSQL(SQLConstants.SELECT_USER_LOANTABLE);
				dbaccess.generateResult();
				return "SUCCESS";
			}
			else if(tableName.equalsIgnoreCase("Dummy"))
			{
				messageBean.setMessage("");
				messageBean.setErrorMessage("");
				dbaccess.setQueryType("SELECT");
				dbaccess.executeSQL(SQLConstants.SELECT_USER_DUMMYTABLE);
				dbaccess.generateResult();
				return "SUCCESS";
			}
			return "SUCCESS";
		}
		
		
		public String dropTables() {
		messageBean.setMessage("");
		messageBean.setErrorMessage("");
		dbaccess.setQueryType("DROP");
		
		
		if(tableName.equalsIgnoreCase("bmi"))
		{
			dbaccess.executeSQL(SQLConstants.DROP_BMI_TABLE);
		}
		
		else if(tableName.equalsIgnoreCase("loanCalc"))
		{
			dbaccess.executeSQL(SQLConstants.DROP_Loan_TABLE);
		}
			
		else if(tableName.equalsIgnoreCase("Dummy"))
		{
			dbaccess.executeSQL(SQLConstants.DROP_DUMMY_TABLE);
		}
		return "SUCCESS";
		}
		
		public String displayTables() {
		messageBean.setMessage("");
		messageBean.setErrorMessage("");
		dbaccess.setQueryType("SELECT");
		
		dbaccess.executeSQL(SQLConstants.SELECT_USER_TABLE);
		dbaccess.generateResult();
		return "SUCCESS";
		}
		
//		public String imortWorksheet(){
//			return "SUCCESS";
//		}
//		
//		public String exportWorksheet(){
//			return "SUCCESS";
//		}

		/**
		 * @return the dbase
		 */
		public DBAccessBean getdbaccess() {
			return dbaccess;
		}

		/**
		 * @param dbase the dbase to set
		 */
		public void setdbaccess(DBAccessBean dbase) {
			this.dbaccess = dbase;
		}

		/**
		 * @return the message
		 */
		public MessageBean getMessageBean() {
			return messageBean;
		}

		/**
		 * @param message the message to set
		 */
		public void setMessageBean(MessageBean message) {
			this.messageBean = message;
		}


		public BmiBean getBmibean() {
			return bmibean;
		}


		public void setBmibean(BmiBean bmibean) {
			this.bmibean = bmibean;
		}


		public String getTableName() {
			return tableName;
		}


		public void setTableName(String tableName) {
			this.tableName = tableName;
		}
		
		


}
