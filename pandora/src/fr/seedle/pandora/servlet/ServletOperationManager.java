package fr.seedle.pandora.servlet;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.seedle.pandora.bean.PandoraBean;
import fr.seedle.pandora.dao.OperationDaoImpl;
import fr.seedle.pandora.dto.OperationDto;
import fr.seedle.pandora.interfaces.dao.OperationDao;

@WebServlet(name = "ServletOperationManager", urlPatterns = { "/jsp/ServletOperationManager.html" })
public class ServletOperationManager extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4248675924091455371L;

	/***
	 * Initialisation de la Servlet
	 */
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
	}

	/***
	 * traite une requete http
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	/***
	 * traite une requete http
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		getPage(request, response);
	}

	/***
	 * Resultat du traitement
	 */
	public void getPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");

		final String theAction = request.getParameter("action");
		if (theAction == null) {
			response.getWriter().write("veuillez précisez une action à réaliser");

		} else {
			switch (theAction) {
			case "insert":

				final HttpSession session = request.getSession(false);
				System.out.println("session id " + session.getId());

				final OperationDao operationDao = new OperationDaoImpl();
				final OperationDto operationDto = operationDao.getInstance();

				final PandoraBean bean = (PandoraBean) session.getAttribute("pandoraBean");
				System.out.println("bean : " + bean);
				bean.setOperationCourante(operationDto);

				response.sendRedirect("/pandora-webapp/pandora/operation/OperationController.jsp");
				break;

			case "update":
				response.getWriter().write("modifier une opération");
				break;

			case "delete":
				response.getWriter().write("supprimer une opération");
				break;

			default:
				response.getWriter().write("le cas " + theAction + " n'est pas prévu");
				break;

			}

			response.getWriter().flush();
		}
	}
}
