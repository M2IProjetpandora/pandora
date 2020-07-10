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
				<h:outputText
					value="Les identifiants ne sont pas corrects, reesayer" />
			</h3>
			<table>
				<tr>
					<td colspan="2"><h:commandButton value="reesayer"
							action="login" /></td>
				</tr>
			</table>
		</h:form>
	</body>
</f:view>
</html>