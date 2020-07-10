<html>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<f:view>
	<head>
<meta charset="UTF-8">
<title>Gestion des membres</title>
	</head>
	<body>

		<h1>Gestion de membres</h1>

		<h:form>
			<h:dataTable value="#{membreControllerListBean.listMembres}" var="membre">
				<h:column>
					<f:facet name="header">Membre</f:facet>
					<h:outputText value="#{membre.nom} " />
				</h:column>
				
				<h:column>
					<f:facet name="header">Pseudo </f:facet>
					<h:outputText value="#{membre.pseudo} " />
				</h:column>
				
				
				<h:column>
					<h:commandButton value="Sélectioner"
						actionListener="#{membreControllerListBean.onSelect(membre)}" />
				</h:column>
				
			</h:dataTable>
			
			<h3> Vous êtes <h:outputText value="#{membreControllerListBean.membre.nom}" />
			</h3>
			
		</h:form>
	</body>
</f:view>
</html>