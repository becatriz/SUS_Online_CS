package br.com.sus_online.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
import br.com.sus_onlineDao.model.DaoConsultaseExames;

/**
 * Servlet implementation class ConsultasController
 */
@WebServlet("/ConsultasController")
public class ConsultasController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private DaoConsultaseExames daoConsultaExame = new DaoConsultaseExames();
	DaoConsultaseExames dao = new DaoConsultaseExames();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ConsultasController() {
		super();
		// TODO Auto-generated constructor stub
	}

	private void processarAgenda(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getParameter("action");

		if (action == null) {
			throw new ServletException("No action specified.");
		} else if (action.equals("consulta_agenda")) {
			String dt1 = request.getParameter("dataIni");
			irParaAgenda(request, response);
		} else if (action.equals("agendar_consulta")) {
			irAgendarConsulta(request, response);
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

			String dataIni = request.getParameter("dataIni");
			String dataFim = request.getParameter("dataIni");
			String dataInicio = null; 
			String dataFinal = null;
			if (dataIni != null && !dataIni.isEmpty()) {
				//SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
				dataInicio = dataIni;
			}
			if (dataFim != null && !dataFim.isEmpty()) {
				SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
				dataFinal = dataFim;
			}

			Autentica_Usuario usu = (Autentica_Usuario) sessao.getAttribute("user");
			List<AgendaConsulta> agenda = new ArrayList<AgendaConsulta>();
			if (dataInicio == null && dataFinal == null) {
				agenda = daoConsultaExame.getLista(usu.getId());
			}
			else if (dataInicio != null && dataFinal != null) {
				agenda = daoConsultaExame.getListaPeriodoConsulta(usu.getId(), dataInicio, dataFinal);
			}

			if (agenda.size() > 0) {
				request.setAttribute("listaAgenda", agenda);
				request.setAttribute("temAgenda", true);
			} else {
				request.setAttribute("temAgenda", false);
			}

			request.getRequestDispatcher("view/exibeAgendaConsulta.jsp").forward(request, response);
			//request.getRequestDispatcher("view/teste.jsp").forward(request, response);
			

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
	
		
		String action = request.getParameter("action");

		if (action != null && action.equals("consulta_agenda")) {
			String dt1 = request.getParameter("dataIni");
			irParaAgenda(request, response);
		}

		String data = request.getParameter("data");
		String hora = request.getParameter("hora");
		String estado = request.getParameter("estado");
		String cidade = request.getParameter("cidade");
		String ubs = request.getParameter("ubs");
		String especialidade = request.getParameter("especialidade");
		String medico = request.getParameter("medico");

		if (data.equals("null") || hora.equals("null") || estado.equals("null") || cidade.equals("null")
				|| ubs.equals("null") || especialidade.equals("null") || medico.equals("null")) {
			String msg = "Todos os campos devem estar preenchidos.";
			request.setAttribute("mensagem", msg);
			request.getRequestDispatcher("view/agendarConsulta.jsp").forward(request, response);
		}

		AgendaConsulta agenda = new AgendaConsulta();

		agenda.setData(data);
		agenda.setHora(hora);
		agenda.setEstado(estado);
		agenda.setCidade(cidade);
		agenda.setUbs(ubs);
		agenda.setMedico(especialidade);
		agenda.setEspecialidade(medico);
		agenda.setIdUsuario(usu.getId());
		agenda.setNome(usu.getNome());
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

				daoConsultaExame.salvarConsulta(agenda);
				request.setAttribute("mensagem", "Salvo");
				request.getRequestDispatcher("view/sucessoAgendamento.jsp").forward(request, response);
			} else {
				String msg = "Já existe uma consulta no mesmo dia e horário.";
				request.setAttribute("mensagem", msg);
				request.getRequestDispatcher("view/falhaAgendamento.jsp").forward(request, response);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
