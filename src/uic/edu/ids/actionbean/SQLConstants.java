package uic.edu.ids.actionbean;

import uic.edu.ids517.bmibean.DBAccessBean;

public class SQLConstants {


	/*public static final String CREATE_BMI_TABLE = "CREATE TABLE BMI (units varchar(35), weight varchar(35), height varchar(35), bmi double, bmiPrime double, category varchar(50))";
	public static final String CREATE_Loan_TABLE = "CREATE TABLE Loan (principal varchar(50), downPayment varchar(50), interestRate varchar(50), term varchar(50),monthlyPayment double, TotalInterest double, Total_WithDP double, Total_WithoutDP double)";
	public static final String CREATE_DUMMY_TABLE = "CREATE TABLE Dummy (id varchar(16), name varchar(20), age int, salary double)";*/
	
	public static final String CREATE_BMI_TABLE =   "CREATE TABLE IF NOT EXISTS bmi (user VARCHAR(60), "
    												+ "units VARCHAR(10) NOT NULL,"
    												+ "weight VARCHAR(10) NOT NULL, "
    												+ "height VARCHAR(10) NOT NULL, "
    												+ "bmi VARCHAR(10),"
    												+ "bmiprime VARCHAR(10),"
    												+ "category VARCHAR(50));";
	
	public static final String CREATE_Loan_TABLE = "CREATE TABLE IF NOT EXISTS loanCalc (user VARCHAR(60), "
	    											+ "principal VARCHAR(10) NOT NULL,"
	    											+ "downpayment VARCHAR(10) NOT NULL, "
	    											+ "interestRate VARCHAR(10) NOT NULL, "
	    											+ "loanTerm VARCHAR(10) NOT NULL, "
	    											+ "monthlyPayment VARCHAR(10), "
	    											+ "totalPayments VARCHAR(10), "
	    											+ "totalInterestPaid VARCHAR(10), "
	    											+ "monthlyPaymentWithDP VARCHAR(10), "
	    											+ "totalPaymentsWithDP VARCHAR(10), "
	    											+ "totalInterestPaidWithDP VARCHAR(10));";
	
	public static final String CREATE_DUMMY_TABLE = "CREATE TABLE IF NOT EXISTS Dummy (id varchar(16) NOT NULL, "
													+ "name varchar(20) NOT NULL, " 
													+ "age int NOT NULL, " 
													+ "salary double NOT NULL);";
	
	
	public static final String DROP_BMI_TABLE ="DROP TABLE bmi";
	public static final String DROP_Loan_TABLE ="DROP TABLE loanCalc";
	public static final String DROP_DUMMY_TABLE ="DROP TABLE Dummy";
	
	public static final String TRUNCATE_DUMMY_TABLE ="TRUNCATE TABLE Dummy";
	public static final String TRUNCATE_Loan_TABLE ="TRUNCATE TABLE loanCalc";
	public static final String TRUNCATE_BMI_TABLE ="TRUNCATE TABLE bmi";
	
	public static final String SELECT_USER_TABLE =	"Show tables from feedback";
	public static final String SELECT_USER_BMITABLE =	"Select * from bmi";
	public static final String SELECT_USER_LOANTABLE =	"Select * from loanCalc";
	public static final String SELECT_USER_DUMMYTABLE =	"Select * from Dummy";
	
	public static final String INSERT_TEMP_BMITABLE = "insert into bmi values('SI', '85','1.8',26.23,1.05,'Overweight')";
	public static final String INSERT_TEMP_LoanTABLE = "insert into loanCalc values('10000', '2000','12','2',376.59,1038.11,11038.11,9038.11)";
	public static final String INSERT_TEMP_DUMMYTABLE = "insert into Dummy values('660412807','Venkatesh Iyer',24,50000)";
	
	
	public static String INSERT_USER_BMITABLE;
	public static String INSERT_USER_LOANTABLE;


	public static String getINSERT_USER_BMITABLE() {
		return INSERT_USER_BMITABLE;
	}
	public void setINSERT_USER_BMITABLE(String iNSERT_USER_BMITABLE) {
		INSERT_USER_BMITABLE = iNSERT_USER_BMITABLE;
	}
	public static String getINSERT_USER_LOANTABLE() {
		return INSERT_USER_LOANTABLE;
	}
	public void setINSERT_USER_LOANTABLE(String iNSERT_USER_LOANTABLE) {
		INSERT_USER_LOANTABLE = iNSERT_USER_LOANTABLE;
	}

}
