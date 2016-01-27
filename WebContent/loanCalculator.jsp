<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
<%@ taglib prefix="t"  uri="http://myfaces.apache.org/tomahawk"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>loanCalculator</title> <style>

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
<h3>IDS 517 s15g101_gpuroh2: Loan calculator</h3> 

<a href="index.jsp">Home</a> &nbsp;&nbsp; <a href="http://en.wikipedia.org/wiki/Mortgage_calculator" target="_blank">Wiki reference - BMI calculator</a>
<br><br><br>
 </center>
 <div align="center" >
 <h:form>
 
 <h:panelGrid columns="2" styleClass="order-table" >
 	
 	<h:outputText styleClass="order-table-th" value = "Purchase price"/>
 	<h:inputText styleClass="order-table-td" id = "purchasePrice" value="#{loanCalculator.purchaseprice}" />
 	
 	<h:outputText styleClass="order-table-th"  value = "Down Payment"/>
 	<h:inputText styleClass="order-table-td" id = "downPayment" value="#{loanCalculator.downpayment}" />
 	
 	<h:outputText styleClass="order-table-th"  value = "Annual Interest Rate"/>
 	<h:inputText styleClass="order-table-td" id = "annualInterestRate" value="#{loanCalculator.annualinterestrate}" />
 	
 	<h:outputText styleClass="order-table-th"  value = "Loan term"/>
 	<h:inputText styleClass="order-table-td" id = "loanTerm" value="#{loanCalculator.loanterm}" />
 	
 	<h:outputText value=""/>
 	<h:outputText value=""/>
 	
 	
 	
 	<h:commandButton type = "submit" styleClass="Hovernow" value="Reset" action="#{actionLoanCalculator.reset}"/>
 	<h:commandButton type="submit" styleClass="Hovernow" value="Calculate Loan" action="#{actionLoanCalculator.computeLOAN}"/>
 	<h:outputText style="color:red" id="message" value="#{loanCalculator.errorMessage}" />
 	<h:outputText value=""/>
 	
 	
 	<h:outputText styleClass="order-table-tm" value = "Monthly Payment"/>
 	<h:inputText styleClass="order-table-tm" id = "monthlyPayment" value="#{loanCalculator.monthlypayment}" />
 	
 	<h:outputText value=""/>
 	<h:outputText value=""/>
 	<h:outputText value=""/>
 	<h:outputText value=""/>
 	
 	<h:outputText styleClass="order-table-tm"  value = "Total Payment without Down Payment"/>
 	<h:inputText styleClass="order-table-tm"  id = "totalPaymentWithoutDownpayment" value="#{loanCalculator.totalpayment_nodownpayment}" />
 	
 	<h:outputText  styleClass="order-table-tm"  value = "Total Payment with Down Payment"/>
 	<h:inputText  styleClass="order-table-tm"  id = "totalPaymentWithDownpayment" value="#{loanCalculator.totalpayment_withdownpayment}" />
 	
 	<h:outputText  styleClass="order-table-tm"  value = "Total Interest"/>
 	<h:inputText  styleClass="order-table-tm"  id = "totalInterest" value="#{loanCalculator.totalinterest}" />
 	<br><center>
<h:commandButton type="submit" styleClass="Hovernow" value="Update BMI table" action="#{loanCalculator.updateLoanTable}"/> 
 </center>
 	<br>
 </h:panelGrid>
 <br>
 </h:form>
 </div>
 <div align = "center">
 	<t:dataTable
		value="#{actionLoanCalculator.loanCalculatorList}"
		var="rowNumber"
		rendered="#{actionLoanCalculator.renderList}"
		border="1" cellspacing="0" cellpadding="1"
		columnClasses="columnClass1 border"
		headerClass="headerClass"
		footerClass="footerClass"
		rowClasses="order-table-th"
		styleClass="dataTableEx"
		width="800">
		
		<h:column>
			<f:facet name="header">
				<h:outputText>Purchase Price</h:outputText>
			</f:facet>
			<h:outputText value="#{rowNumber.purchaseprice}"/>
		</h:column>
		
		<h:column>
			<f:facet name="header">
				<h:outputText>Down Payment</h:outputText>
			</f:facet>
			<h:outputText value="#{rowNumber.downpayment }"/>
		</h:column>
		
		<h:column>
			<f:facet name="header">
				<h:outputText>Annual Interest Rate</h:outputText>
			</f:facet>
			<h:outputText value="#{rowNumber.annualinterestrate }"/>
		</h:column>
		
		<h:column>
			<f:facet name="header">
				<h:outputText>Loan Term</h:outputText>
			</f:facet>
			<h:outputText value="#{rowNumber.loanterm }"/>
		</h:column>
		
		<h:column>
			<f:facet name="header">
				<h:outputText>Monthly Payment</h:outputText>
			</f:facet>
			<h:outputText value="#{rowNumber.monthlypayment }"/>
		</h:column>
		
		<h:column>
			<f:facet name="header">
				<h:outputText>Total Payment without Down payment</h:outputText>
			</f:facet>
			<h:outputText value="#{rowNumber.totalpayment_nodownpayment }"/>
		</h:column>
		
		<h:column>
			<f:facet name="header">
				<h:outputText>Total Payment with Down payment</h:outputText>
			</f:facet>
			<h:outputText value="#{rowNumber.totalpayment_withdownpayment }"/>
		</h:column>
		
		<h:column>
			<f:facet name="header">
				<h:outputText>Total Interest</h:outputText>
			</f:facet>
			<h:outputText value="#{rowNumber.totalinterest }"/>
		</h:column>
		
	</t:dataTable>
</div>

</f:view>
</body>
</html>