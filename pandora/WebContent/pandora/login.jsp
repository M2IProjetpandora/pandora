<html>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<f:view>
	<head>
<title><h:outputText value="identification" /></title>
	</head>
	<body>
		<h:form>
			<h3>
				<h:outputText value="#{loginBean.message}" />
			</h3>
			<table>
				<tr>
					<td><h:outputText value="login" /> :</td>
					<td><h:inputText value="#{loginBean.login}" /></td>
				</tr>
				<tr>
					<td><h:outputText value="password" /> :</td>
					<td><h:inputSecret value="#{loginBean.password}" /></td>
				</tr>
				<tr>
					<td colspan="2"><h:commandButton value="me connecter"
							action="#{loginBean.identificationMembre}"/></td>
				</tr>
			</table>
		</h:form>
	</body>
</f:view>
</html>