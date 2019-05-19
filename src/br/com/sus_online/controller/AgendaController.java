package br.com.sus_online.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.sus_online.model.AgendaConsulta;
import br.com.sus_online.model.Autentica_Usuario;
import br.com.sus_onlineDao.model.DaoConsultasExames;

/**
 * Servlet implementation class AgendaController
 */
@WebServlet("/AgendaController")
public class AgendaController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private DaoConsultasExames daoConsultaExame = new DaoConsultasExames();
	DaoConsultasExames dao = new DaoConsultasExames();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AgendaController() {
		super();
		// TODO Auto-generated constructor stub
	}

	private void processarAgenda(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getParameter("action");

		if (action == null) {
			throw new ServletException("No action specified.");
		} else if (action.equals("consulta_agenda")) {
			irParaAgenda(request, response);
		} else if (action.equals("agendar_consulta")) {
			irAgendarConsulta(request, response);
		}else if(action.contentEquals("agendar_exame")){
			irAgendarExame(request, response);
		}
	}

	private void irAgendarExame(HttpServletRequest request, HttpServletResponse response) {
		RequestDispatcher rd = null;
		rd = request.getRequestDispatcher("view/agendarExame.jsp");

		try {
			rd.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}

		
	}

	// Metodo para agendar Consulta
	private void irAgendarConsulta(HttpServletRequest request, HttpServletResponse response) {

		RequestDispatcher rd = null;
		rd = request.getRequestDispatcher("view/agendarConsulta.jsp");

		try {
			rd.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	// Metodo para exibir a agenda do paciente
	private void irParaAgenda(HttpServletRequest request, HttpServletResponse response) {

		try {
			HttpSession sessao = request.getSession();
			Autentica_Usuario usu = (Autentica_Usuario) sessao.getAttribute("user");

			List<AgendaConsulta> agenda = daoConsultaExame.getLista(usu.getId());
			
			if (agenda.size() > 0) {
				request.setAttribute("listaAgenda", agenda);
				request.setAttribute("temAgenda", true);
			}
			else {
				request.setAttribute("temAgenda", false);
			}
			
			request.getRequestDispatcher("view/exibeAgenda.jsp").forward(request, response);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		processarAgenda(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession sessao = request.getSession();
		Autentica_Usuario usu = (Autentica_Usuario) sessao.getAttribute("user");
		/*
		 * Autentica_Usuario user = null; try { DaoUsuario dao = new DaoUsuario();//
		 * Cria uma instancia do DAO usuario user = dao.findByUser(usu.getUsuario()); }
		 * catch (Exception e) {
		 * 
		 * }
		 */

		String data = request.getParameter("data");
		String hora = request.getParameter("hora");
		String cidade = request.getParameter("cidade");
		String estado = request.getParameter("estado");
		String ubs = request.getParameter("ubs");
		String medico = request.getParameter("medico");
		String especialidade = request.getParameter("especialidade");

		AgendaConsulta agenda = new AgendaConsulta();

		agenda.setData(data);
		agenda.setHora(hora);
		agenda.setCidade(cidade);
		agenda.setEstado(estado);
		agenda.setUbs(ubs);
		agenda.setMedico(medico);
		agenda.setEspecialidade(especialidade);
		agenda.setIdUsuario(usu.getId());
		try {

			
			List<AgendaConsulta> agendaMarcada = daoConsultaExame.getLista(usu.getId());
			
			
			boolean agendar = true;
			for (AgendaConsulta ag : agendaMarcada) {
				String d1 = agenda.getData();
				String d2 = ag.getData();
				String h1 = agenda.getHora();
				String h2 = ag.getHora();
				if (d1.equals(d2) && h1.equals(h2)) {
					agendar = false;
					break;
				}
			}
			if (agendar) {

				daoConsultaExame.salvar(agenda);
				request.setAttribute("mensagem", "Salvo");
				request.getRequestDispatcher("view/sucessoAgendamento.jsp").forward(request, response);
			}
			else {
				String msg = "Já existe uma consulta no mesmo dia e horário.";
				request.setAttribute("mensagem", msg);
				request.getRequestDispatcher("view/falhaAgendamento.jsp").forward(request, response);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
