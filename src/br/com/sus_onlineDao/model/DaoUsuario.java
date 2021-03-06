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
	
	public List<Autentica_Usuario> getListaUsuarios() {

		try {
			Connection c = this.getConnection();
			PreparedStatement ps = null;
			ResultSet rs = null;

			ps = c.prepareStatement("select id, nome, usuario from autentica_usuario");
			

			rs = ps.executeQuery();

			List<Autentica_Usuario> users = new ArrayList<Autentica_Usuario>();
			while (rs.next()) {
				// criando o objeto Autentica_Usuario
				Autentica_Usuario auten = new Autentica_Usuario();
				
				auten.setid(rs.getInt("id"));
				auten.setNome(rs.getString("nome"));
				auten.setUsuario(rs.getString("usuario"));
				
				


				// adicionando o objeto � lista
				users.add(auten);

			}
			rs.close();
			ps.close();
			return users;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
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

	
}
