package br.com.sus_online.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.sus_online.model.AgendaConsulta;
import br.com.sus_online.model.AgendaExame;
import br.com.sus_online.model.Autentica_Usuario;
import br.com.sus_online.model.Medicamento;
import br.com.sus_online.model.Vacina;
import br.com.sus_onlineDao.model.DaoConsultaseExames;
import br.com.sus_onlineDao.model.DaoMedicacaoVacina;
import br.com.sus_onlineDao.model.DaoUsuario;

/**
 * Servlet implementation class VacinaMedicacao
 */
/**
 * @author becat
 *
 */
@WebServlet("/VacinaMedicacao")
public class VacinaMedicacao extends HttpServlet {
	private static final long serialVersionUID = 2L;

	private DaoMedicacaoVacina daoVacinas = new DaoMedicacaoVacina();
	private DaoMedicacaoVacina daoMedicamentos = new DaoMedicacaoVacina();
	private DaoConsultaseExames daoConExame = new DaoConsultaseExames();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public VacinaMedicacao() {
		super();

	}

	private void irParaVacinaMedicacao(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getParameter("action");

		if (action == null) {
			throw new ServletException("No action specified.");
		} else if (action.equals("medicacao")) {
			irParaMedicacao(request, response);
		} else if (action.equals("vacina")) {
			irParaVacina(request, response);
		} else if (action.equals("prontuario")) {
			irParaProntuario(request, response);
		}
	}

	private void irParaProntuario(HttpServletRequest request, HttpServletResponse response) {

		try {
			getListaMedicacao(request);
			getListaVacina(request);
			
			HttpSession sessao = request.getSession();
			Autentica_Usuario usu = (Autentica_Usuario) sessao.getAttribute("user");
			List<AgendaExame> agendaExame = new ArrayList<AgendaExame>();
			agendaExame = daoConExame.getListaExame(usu.getId());
			if (agendaExame.size() > 0) {
				request.setAttribute("listaAgendaExame", agendaExame);
				
			}
			
			List<AgendaConsulta> agendaConsulta = new ArrayList<AgendaConsulta>();
			agendaConsulta = daoConExame.getLista(usu.getId());
			
		
			if (agendaConsulta.size() > 0) {
				request.setAttribute("listaAgenda", agendaConsulta);
			} 
			
			request.getRequestDispatcher("view/prontuario.jsp").forward(request, response);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void irParaVacina(HttpServletRequest request, HttpServletResponse response) {
		try {
			getListaVacina(request);

			request.getRequestDispatcher("view/vacinas.jsp").forward(request, response);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void getListaVacina(HttpServletRequest request) {
		HttpSession sessao = request.getSession();
		Autentica_Usuario usu = (Autentica_Usuario) sessao.getAttribute("user");

		List<Vacina> agendaVacin = daoVacinas.getListaVacinas(usu.getId());

		if (agendaVacin.size() > 0) {
			request.setAttribute("listaVacinas", agendaVacin);
			request.setAttribute("temAgenda", true);
		} else {
			request.setAttribute("temAgenda", false);
		}
	}

	private void irParaMedicacao(HttpServletRequest request, HttpServletResponse response) {
		try {

			getListaMedicacao(request);

			request.getRequestDispatcher("view/medicacoes.jsp").forward(request, response);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void getListaMedicacao(HttpServletRequest request) {
		HttpSession sessao = request.getSession();
		Autentica_Usuario usu = (Autentica_Usuario) sessao.getAttribute("user");

		List<Medicamento> agendaVacin = daoMedicamentos.getListaMedicamentos(usu.getId());

		if (agendaVacin.size() > 0) {
			request.setAttribute("listaMedicamentos", agendaVacin);
			request.setAttribute("temAgenda", true);
		} else {
			request.setAttribute("temAgenda", false);
		}
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		irParaVacinaMedicacao(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

	}

}
