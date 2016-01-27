<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>

<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>

<%@ taglib prefix="t"  uri="http://myfaces.apache.org/tomahawk"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<f:view>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>DatabaseAccess</title>



<style>

.CreateTables:hover {
    color: red;
    font-weight:bold;
}
.DropTables:hover {
    color: red;
}
.ListTables:hover {
    color: red;
}

.DisplayTablecontents:hover {
    color: red;
}
.Deleteallrows:hover {
    color: red;
}

.Insertdummyrows:hover {
    color: red;
}
.Deleteallrows:hover {
    color: red;
}
.Logout:hover {
    color: red;
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
	<f:verbatim>
<center>
	<a href="index.jsp">HOME|</a>
	&nbsp;&nbsp;&nbsp;
	
	</center>
	
	<hr></hr>
	<br />
	</f:verbatim>
		<center>
			<h:form>
			<h:outputText styleClass="order-table-th" value="Table name" />
			<h:selectOneListbox value="#{actionBeanDatabaseAccess.tableName}" size="3">
				<f:selectItem itemValue="bmi" />
				<f:selectItem itemValue="loanCalc" />
				<f:selectItem itemValue="Dummy" />
			</h:selectOneListbox>
			
				<h:commandButton type="submit" styleClass="CreateTables" value="Create Tables"
					action="#{actionBeanDatabaseAccess.createTables}" />
					
				<h:commandButton type="submit" styleClass="DropTables" value="Drop Tables"
					action="#{actionBeanDatabaseAccess.dropTables}" />
					
				<h:commandButton type="submit" styleClass="ListTables"  value="List Tables"
					action="#{actionBeanDatabaseAccess.displayTables}" />
					
				<h:commandButton type="submit" styleClass="DisplayTablecontents" value="Display Table contents"
					action="#{actionBeanDatabaseAccess.displayContents}" />
					
				<h:commandButton type="submit" styleClass="Deleteallrows" value="Delete all rows"
					action="#{actionBeanDatabaseAccess.truncateTables}" />
					
				<h:commandButton type="submit" styleClass="Insertdummyrows" value="Insert dummy rows"
					action="#{actionBeanDatabaseAccess.insertTempData}" />
					<br><br>
						<center>
<h:commandButton type="submit" styleClass="Logout" value="Logout"
				action="#{actionBeanDB.processLogout}" /></center>
					
				
					
<%-- 					<h:commandButton type="submit" value="Delete all rows" --%>
<%-- 					action="#{actionBeanDatabaseAccess.____________}" /> --%>
					
					
<!-- 					<a href="fileImport.xhtml">Import Worksheet</a> -->
<%-- 					<h:commandButton type="submit" value="Insert Tables bmi" --%>
<%-- 					action="#{actionBeanDatabaseAccess.insertTable_bmi}" /> --%>
<%-- 					<h:commandButton type="submit" value="Insert Tables loan" --%>
<%-- 					action="#{actionBeanDatabaseAccess.insertTable_loan}" /> --%>
<%-- 				<h:commandButton type="action" value="Export Worksheet" --%>
<%-- 					action="#{actionBeanDatabaseAccess.exportWorksheet}" /> --%>
					<br><br>
					<h:outputText style="color:red"  value="#{dbaccess.message}"/>
			</h:form>
		</center>
	
		<br />
		<hr />
		<br />

		<%-- <h:outputText value="#{messageBean.errorMessage}" />
		<h:outputText value="#{messageBean.message}" /> --%>

		<h:panelGrid columns="2" rendered="#{dbaccess.renderResult}">
			<h:outputText value="SQL query:" />
			<h:outputText value="#{dbaccess.sqlQuery}" />
			<h:outputText value="Column names:" />
			<h:outputText value="#{dbaccess.columnNames}" />
			<h:outputText value="Number of columns:" />
			<h:outputText value="#{dbaccess.numberColumns}" />
			<h:outputText value="Number of rows:" />
			<h:outputText value="#{dbaccess.numberRows}" />
		</h:panelGrid>

		<f:verbatim>
			<br />
			<hr />
			<br />
		</f:verbatim>


		<div style="background-attachment: scroll; overflow: auto; height: 400px; background-repeat: repeat">

			<t:dataTable value="#{dbaccess.result}" var="row"
				rendered="#{dbaccess.renderResult}" border="1" cellspacing="0"
				cellpadding="1" columnClasses="columnClass1 border"
				headerClass="headerClass" footerClass="footerClass"
				rowClasses="rowClass2" styleClass="dataTableEx" width="900">

				<t:columns var="col" value="#{dbaccess.columnNames}">

					<f:facet name="header">
						<t:outputText styleClass="outputHeader" value="#{col}" />
					</f:facet>

					<t:outputText styleClass="outputText" value="#{row[col]}" />
				</t:columns>

			</t:dataTable>

		</div>

		<f:verbatim>
			<br />
			<hr />
			<br />
		</f:verbatim>



	</body>
</html>
</f:view>
