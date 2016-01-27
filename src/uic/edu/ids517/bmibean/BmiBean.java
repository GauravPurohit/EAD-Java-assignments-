package uic.edu.ids517.bmibean;

import java.io.Serializable;
import java.sql.SQLException;
import java.text.DecimalFormat;

import uic.edu.ids.actionbean.ActionBeanDatabaseAccess;
import uic.edu.ids.actionbean.SQLConstants;

public class BmiBean implements Serializable, Cloneable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private DBAccessBean dbaccess;
	private String status;
	//SQLConstants sqlConstants;
	ActionBeanDatabaseAccess actionBeanDatabaseAccess;
	
	//Temp varables
	private int i=1;
	
	//inputs //
	private String units;
	private String weight;
	private String height;
	
	//output//
	private double bmi;
	private double bmiPrime;
	private String category;
	
	//error messages//
	private String errormessage;
	private int errorcode;
	private String returncode;
	
	DecimalFormat df = new DecimalFormat("0.00");
	
	//categories
	public static final String [] category_list  = {"Very severely underweight","Severely underweight","Underweight","Normal (healthy weight)","Overweight","Obese Class I (Moderately obese)","Obese Class II (Severely obese)","Obese Class III (Very severely obese)"};
	public static final double [] bmi_range = {15,16,18.5,25,30,35,40};
	public static final double bmi_prime_range [] = {0.6,0.64,0.74,1.0,1.2,1.4,1.6};
	
	public BmiBean() {
	category = "[Undefined]";
	units = "";
	returncode = "ABC";
	height = "0.0";
	weight = "0.0";
	bmi=0.0;
	bmiPrime=0.0;
	errorcode = 0;
	}
	
	public BmiBean clone() throws CloneNotSupportedException {
		BmiBean cloned = (BmiBean) super.clone();
		return cloned;
	}
	
	public String computeBmi() 
	{
		status  = "Fail";
		
		try {
			
			double dweight=Double.parseDouble(weight);
			double dheight=Double.parseDouble(height);
		
		if(dheight>=0 && dweight >0)
		{
			errorcode = 0;
		if(units.equalsIgnoreCase("SI"))
		{
			status = "SUCCESS";
			bmi= dweight/(dheight*dheight);
			bmiPrime = bmi/25;
			
			bmi = Double.parseDouble(df.format(bmi));
			bmiPrime = Double.parseDouble(df.format(bmiPrime));
			
		}
		else
		{
			status = "SUCCESS";
			bmi=703.0 * dweight/(dheight*dheight);
			bmiPrime = bmi/25;
			
			bmi = Double.parseDouble(df.format(bmi));
			bmiPrime = Double.parseDouble(df.format(bmiPrime));
		}
		
		
		for(i=0;i<7;i++)
		{
			if(bmi < bmi_range[i])
			{
			category = category_list[i];
			break;
			}
			else
			{
			category = category_list[i+1];
			}
		}
		
		return status;
		}
		
		else {
			if(dheight<=0 && dweight<=0 || dheight<=0 || dweight<=0 )
			{
			this.setErrormessage("Non-zero/Positive numbers only!");
			errorcode = 1;
			this.setHeight("0.0");
			this.setWeight("0.0");
			this.setCategory("Undefined");
			this.setBmi(0);
			this.setBmiPrime(0);
			return status;
			}

		}
		}
		catch (Exception e){
			errorcode = 1;
			this.setErrormessage("Input numbers only!");
			this.setHeight("0.0");
			this.setWeight("0.0");
			this.setCategory("Undefined");
			
		}		
		return status;
	}	
	
	
	
	
//	
////	To insert records into the table BMI
//	
	
	public void updateBmiTable()
	{
//		Connection before BMI table creation
		
//			Create table BMI
			try
			{
				actionBeanDatabaseAccess.setTableName("bmi");
				System.out.println("Table name set to BMI in BmiBean");
				actionBeanDatabaseAccess.createTables();
				System.out.println("BMI table created before inserting records");
			}
			catch(NullPointerException e)
			{
				System.out.println("BMI Table already exists");
			}

//			Insert the records after the calculation
			try
			{
				String insertBmiQuery = "insert into bmi values('Gaurav','" + units + "','" + weight + "','" + height + "','"+ bmi + "','"+ bmiPrime + "','"+ category + "')";
				System.out.println("Insert string is: "+insertBmiQuery);
				
				SQLConstants.INSERT_USER_BMITABLE =insertBmiQuery;
				System.out.println("Insert string is set to:"+SQLConstants.INSERT_USER_BMITABLE);
				
			}
			catch(NullPointerException e)
			{
				System.out.println("setting the SQL Insert string");
			}
			
			try
			{
				actionBeanDatabaseAccess.insertTable_bmi();
				System.out.println("Record inserted into the BMI table");
			}
			catch(Exception e)
			{
				System.out.println("Insert statement execution");
			}
	}

	public int getI() {
		return i;
	}

	public void setI(int i) {
		this.i = i;
	}

	public String getUnits() {
		return units;
	}

	public void setUnits(String units) {
		this.units = units;
	}

	public String getWeight() {
		return weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}

	public String getHeight() {
		return height;
	}

	public void setHeight(String height) {
		this.height = height;
	}

	public double getBmi() {
		return bmi;
	}

	public void setBmi(double bmi) {
		this.bmi = bmi;
	}

	public double getBmiPrime() {
		return bmiPrime;
	}

	public void setBmiPrime(double bmiPrime) {
		this.bmiPrime = bmiPrime;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getErrormessage() {
		return errormessage;
	}

	public void setErrormessage(String errormessage) {
		this.errormessage = errormessage;
	}

	public int getErrorcode() {
		return errorcode;
	}

	public void setErrorcode(int errorcode) {
		this.errorcode = errorcode;
	}

	public String getReturncode() {
		return returncode;
	}

	public void setReturncode(String returncode) {
		this.returncode = returncode;
	}

	public static String[] getCategoryList() {
		return category_list;
	}

	public static double[] getBmiRange() {
		return bmi_range;
	}

	public static double[] getBmiPrimeRange() {
		return bmi_prime_range;
	}

	public DBAccessBean getDbaccess() {
		return dbaccess;
	}

	public void setDbaccess(DBAccessBean dbaccess) {
		this.dbaccess = dbaccess;
	}

	public ActionBeanDatabaseAccess getActionBeanDatabaseAccess() {
		return actionBeanDatabaseAccess;
	}

	public void setActionBeanDatabaseAccess(
			ActionBeanDatabaseAccess actionBeanDatabaseAccess) {
		this.actionBeanDatabaseAccess = actionBeanDatabaseAccess;
	}	
	

}
