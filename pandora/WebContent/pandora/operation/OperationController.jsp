<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="fr.seedle.pandora.singleton.*"%>
<%@ page import="fr.seedle.pandora.dto.*"%>

<%@ include file="../jspf/Header.jspf"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Gestion des opérations</title>
</head>
<body>
	<h1>Gestion des opérations</h1>
	<p>Accéder au Bean 'pandoraBean', extraire l'opération courante et
		l'afficher</p>

	<%
		final OperationDto operation = pandoraBean.getOperationCourante();
	System.out.println("operation : " + operation);
	%>
	<h1>
		vous modifiez l'opération
		<%=operation.getNom()%></h1>
	<p><%=operation.getDescription()%></p>

	<form>
		<ul>
			<li><label>nom</label><input type="text"
				value="<%=operation.getNom()%>" /></li>

			<li><label>description</label>
			<textarea><%=operation.getNom()%></textarea></li>
		</ul>

		<input type="submit" value="enregistrer" />
	</form>

</body>
</html>