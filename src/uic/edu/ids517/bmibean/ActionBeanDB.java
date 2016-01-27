package uic.edu.ids517.bmibean;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



public class ActionBeanDB {
	 
	private DBAccessBean dbaccess;
	private DbUserInfo dbUserInfo;
	
	
	
	
	public String processLogin() {

	
		String  result = "FAIL";
		boolean res =false;
		try {
			 res= dbaccess.connectToDB();
			 
			 if(res){
			  result="SUCCESS";}
			 else{
				 result="FAIL";
			 }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			result = "FAIL";
			e.printStackTrace();
		}
		return result;
		
		}	
	
	public String processLogout() {

		String  result = "NO";
		boolean status =false;
		try {
			 status= dbaccess.closeConnection();
			 
			 if(status){
			  result="YES";}
			 else{
				 result="NO";
			 }
		} catch (Exception e) {
			// TODO Auto-generated catch block
			result = "NO";
			e.printStackTrace();
		}
		return result;
		
		}
	

	
	
	//private List <BmiBean> bmiBeanList;
	//private boolean renderList;
	
	
	
	


	public ActionBeanDB() {
		// TODO Auto-generated constructor stub
	//	renderList = false;
		
	//	setBmiBeanList(new ArrayList <BmiBean> ());		
	}


	public DBAccessBean getDbaccess() {
		return dbaccess;
	}


	public void setDbaccess(DBAccessBean dbaccess) {
		this.dbaccess = dbaccess;
	}


	
	/*public void connectToDB () throws SQLException 
	{
	dbaccessbean.connectToDB();
	}
*/
    
	
     
/*	
	public String reset()
	{
		bmiBeanList.clear();
		renderList = false;
		return "SUCCESS";
	}

*/
	
	
}
