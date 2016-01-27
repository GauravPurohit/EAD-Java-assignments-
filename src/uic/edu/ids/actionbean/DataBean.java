package uic.edu.ids.actionbean;

import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped

public class DataBean {

	  


	private String variableName;
	private String dataType;
	private String variableType;
	private String dataValue;

	private ArrayList<String>dataTypeList= new ArrayList<String>(4);

	public DataBean(){
	          // TODO Auto-generatedconstructorstub
	      }
@PostConstruct
	public void init(){
	dataTypeList.add("string");
	dataTypeList.add("integer");
	dataTypeList.add("double");
	dataTypeList.add("date");
	      }
/**
 * @return the variableName
 */
public String getVariableName() {
	return variableName;
}
/**
 * @param variableName the variableName to set
 */
public void setVariableName(String variableName) {
	this.variableName = variableName;
}
/**
 * @return the dataType
 */
public String getDataType() {
	return dataType;
}
/**
 * @param dataType the dataType to set
 */
public void setDataType(String dataType) {
	this.dataType = dataType;
}
/**
 * @return the variableType
 */
public String getVariableType() {
	return variableType;
}
/**
 * @param variableType the variableType to set
 */
public void setVariableType(String variableType) {
	this.variableType = variableType;
}
/**
 * @return the dataValue
 */
public String getDataValue() {
	return dataValue;
}
/**
 * @param dataValue the dataValue to set
 */
public void setDataValue(String dataValue) {
	this.dataValue = dataValue;
}
/**
 * @return the dataTypeList
 */
public ArrayList<String> getDataTypeList() {
	return dataTypeList;
}
/**
 * @param dataTypeList the dataTypeList to set
 */
public void setDataTypeList(ArrayList<String> dataTypeList) {
	this.dataTypeList = dataTypeList;
} 

}
