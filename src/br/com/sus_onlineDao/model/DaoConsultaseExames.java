package br.com.sus_onlineDao.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.com.sus_online.model.AgendaConsulta;
import br.com.sus_online.model.AgendaExame;
import br.com.sus_online.model.EstadosCidades;

public class DaoConsultaseExames {

	public Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName("org.postgresql.Driver");
			connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/sus_online", "postgres", "root");

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return connection;
	}
	
	//Aqui será pego informações para apresentar nos labels as informações que estao no 
	//banco de dados
	
	public List<EstadosCidades> getListaEstados(){
		
		try {
			//Primeiro a conexao
			Connection c = this.getConnection();
			//Depois o PreparedStatement
			PreparedStatement  ps =null;
			//ResultSet
			ResultSet rs = null;
			
			
			//Recebe a Consulta
			
			ps = c.prepareStatement("select * from estado");
		
		
			//Executa a consulta
			rs = ps.executeQuery();
			
			List<EstadosCidades> listaEstados = new ArrayList<EstadosCidades>();
			
			while(rs.next()) {
				//Cria  objeto Estados
				EstadosCidades listEs = new EstadosCidades();
				
				listEs.setNomeEstado(rs.getString("nomeestado"));
				
				
				
				//add objeto a lista
				listaEstados.add(listEs);
				
				
			}
			rs.close();
			ps.close();
			return listaEstados;
			
			
			
		}catch (SQLException e) {
			throw new RuntimeException(e);
			
		}
	}
	
	
	
	
	
	
	public List<EstadosCidades> getListaCidades(){
		
		try {
			//Primeiro a conexao
			Connection c = this.getConnection();
			//Depois o PreparedStatement
			PreparedStatement  ps =null;
			//ResultSet
			ResultSet rs = null;
			
			
			//Recebe a Consulta
			
			ps = c.prepareStatement("select * from cidade");
	
			
			
			//Executa a consulta
			rs = ps.executeQuery();
			
			List<EstadosCidades> listaCidade = new ArrayList<EstadosCidades>();
			
			while(rs.next()) {
				//Cria  objeto Estados
				EstadosCidades listCd = new EstadosCidades();
				
				listCd.setNomeCidade(rs.getString("nomecidade"));
				
				
				//add objeto a lista
				listaCidade.add(listCd);
				
				
			}
			rs.close();
			ps.close();
			return listaCidade;
			
			
			
		}catch (SQLException e) {
			throw new RuntimeException(e);
			
		}
	}
	
	
	
public List<EstadosCidades> getListaPME(){
		
		try {
			//Primeiro a conexao
			Connection c = this.getConnection();
			//Depois o PreparedStatement
			PreparedStatement  ps =null;
			//ResultSet
			ResultSet rs = null;
			
			
			//Recebe a Consulta
			
			ps = c.prepareStatement("select * from pme");
	
			
			
			//Executa a consulta
			rs = ps.executeQuery();
			
			List<EstadosCidades> listaCidade = new ArrayList<EstadosCidades>();
			
			while(rs.next()) {
				//Cria  objeto Estados
				EstadosCidades listCd = new EstadosCidades();
				
				listCd.setNomeCidade(rs.getString("nomecidade"));
				
				
				//add objeto a lista
				listaCidade.add(listCd);
				
				
			}
			rs.close();
			ps.close();
			return listaCidade;
			
			
			
		}catch (SQLException e) {
			throw new RuntimeException(e);
			
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	public void salvarConsulta(AgendaConsulta agenda) {

		Connection con = this.getConnection();

		String sql = "INSERT INTO consultas_agendadas(data, hora, estado, cidade, ubs, medico, especialidade, id_usuario, nome)"
				+ "values (?, ?, ?, ?, ?, ?, ?, ?, ?)";

		try {

			PreparedStatement stmt = con.prepareStatement(sql);
			// int a = agenda.getIdUsuario();
			stmt.setString(1, agenda.getData());
			stmt.setString(2, agenda.getHora());
			stmt.setString(3, agenda.getEstado());
			stmt.setString(4, agenda.getCidade());
			stmt.setString(5, agenda.getUbs());
			stmt.setString(6, agenda.getMedico());
			stmt.setString(7, agenda.getEspecialidade());
			stmt.setInt(8, agenda.getIdUsuario());
			stmt.setString(9, agenda.getNome());

			stmt.execute();
			stmt.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}

	public List<AgendaConsulta> getLista(int id_usuario) {

		try {
			Connection c = this.getConnection();
			PreparedStatement ps = null;
			ResultSet rs = null;

			ps = c.prepareStatement(
					"select data, hora, estado, cidade, ubs, medico, especialidade from consultas_agendadas where id_usuario = ?");
			ps.setInt(1, id_usuario);

			rs = ps.executeQuery();

			List<AgendaConsulta> agendados = new ArrayList<AgendaConsulta>();
			while (rs.next()) {
				// criando o objeto AgendaConsulta
				AgendaConsulta ag = new AgendaConsulta();

				ag.setData(rs.getString("data"));
				ag.setHora(rs.getString("hora"));
				ag.setEstado(rs.getString("estado"));
				ag.setCidade(rs.getString("cidade"));
				ag.setUbs(rs.getString("ubs"));
				ag.setEspecialidade(rs.getString("medico"));
				ag.setMedico(rs.getString("especialidade"));

				// adicionando o objeto à lista
				agendados.add(ag);

			}
			rs.close();
			ps.close();
			return agendados;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public List<AgendaConsulta> getListaPeriodoConsulta(int id_usuario, String dataIni, String dataFim) {
		try {
			Connection c = this.getConnection();
			PreparedStatement ps = null;
			ResultSet rs = null;

			ps = c.prepareStatement(
					"select data, hora, estado, cidade, ubs, medico, especialidade from consultas_agendadas where id_usuario = ? and cast(data as Date) between cast(? as Date) and cast(? as Date)");
			ps.setInt(1, id_usuario);
			ps.setString(2, dataIni);
			ps.setString(3, dataFim);

			rs = ps.executeQuery();

			List<AgendaConsulta> agendados = new ArrayList<AgendaConsulta>();
			while (rs.next()) {
				// criando o objeto AgendaConsulta
				AgendaConsulta ag = new AgendaConsulta();

				ag.setData(rs.getString("data"));
				ag.setHora(rs.getString("hora"));
				ag.setEstado(rs.getString("estado"));
				ag.setCidade(rs.getString("cidade"));
				ag.setUbs(rs.getString("ubs"));
				ag.setEspecialidade(rs.getString("medico"));
				ag.setMedico(rs.getString("especialidade"));

				// adicionando o objeto à lista
				agendados.add(ag);
			}
			rs.close();
			ps.close();
			return agendados;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}

	public void salvarExame(AgendaExame agendaExame) {

		Connection con = this.getConnection();

		String sql = "INSERT INTO exames_agendados(data, hora, estado, cidade, ubs, exame, id_usuario, nome)"
				+ "values (?, ?, ?, ?, ?, ?, ?, ?)";

		try {

			PreparedStatement stmt = con.prepareStatement(sql);

			stmt.setString(1, agendaExame.getData());
			stmt.setString(2, agendaExame.getHora());
			stmt.setString(3, agendaExame.getEstado());
			stmt.setString(4, agendaExame.getCidade());
			stmt.setString(5, agendaExame.getUbs());
			stmt.setString(6, agendaExame.getExame());
			stmt.setInt(7, agendaExame.getIdUsuario());
			stmt.setString(8, agendaExame.getNome());

			stmt.execute();
			stmt.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}

	public List<AgendaExame> getListaExame(int id_usuario) {

		try {
			Connection c = this.getConnection();
			PreparedStatement ps = null;
			ResultSet rs = null;

			ps = c.prepareStatement(
					"select data, hora, estado, cidade, ubs, exame from exames_agendados where id_usuario = ?");
			ps.setInt(1, id_usuario);

			rs = ps.executeQuery();

			List<AgendaExame> Examesagendados = new ArrayList<AgendaExame>();
			while (rs.next()) {
				// criando o objeto AgendaExame
				AgendaExame agEx = new AgendaExame();

				agEx.setData(rs.getString("data"));
				agEx.setHora(rs.getString("hora"));
				agEx.setEstado(rs.getString("estado"));
				agEx.setCidade(rs.getString("cidade"));
				agEx.setUbs(rs.getString("ubs"));
				agEx.setExame(rs.getString("exame"));

				// adicionando o objeto à lista
				Examesagendados.add(agEx);

			}
			rs.close();
			ps.close();
			return Examesagendados;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public List<AgendaExame> getListaPeriodoExame(int id_usuario, String dataIni, String dataFim) {
		try {
			Connection c = this.getConnection();
			PreparedStatement ps = null;
			ResultSet rs = null;

			ps = c.prepareStatement(
					"select data, hora, estado, cidade, ubs, exame from exames_agendados where id_usuario = ? and cast(data as Date) between cast(? as Date) and cast(? as Date) order by cast(data as Date)");
			ps.setInt(1, id_usuario);
			ps.setString(2, dataIni);
			ps.setString(3, dataFim);

			rs = ps.executeQuery();

			List<AgendaExame> agendados = new ArrayList<AgendaExame>();
			while (rs.next()) {
				// criando o objeto AgendaConsulta
				AgendaExame ag = new AgendaExame();

				ag.setData(rs.getString("data"));
				ag.setHora(rs.getString("hora"));
				ag.setEstado(rs.getString("estado"));
				ag.setCidade(rs.getString("cidade"));
				ag.setCidade(rs.getString("ubs"));
				ag.setUbs(rs.getString("exame"));

				// adicionando o objeto à lista
				agendados.add(ag);
			}
			rs.close();
			ps.close();
			return agendados;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}

}
