package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Autentica_Usuario;
import model.DaoUsuario;

/**
 * Servlet implementation class InicialController
 */
@WebServlet("/InicialController")
public class InicialController extends HttpServlet {
	private static final long serialVersionUID = 2L;

	public InicialController() {
		super();
	}

	private void processarRequisicao(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getParameter("action");

		if (action == null) {
			throw new ServletException("No action specified.");
		} else if (action.equals("home_barra_superior")) {
			irParaHome(request, response);
		} else if (action.equals("iniciar_login_conta")) {
			irParaLogin(request, response);
		}else if (action.equals("Login.do")) {
			voltarPaginaLogado(request, response);
		}
	}

	private void voltarPaginaLogado(HttpServletRequest request, HttpServletResponse response) {
		
		RequestDispatcher rd = null;
		rd = request.getRequestDispatcher("view/logado.jsp");

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

		HttpSession session = request.getSession(); // obtem a sessao do usuario caso exista

		Autentica_Usuario user = null;
		String login_form = request.getParameter("username");// Pega usuario vindo do formulario
		String senha_form = request.getParameter("password");// Pega senha vindo do formulario
		
		ValidarUsuarioSenha(request, response, session, login_form, senha_form);
		
		try {
			DaoUsuario dao = new DaoUsuario();// Cria uma instancia do DAO usuario
			user = dao.getUsuario(login_form, senha_form);
		} catch (Exception e) {

		}

		// Se não encontrou usuario no banco, redireciona para a pagina de erro!
		if (user == null) {
			session.invalidate();
			request.getRequestDispatcher("view/aviso_nao_tem_conta_criada.jsp").forward(request, response);
		} else {
			// se o dao retornar um usuario , coloca o mesmo na sessao
			session.setAttribute("user", user);
			request.getRequestDispatcher("view/logado.jsp").forward(request, response);

		}

	
	}



//Metodo de validação de senha e usuario caso fuja da regra 
private void ValidarUsuarioSenha(HttpServletRequest request, HttpServletResponse response, HttpSession session,
		String login_form, String senha_form) throws ServletException, IOException
	{
		if (login_form == null || login_form.isEmpty() ||  login_form.length() > 15 || login_form.length() < 6){
			session.invalidate();
			request.setAttribute("mensagem", "Usuário inválido; usuário deve ter entre 6 e 15 caracteres.");
			request.getRequestDispatcher("view/mensagem.jsp").forward(request, response);
		}
		for(int i = 0; i < login_form.length(); i++ ){
			char caracter = login_form.charAt(i);
			
			if (!(Character.isLetter(caracter) || Character.isDigit(caracter))){
				session.invalidate();
				request.setAttribute("mensagem", "Usuário inválido: usuário deve conter apenas letras, números ou caracteres '.' e '_'.");
				request.getRequestDispatcher("view/mensagem.jsp").forward(request, response);
			}
		}
		
		if (senha_form == null || senha_form.isEmpty() ||  senha_form.length() > 10 || senha_form.length() < 6){
			session.invalidate();
			request.setAttribute("mensagem", "Senha inválida: senha deve ter entre 6 e 15 caracteres.");
			request.getRequestDispatcher("view/mensagem.jsp").forward(request, response);
		}
		int contLetra = 0;
		int contNumero = 0;
		for(int i = 0; i < senha_form.length(); i++ ){
			char caracter = senha_form.charAt(i);
			
			if (!(Character.isLetter(caracter) || Character.isDigit(caracter) || caracter == '_' || caracter == '.')){
				session.invalidate();
				request.setAttribute("mensagem", "Senha inválida; senha deve conter apenas letras e números.");
				request.getRequestDispatcher("view/mensagem.jsp").forward(request, response);
			}
			else{
				if (Character.isLetter(caracter))
					contLetra++;
				else if (Character.isDigit(caracter))
					contNumero++;
			}
		}
		
		if (contLetra == 0 || contNumero == 0 ){
			session.invalidate();
			request.setAttribute("mensagem", "Senha inválida; senha deve conter letras e números.");
			request.getRequestDispatcher("view/mensagem.jsp").forward(request, response);
		}
	}

}
