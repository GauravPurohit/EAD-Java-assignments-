package uic.edu.ids517.bmibean;

import java.util.ArrayList;
import java.util.List;

/*import edu.uic.ids.model.LoanCalculator.LoanCalculator;
import uic.edu.ids517.bmibean.BmiBean;*/

public class ActionLoanCalculator {
	
	private LoanCalculator loanCalculator;
	private List <LoanCalculator> loanCalculatorList;
	private boolean renderList;

	public ActionLoanCalculator() {
	
		renderList = false;
		setLoanCalculatorList(new ArrayList <LoanCalculator> ());
	}
	
	/*public String computeLOAN() throws CloneNotSupportedException {
		String status = loanCalculator.computeLoan();
		LoanCalculator loanClone = loanCalculator.clone();
		
		if(loanCalculator.getErrorcode() == 0)
		{	
		loanCalculatorList.add(loanClone);
		renderList = true;
		}
		return status;
	}*/
	
	public String computeLOAN() throws CloneNotSupportedException {
		String status = loanCalculator.computeLoan();
		LoanCalculator loanClone = loanCalculator.clone();
		
		if (loanCalculator.getErrorcode() == 0)
		{
			loanCalculatorList.add(loanClone);
			renderList = true;
		}
		
		return status;
	}

		public String reset() 
	{
		loanCalculatorList.clear();
		renderList = false;
		return "SUCCESS";
	}

	public LoanCalculator getLoanCalculator() {
		return loanCalculator;
	}

	public void setLoanCalculator(LoanCalculator loanCalculator) {
		this.loanCalculator = loanCalculator;
	}

	public List<LoanCalculator> getLoanCalculatorList() {
		return loanCalculatorList;
	}

	public void setLoanCalculatorList(List<LoanCalculator> loanCalculatorList) {
		this.loanCalculatorList = loanCalculatorList;
	}

	public boolean isRenderList() {
		return renderList;
	}

	public void setRenderList(boolean renderList) {
		this.renderList = renderList;
	}

}
