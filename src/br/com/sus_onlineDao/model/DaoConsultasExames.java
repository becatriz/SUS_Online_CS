package br.com.sus_onlineDao.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.sus_online.model.AgendaConsulta;
import br.com.sus_online.model.Autentica_Usuario;


public class DaoConsultasExames {

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
	
	public void salvar(AgendaConsulta agenda) {

		Connection con = this.getConnection();

		String sql = "INSERT INTO consultas_agendadas(data, hora, estado, cidade, ubs, especialidade, medico, id_usuario, nome)"
				+ "values (?, ?, ?, ?, ?, ?, ?, ?, ?)";

		try {

			PreparedStatement stmt = con.prepareStatement(sql);
			//int a = agenda.getIdUsuario();
			stmt.setString(1, agenda.getData());
			stmt.setString(2, agenda.getHora());
			stmt.setString(3, agenda.getEstado());
			stmt.setString(4, agenda.getCidade());
			stmt.setString(5, agenda.getUbs());
			stmt.setString(6, agenda.getEspecialidade());
			stmt.setString(7, agenda.getMedico());
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

			ps = c.prepareStatement("select data, hora, ubs, medico, especialidade from consultas_agendadas where id_usuario = ?");
			ps.setInt(1, id_usuario);

			rs = ps.executeQuery();

			List<AgendaConsulta> agendados = new ArrayList<AgendaConsulta>();
			while (rs.next()) {
				// criando o objeto AgendaConsulta
				AgendaConsulta ag = new AgendaConsulta();
				
				ag.setData(rs.getString("data"));
				ag.setHora(rs.getString("hora"));
				ag.setUbs(rs.getString("ubs"));
				ag.setMedico(rs.getString("especialidade"));
				ag.setEspecialidade(rs.getString("medico"));


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
