package model;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Autentica_Usuario;

public class DaoUsuario {

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

		String sql = "INSERT INTO consultas_agendadas(data, hora, cidade, estado, ubs, medico, especialidade, id_usuario)"
				+ "values (?, ?, ?, ?, ?, ?, ?, ?)";

		try {

			PreparedStatement stmt = con.prepareStatement(sql);
			int a = agenda.getIdUsuario();
			stmt.setString(1, agenda.getData());
			stmt.setString(2, agenda.getHora());
			stmt.setString(3, agenda.getCidade());
			stmt.setString(4, agenda.getEstado());
			stmt.setString(5, agenda.getUbs());
			stmt.setString(6, agenda.getMedico());
			stmt.setString(7, agenda.getEspecialidade());
			stmt.setInt(8, agenda.getIdUsuario());

			stmt.execute();
			stmt.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}

	public Autentica_Usuario getUsuario(String usuario, String senha) {
		Connection c = this.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = c.prepareStatement("select id, nome from autentica_usuario where usuario = ? and senha = ?");
			ps.setString(1, usuario);
			ps.setString(2, senha);

			rs = ps.executeQuery();

			if (rs.next()) {
				Autentica_Usuario user = new Autentica_Usuario();
				user.setid(rs.getInt("id"));
				user.setUsuario(usuario);
				user.setSenha(senha);
				user.setNome(rs.getString("nome"));

				return user;

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					;
				}
				rs = null;
			}
			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					;
				}
				ps = null;
			}
			if (c != null) {
				try {
					c.close();
				} catch (SQLException e) {
					;
				}
				c = null;
			}
		}
		return null;
	}

	public Autentica_Usuario findByUser(String usuario) {
		Connection c = this.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = c.prepareStatement("select id from autentica_usuario where Nome = ? ");
			ps.setString(1, usuario);

			rs = ps.executeQuery();

			if (rs.next()) {
				Autentica_Usuario user = new Autentica_Usuario();
				user.setid(rs.getInt("id"));
				user.setUsuario(usuario);
				user.setNome(rs.getString("nome"));

				return user;

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					;
				}
				rs = null;
			}
			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					;
				}
				ps = null;
			}
			if (c != null) {
				try {
					c.close();
				} catch (SQLException e) {
					;
				}
				c = null;
			}
		}
		return null;
	}

	public List<AgendaConsulta> getLista() {

		try {
			List<AgendaConsulta> agendados = new ArrayList<AgendaConsulta>();
			PreparedStatement stmt = this.getConnection()
					.prepareStatement("select data, hora, ubs, medico from consultas_agendadas");
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				// criando o objeto AgendaConsulta
				AgendaConsulta ag = new AgendaConsulta();
				
				ag.setData(rs.getString("data"));
				ag.setHora(rs.getString("hora"));
				ag.setUbs(rs.getString("ubs"));
				ag.setMedico(rs.getString("medico"));


				// adicionando o objeto à lista
				agendados.add(ag);

			}
			rs.close();
			stmt.close();
			return agendados;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
