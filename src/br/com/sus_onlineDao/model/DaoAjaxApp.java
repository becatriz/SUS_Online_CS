package br.com.sus_onlineDao.model;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.sus_online.model.*;

public class DaoAjaxApp {

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
	
	
	public List<LocalUbs> getLocalUbs() {

		List<LocalUbs> listLocalUbs = new ArrayList<LocalUbs>();
		try {
			PreparedStatement stmt = this.getConnection()
				.prepareStatement("SELECT * FROM public.local_ubs");
			ResultSet rs = stmt.executeQuery();
		
			while (rs.next()) {
				// criando o objeto AgendaConsulta
				LocalUbs ubs = new LocalUbs();
				
				ubs.setIdLocalUbs(Integer.parseInt(rs.getString("id")));
				ubs.setNome(rs.getString("nome"));
				
				listLocalUbs.add(ubs);
			}
			rs.close();
			stmt.close();
			return listLocalUbs;

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
