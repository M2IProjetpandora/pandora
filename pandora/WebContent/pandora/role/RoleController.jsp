<html>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<f:view>
	<head>
<meta charset="UTF-8">
<title>Gestion des roles</title>
	</head>
	<body>

		<h1>Gestion de roles</h1>
		<h2>
			Actuellement connecté
			<h:outputText
				value="#{loginBean.membreCourant.prenom} #{loginBean.membreCourant.nom}" />
		</h2>

		<h:form>
			<h:dataTable value="#{roleControllerListBean.listRoles}" var="role"
				rendered="#{loginBean.membreCourant.role == null}">
				<h:column>
					<f:facet name="header">Role </f:facet>
					<h:outputText value="#{role.nom} " />
					<h:commandButton value="Sélectioner"
						actionListener="#{roleControllerListBean.onSelect(role)}" />
				</h:column>
			</h:dataTable>

			<h3>
				Vous êtes
				<h:panelGroup rendered="#{loginBean.membreCourant.role != null}">
					<h:outputText value="#{loginBean.membreCourant.role.nom}" />
					<h:commandButton value="changer de role"
						actionListener="#{roleControllerListBean.deSelect()}" />
				</h:panelGroup>
				<h:outputText rendered="#{loginBean.membreCourant.role == null}"
					value="je ne sait pas! " />
			</h3>

		</h:form>
	</body>
</f:view>
</html>