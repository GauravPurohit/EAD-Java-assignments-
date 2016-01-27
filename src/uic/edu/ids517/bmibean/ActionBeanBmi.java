package uic.edu.ids517.bmibean;

import java.util.ArrayList;
import java.util.List;




public class ActionBeanBmi {
	private BmiBean bmiBean;
	private List <BmiBean> bmiBeanList;
	private boolean renderList;

	
	public ActionBeanBmi() {
		// TODO Auto-generated constructor stub
		renderList = false;
		
		setBmiBeanList(new ArrayList <BmiBean> ());
		
		
	}
	
	public String computeBmi() 
	{
		String status = bmiBean.computeBmi();
		
/*		if(status.equalsIgnoreCase("SUCCESS"))
		{
//			Create table BMI
			try
			{
				actionBeanDatabaseAccess.setTableName("BMI");
				actionBeanDatabaseAccess.createTables();
			}
			catch(Exception e)
			{
				System.out.println("Table already exists");
			}

//			Insert the records after the calculation
			sqlConstants.setINSERT_USER_BMITABLE("insert into BMI values(" + bmiBean.getUnits() + "," + bmiBean.getWeight() + "," + bmiBean.getHeight() + ","+ bmiBean.getBmi() + ","+ bmiBean.getBmiPrime() + ","+ bmiBean.getCategory() + ",");
			actionBeanDatabaseAccess.insertTable_bmi();
		}*/

		/*System.out.println("1");*/
		try{
			BmiBean bmiClone = bmiBean.clone();
			if(bmiBean.getErrorcode() == 0)
			{
				bmiBeanList.add(bmiClone);
				renderList = true;
			}
			/*System.out.println("2");*/
			
		}catch(Exception ee){
			ee.printStackTrace();
			/*System.out.println("333");*/
		}
		
		
		//bmiBeanList.get(bmiBeanList.size());
		/*renderList = true;*/	
		
		return status;
	}

	
	public String reset()
	{
		bmiBeanList.clear();
		renderList = false;
		return "SUCCESS";
	}

	public BmiBean getBmiBean() {
		return bmiBean;
	}

	public void setBmiBean(BmiBean bmiBean) {
		this.bmiBean = bmiBean;
	}

	public List<BmiBean> getBmiBeanList() {
		return bmiBeanList;
	}

	public void setBmiBeanList(List<BmiBean> bmiBeanList) {
		this.bmiBeanList = bmiBeanList;
	}

	public boolean isRenderList() {
		return renderList;
	}

	public void setRenderList(boolean renderList) {
		this.renderList = renderList;
	}


	
	
}
