package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Autentica_Usuario;;

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
		PreparedStatement ps =null;
		ResultSet rs = null;
		try {
			ps = c.prepareStatement("select id, nome from autentica_usuario where usuario = ? and senha = ?");
			ps.setString(1, usuario);
			ps.setString(2, senha);
			
			rs = ps.executeQuery();
			
			if(rs.next()) {
				Autentica_Usuario user = new Autentica_Usuario();
				user.setid(rs.getInt("id"));
				user.setUsuario(usuario);
				user.setSenha(senha);
				user.setNome(rs.getString("nome"));

				return user;
				
			}
			}catch (SQLException e){
	            e.printStackTrace();
	        }
	        finally{
	            if (rs != null ) {
	                try { rs.close(); } catch (SQLException e) { ; }
	                rs = null;
	            }
	            if (ps != null ) {
	                try { ps.close(); } catch (SQLException e) { ; }
	                ps = null;
	            }
	            if (c != null ) {
	                try { c.close(); } catch (SQLException e) { ; }
	                c = null;
	            }
	        }
	        return null;
	    }
	}


