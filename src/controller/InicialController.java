package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.tanesha.recaptcha.ReCaptcha;
import net.tanesha.recaptcha.ReCaptchaFactory;
import net.tanesha.recaptcha.ReCaptchaImpl;
import net.tanesha.recaptcha.ReCaptchaResponse;

/**
 * Servlet implementation class InicialController
 */
@WebServlet("/InicialController")
public class InicialController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public InicialController() {
		super();
	}

	private void processarRequisicao(HttpServletRequest request, HttpServletResponse response) throws ServletException {

		String action = request.getParameter("action");

		if (action == null) {
			throw new ServletException("No action specified.");
		} else if (action.equals("iniciar_criar_conta")) {
			irParaIniciarCriarConta(request, response);
		} else if (action.equals("home_barra_superior")) {
			irParaHome(request, response);
		} else if (action.equals("iniciar_login_conta")) {
			irParaLogin(request, response);
		}
	}

	// Metodo para ir a pagina de novos cadastros
	private void irParaIniciarCriarConta(HttpServletRequest request, HttpServletResponse response) {

		RequestDispatcher rd = null;
		rd = request.getRequestDispatcher("view/criar_conta.jsp");

		try {
			rd.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Metodo que volta a pagina Home
	private void irParaHome(HttpServletRequest request, HttpServletResponse response) {

		RequestDispatcher rd = null;
		rd = request.getRequestDispatcher("view/index.jsp");

		

		try {
			rd.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Metodo para fazer Login
	private void irParaLogin(HttpServletRequest request, HttpServletResponse response) {

		RequestDispatcher rd = null;
		rd = request.getRequestDispatcher("view/login.jsp");

		try {
			rd.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processarRequisicao(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		processarRequisicao(request, response);
	}
}