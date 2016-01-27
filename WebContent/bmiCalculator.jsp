<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
<%@ taglib prefix="t"  uri="http://myfaces.apache.org/tomahawk"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>bmiCalculator</title>

<style>

.Hovernow:hover {
    color: red;
    font-weight:bold;
}
.order-table{  
    width: auto%; 
	font-family: verdana,arial,sans-serif;
	font-size:11px;
	color:#333333;
	border-width: 1px;
	border-style: solid;
	border-color: #666666;
	border-collapse: collapse; 
	border: 1px solid #66666; 
}
.order-table-th
{
width: 100%;
font-family: verdana,arial,sans-serif;
	font-size:11px;
	margin-width: 20px;
	padding:7px;
	background-color: background: rgb(255,255,255); /* Old browsers */
background: -moz-linear-gradient(top,  rgba(255,255,255,1) 0%, rgba(229,229,229,1) 100%); /* FF3.6+ */
background: -webkit-gradient(linear, left top, left bottom, color-stop(0%,rgba(255,255,255,1)), color-stop(100%,rgba(229,229,229,1))); /* Chrome,Safari4+ */
background: -webkit-linear-gradient(top,  rgba(255,255,255,1) 0%,rgba(229,229,229,1) 100%); /* Chrome10+,Safari5.1+ */
background: -o-linear-gradient(top,  rgba(255,255,255,1) 0%,rgba(229,229,229,1) 100%); /* Opera 11.10+ */
background: -ms-linear-gradient(top,  rgba(255,255,255,1) 0%,rgba(229,229,229,1) 100%); /* IE10+ */
background: linear-gradient(to bottom,  rgba(255,255,255,1) 0%,rgba(229,229,229,1) 100%); /* W3C */
filter: progid:DXImageTransform.Microsoft.gradient( startColorstr='#ffffff', endColorstr='#e5e5e5',GradientType=0 ); /* IE6-9 */

}

.order-table-td{
font-family: verdana,arial,sans-serif;
	font-size:11px;
	padding:5px;
	margin-right:auto;
	border-color: #666666;
	background-color: background: rgb(252,255,244); /* Old browsers */
background: -moz-linear-gradient(top,  rgba(252,255,244,1) 1%, rgba(233,233,206,1) 100%); /* FF3.6+ */
background: -webkit-gradient(linear, left top, left bottom, color-stop(1%,rgba(252,255,244,1)), color-stop(100%,rgba(233,233,206,1))); /* Chrome,Safari4+ */
background: -webkit-linear-gradient(top,  rgba(252,255,244,1) 1%,rgba(233,233,206,1) 100%); /* Chrome10+,Safari5.1+ */
background: -o-linear-gradient(top,  rgba(252,255,244,1) 1%,rgba(233,233,206,1) 100%); /* Opera 11.10+ */
background: -ms-linear-gradient(top,  rgba(252,255,244,1) 1%,rgba(233,233,206,1) 100%); /* IE10+ */
background: linear-gradient(to bottom,  rgba(252,255,244,1) 1%,rgba(233,233,206,1) 100%); /* W3C */
filter: progid:DXImageTransform.Microsoft.gradient( startColorstr='#fcfff4', endColorstr='#e9e9ce',GradientType=0 ); /* IE6-9 */
;
}

.order-table-tm{
font-family: verdana,arial,sans-serif;
	font-size:11px;
	padding:2px;
	margin-right:auto;
	border-color: #666666;
background: #f2f9fe; /* Old browsers */
background: -moz-linear-gradient(top,  #f2f9fe 0%, #d6f0fd 100%); /* FF3.6+ */
background: -webkit-gradient(linear, left top, left bottom, color-stop(0%,#f2f9fe), color-stop(100%,#d6f0fd)); /* Chrome,Safari4+ */
background: -webkit-linear-gradient(top,  #f2f9fe 0%,#d6f0fd 100%); /* Chrome10+,Safari5.1+ */
background: -o-linear-gradient(top,  #f2f9fe 0%,#d6f0fd 100%); /* Opera 11.10+ */
background: -ms-linear-gradient(top,  #f2f9fe 0%,#d6f0fd 100%); /* IE10+ */
background: linear-gradient(to bottom,  #f2f9fe 0%,#d6f0fd 100%); /* W3C */
filter: progid:DXImageTransform.Microsoft.gradient( startColorstr='#f2f9fe', endColorstr='#d6f0fd',GradientType=0 ); /* IE6-9 */

}

</style>
</head>
<body>
<f:view>
<center>
<h3>IDS 517 s15g101_gpuroh2: BMI calculator</h3> 

<a href="index.jsp">Home</a> &nbsp;&nbsp; <a href="http://en.wikipedia.org/wiki/Body_mass_index" target="_blank">Wiki reference - BMI calculator</a>
<br><br><br>
 </center>

<div align="center" >
<h:form>
	<h:panelGrid columns="2" styleClass="order-table">
	
	<h:outputText styleClass="order-table-th" value="Units"/>
		<h:selectOneListbox value="#{bmiBean.units}" size="2">
			<f:selectItem itemValue="English/Imperial"/>
			<f:selectItem itemValue="SI"/>
		</h:selectOneListbox>
	
	<h:outputText styleClass="order-table-th" value="Weight"/>
	<h:inputText styleClass="order-table-td" id="weight" value="#{bmiBean.weight}"/>
	
	<h:outputText styleClass="order-table-th" value="Height"/>
	<h:inputText styleClass="order-table-td" id="height" value="#{bmiBean.height}"/>
	
	<h:outputText value=""/>
	<h:outputText value=""/>
	
	<h:commandButton type="submit" styleClass="Hovernow" value="Reset" action="#{actionBeanBmi.reset}"/>
	<h:commandButton type="submit" styleClass="Hovernow" value="Calculate BMI" action="#{actionBeanBmi.computeBmi}"/>		
	<!--<h:commandButton type="submit"  value="Update Tables" action="#{actionBeanDatabaseAccess.insertTable_bmitry}"/>
	-->	
	<h:outputText style="color:red" id="message" value="#{bmiBean.errormessage}" />
	
	<h:outputText value=""/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	
	<h:outputText styleClass="order-table-tm"  value="BMI"/>
	<h:inputText id="bmi" value="#{bmiBean.bmi}"/>
	
	<h:outputText styleClass="order-table-tm"  value="BMI Prime"/>
	<h:inputText id="bmiPrime" value="#{bmiBean.bmiPrime}"/>
	
	<h:outputText styleClass="order-table-tm"  value="BMI Category"/>
	<h:inputText id="category" value="#{bmiBean.category}"/>
	
	<br><center>
<h:commandButton type="submit" styleClass="Hovernow" value="Update BMI table" action="#{bmiBean.updateBmiTable}"/> 
 &nbsp; &nbsp; &nbsp; &nbsp;
</center>

	</h:panelGrid>
</h:form>
</div><br>

<div align = "center">
	<t:dataTable
		value="#{actionBeanBmi.bmiBeanList}"
		var="rowNumber"
		rendered="#{actionBeanBmi.renderList}"
		border="1" cellspacing="0" cellpadding="1"
		columnClasses="columnClass1 border"
		headerClass="headerClass"
		footerClass="footerClass"
		rowClasses="order-table-th"
		styleClass="dataTableEx"
		width="800">
		
		<h:column>
			<f:facet name="header">
				<h:outputText>units</h:outputText>
			</f:facet>
			<h:outputText value="#{rowNumber.units }"/>
		</h:column>
		<h:column>
			<f:facet name="header">
				<h:outputText>weight</h:outputText>
			</f:facet>
			<h:outputText value="#{rowNumber.weight }"/>
		</h:column>
		<h:column>
			<f:facet name="header">
				<h:outputText>height</h:outputText>
			</f:facet>
			<h:outputText value="#{rowNumber.height }"/>
		</h:column>
		<h:column>
			<f:facet name="header">
				<h:outputText>BMI</h:outputText>
			</f:facet>
			<h:outputText value="#{rowNumber.bmi }"/>
		</h:column>
		<h:column>
			<f:facet name="header">
				<h:outputText>BMI Prime</h:outputText>
			</f:facet>
			<h:outputText value="#{rowNumber.bmiPrime }"/>
		</h:column>
		<h:column>
			<f:facet name="header">
				<h:outputText>BMI Category</h:outputText>
			</f:facet>
			<h:outputText value="#{rowNumber.category }"/>
		</h:column>
		
	</t:dataTable>
	</div>


</f:view>
</body>
</html>