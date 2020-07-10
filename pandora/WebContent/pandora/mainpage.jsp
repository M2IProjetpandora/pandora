<html>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<f:view>
	<head>
<title>Page principale Pandora</title>
	</head>
	<body>
		<h1>Bienvenue</h1>
		<h:outputText value="Bienvenue sur Pandora #{loginBean.membreCourant.prenom} #{loginBean.membreCourant.nom}"/>

		<h:form prependId="false">
			<ul>
				<li><h:commandButton value="gestion des roles"
						action="rolecontroller" /></li>
				<li><h:commandButton value="gestion des opérations"
						action="operationcontroller" /></li>
				<li><h:commandButton value="gestion des membres"
						action="membrecontroller" /></li>
						
			</ul>
		</h:form>
	</body>
</f:view>
</html>