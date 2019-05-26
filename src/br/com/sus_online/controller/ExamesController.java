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
import br.com.sus_online.model.AgendaExame;
import br.com.sus_online.model.Autentica_Usuario;
import br.com.sus_onlineDao.*;
import br.com.sus_onlineDao.model.*;



/**
 * Servlet implementation class ExamesController
 */
/**
 * @author becat
 *
 */
@WebServlet("/ExamesController")
public class ExamesController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	private DaoConsultaseExames daoConExame = new DaoConsultaseExames();
	DaoConsultaseExames dao = new DaoConsultaseExames();
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ExamesController() {
        super();
        // TODO Auto-generated constructor stub
    }

	private void processarExames(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getParameter("action");

		if (action == null) {
			throw new ServletException("No action specified.");
		} else if (action.equals("consultar_exames")) {
			irConsultaExame(request, response);
		} else if (action.equals("agendar_exames")) {
			irAgendarExame(request, response);
		};
		
	}
    
	private void irConsultaExame(HttpServletRequest request, HttpServletResponse response) {
		try {
			HttpSession sessao = request.getSession();
			Autentica_Usuario usu = (Autentica_Usuario) sessao.getAttribute("user");

			List<AgendaExame> agenda = daoConExame.getListaExame(usu.getId());

			if (agenda.size() > 0) {
				request.setAttribute("listaAgendaExame", agenda);
				request.setAttribute("temAgenda", true);
			} else {
				request.setAttribute("temAgenda", false);
			}

			request.getRequestDispatcher("view/exibeAgendaExame.jsp").forward(request, response);

		} catch (Exception e) {
			e.printStackTrace();
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

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processarExames(request, response);
		
	}
	



	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

			//Pega a sessão
		HttpSession sessao = request.getSession();
		Autentica_Usuario usu = (Autentica_Usuario) sessao.getAttribute("user");
		
		
		String data = request.getParameter("data");
		String hora = request.getParameter("hora");
		String estado = request.getParameter("estado");
		String cidade = request.getParameter("cidade");
		String exame = request.getParameter("exame");
		String ubs = request.getParameter("ubs");
		
		
		if (data.equals("null") || hora.equals("null") || estado.equals("null") || cidade.equals("null") ||
				ubs.equals("null") || exame.equals("null")) {
				String msg = "Todos os campos devem estar preenchidos.";
				request.setAttribute("mensagem", msg);
				request.getRequestDispatcher("view/agendarExame.jsp").forward(request, response);
			}
			
		AgendaExame agendaExame = new AgendaExame();
		
		
		agendaExame.setData(data);
		agendaExame.setHora(hora);
		agendaExame.setEstado(estado);
		agendaExame.setCidade(cidade);
		agendaExame.setExame(exame);
		agendaExame.setUbs(ubs);
		agendaExame.setIdUsuario(usu.getId());
		agendaExame.setNome(usu.getNome());
		
		try {

			
			List<AgendaExame> agendaMarcada = daoConExame.getListaExame(usu.getId());
			
			
			boolean agendar = true;
			for (AgendaExame ag : agendaMarcada) {
				String d1 = agendaExame.getData();
				String d2 = ag.getData();
				String h1 = agendaExame.getHora();
				String h2 = ag.getHora();
				if (d1.equals(d2) && h1.equals(h2)) {
					agendar = false;
					break;
				}
			}
			if (agendar) {

				daoConExame.salvarExame(agendaExame);
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
