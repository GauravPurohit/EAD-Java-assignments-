package uic.edu.ids517.bmibean;

import java.io.Serializable;
import java.text.DecimalFormat;

import uic.edu.ids.actionbean.ActionBeanDatabaseAccess;
import uic.edu.ids.actionbean.SQLConstants;
import uic.edu.ids517.bmibean.*;

public class LoanCalculator implements Serializable, Cloneable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
		// Computational inputs //
		private double months;
		ActionBeanDatabaseAccess actionBeanDatabaseAccess;
		
		// inputs //
		private String purchaseprice;
		private String downpayment;
		private String annualinterestrate;
		private String loanterm;
		
		//output //
		private double monthlypayment;
		private double totalpayment_nodownpayment;
		private double totalpayment_withdownpayment;
		private double totalinterest;
		
		// Error //
		private String errorMessage = " ";
		private int errorcode;
		
		public int getErrorcode() {
			return errorcode;
		}

		public void setErrorcode(int errorcode) {
			this.errorcode = errorcode;
		}

		DecimalFormat df  = new DecimalFormat("0.00");
	
		public LoanCalculator() 
		{
		
			purchaseprice = " ";
			downpayment = " ";
			annualinterestrate = " ";
			loanterm = " ";
			months = 0.0; 
			errorMessage = " ";
			errorcode = 0;
	    }
		
		public LoanCalculator clone() throws CloneNotSupportedException
		{
			LoanCalculator cloned = (LoanCalculator) super.clone();
			return cloned;
		}
		
		// Computation of Monthly payment, Total payment (with and without down payment)
		// and Total interest to be paid
		public String computeLoan()
		{
			String status = "SUCCESS";
		
			try {
		
				double dpurchaseprice=Double.parseDouble(purchaseprice);
				double ddownpayment=Double.parseDouble(downpayment);
				double dannualinterestrate=Double.parseDouble(annualinterestrate);
				double dloanterm=Double.parseDouble(loanterm);
				
				if(ddownpayment >=0 && dpurchaseprice >0 && dannualinterestrate >0 && dloanterm >0 && dpurchaseprice>= ddownpayment)
				{
				errorcode = 0;
				errorMessage = " ";
				months = dloanterm * 12;
				monthlypayment = ((dannualinterestrate/1200) + ((dannualinterestrate/1200)/(Math.pow((1+(dannualinterestrate/1200)), months)-1)))* (dpurchaseprice-ddownpayment);
				totalpayment_nodownpayment = monthlypayment * months;
				totalpayment_withdownpayment = totalpayment_nodownpayment + ddownpayment;
				totalinterest = totalpayment_withdownpayment - dpurchaseprice;
			 
				monthlypayment = Double.parseDouble(df.format(monthlypayment));
				totalpayment_nodownpayment = Double.parseDouble(df.format(totalpayment_nodownpayment));
				totalpayment_withdownpayment = Double.parseDouble(df.format(totalpayment_withdownpayment));
				totalinterest = Double.parseDouble(df.format(totalinterest));
				
				}
				else {
					if(ddownpayment>dpurchaseprice)
					{
						errorcode = 1;
						this.setErrorMessage("Please correct the downpayment value!");
						this.setDownpayment("0.0");
						this.setMonthlypayment(0);
						this.setTotalpayment_nodownpayment(0);
						this.setTotalpayment_withdownpayment(0);
						
					}
					else {
					errorcode = 1;
					this.setErrorMessage(" Please input non-zero/positive numbers only!");
					this.setDownpayment("0.0");
					this.setMonthlypayment(0);
					this.setTotalpayment_nodownpayment(0);
					this.setTotalpayment_withdownpayment(0);
					}
				}
				}
				
				catch(Exception e){
					
					errorcode = 1;
					this.setErrorMessage("Input numbers only!");
					this.setDownpayment("0.0");
                    this.setPurchaseprice("0.0");
                    this.setAnnualinterestrate("0.0");
                    this.setLoanterm("0.0");
				}
				
				return status;
		
		// Setters and Getter methods for input and output variables declared
		}

		
		public void updateLoanTable()
		{
//			Connection before BMI table creation
			
//				Create table BMI
				try
				{
					actionBeanDatabaseAccess.setTableName("loanCalc");
					System.out.println("Table name set to Loan in LoanCalculator");
					actionBeanDatabaseAccess.createTables();
					System.out.println("Loan table created before inserting records");
				}
				catch(NullPointerException e)
				{
					System.out.println("Loan Table already exists");
				}

//				Insert the records after the calculation
				try
				{
					String insertLoanQuery = "insert into loanCalc values('Gaurav' , '" + purchaseprice + "','" + downpayment + "','" + annualinterestrate + "','" + loanterm + "','" + monthlypayment + "','"+ totalpayment_nodownpayment + "','" + totalinterest + "','NA','" +totalpayment_withdownpayment + "','NA')";
					System.out.println("Insert string is: "+insertLoanQuery);
					
					SQLConstants.INSERT_USER_LOANTABLE =insertLoanQuery;
					System.out.println("Insert string is set to:"+SQLConstants.INSERT_USER_LOANTABLE);
					
				}
				catch(Exception e)
				{
					System.out.println("Exception: While setting the SQL Insert string");
				}
				
				try
				{
					actionBeanDatabaseAccess.insertTable_loan();
					System.out.println("Record inserted into the Loan table");
				}
				catch(Exception e)
				{
					System.out.println("Exception: While Insert statement execution");
				}
		}
		
		
		public ActionBeanDatabaseAccess getActionBeanDatabaseAccess() {
			return actionBeanDatabaseAccess;
		}

		public void setActionBeanDatabaseAccess(
				ActionBeanDatabaseAccess actionBeanDatabaseAccess) {
			this.actionBeanDatabaseAccess = actionBeanDatabaseAccess;
		}

		public double getMonths() {
			return months;
		}

		public void setMonths(double months) {
			this.months = months;
		}

		public String getPurchaseprice() {
			return purchaseprice;
		}

		public void setPurchaseprice(String purchaseprice) {
			this.purchaseprice = purchaseprice;
		}

		public String getDownpayment() {
			return downpayment;
		}

		public void setDownpayment(String downpayment) {
			this.downpayment = downpayment;
		}

		public String getAnnualinterestrate() {
			return annualinterestrate;
		}

		public void setAnnualinterestrate(String annualinterestrate) {
			this.annualinterestrate = annualinterestrate;
		}

		public String getLoanterm() {
			return loanterm;
		}

		public void setLoanterm(String loanterm) {
			this.loanterm = loanterm;
		}

		public double getMonthlypayment() {
			return monthlypayment;
		}

		public void setMonthlypayment(double monthlypayment) {
			this.monthlypayment = monthlypayment;
		}

		public double getTotalpayment_nodownpayment() {
			return totalpayment_nodownpayment;
		}

		public void setTotalpayment_nodownpayment(double totalpayment_nodownpayment) {
			this.totalpayment_nodownpayment = totalpayment_nodownpayment;
		}

		public double getTotalpayment_withdownpayment() {
			return totalpayment_withdownpayment;
		}

		public void setTotalpayment_withdownpayment(double totalpayment_withdownpayment) {
			this.totalpayment_withdownpayment = totalpayment_withdownpayment;
		}

		public double getTotalinterest() {
			return totalinterest;
		}

		public void setTotalinterest(double totalinterest) {
			this.totalinterest = totalinterest;
		}

		public String getErrorMessage() {
			return errorMessage;
		}

		public void setErrorMessage(String errorMessage) {
			this.errorMessage = errorMessage;
		}

		public DecimalFormat getDf() {
			return df;
		}

		public void setDf(DecimalFormat df) {
			this.df = df;
		}

}