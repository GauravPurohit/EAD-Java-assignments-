<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
<%@ taglib prefix="t"  uri="http://myfaces.apache.org/tomahawk"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<f:view>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>bmiCalculator</title>

<style>
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
<center>
<h4>IDS 517 s15g101_gpuroh2: WELCOME !!</h4>
<!--  <a href="index.jsp">Home</a> &nbsp;&nbsp;  <a href="http://en.wikipedia.org/wiki/Body_mass_index" target="_blank">Wiki reference - BMI calculator</a> 
--><br>
</center>
<div align="center">
<h:form>
	<h:panelGrid columns="2" styleClass="order-table">
	
	<h:outputText styleClass="order-table-th" value="userName"/>
	<h:inputText styleClass="order-table-td" id="userName" value= "#{dbaccess.userName }"/>
	
	<h:outputText styleClass="order-table-th" value="password"/>
	<h:inputSecret styleClass="order-table-td" id="password" value="#{dbaccess.password}"/>
	
	<h:outputText styleClass="order-table-th" value="db"/>
		<h:selectOneListbox value="#{dbaccess.dbms}" size="3">
			<f:selectItem itemValue="MySql"/>
			<f:selectItem itemValue="DB2"/>
			<f:selectItem itemValue="Oracle"/>
		</h:selectOneListbox>
		
		<h:outputText styleClass="order-table-th" value="host"/>
		<h:selectOneListbox value="#{dbaccess.host}" size="3">
			<f:selectItem itemValue="localhost"/>
			<f:selectItem itemValue ="131.193.209.54" itemLabel="server-54"/>
			<f:selectItem itemValue ="131.193.209.57" itemLabel="server-57"/>
		</h:selectOneListbox>
		
			<h:outputText styleClass="order-table-th" value="databaseschema"/>
		<h:selectOneListbox value="#{dbaccess.dbSchema}" size="1">
			<f:selectItem itemValue="feedback"/>
			<f:selectItem itemValue="s15g101"/>
		</h:selectOneListbox>
		<br><br><center>
		<h:commandButton type="submit" value="Login" action="#{actionBeanDB.processLogin}"/></center>
<%-- 	<h:outputText style="color:red" id="message" value="#{dbaccess.errormessage}" /> --%>
	
				
		</h:panelGrid>
</h:form> 
</div>
</body>
</html>
</f:view>
