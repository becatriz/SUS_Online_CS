package br.com.sus_onlineDao.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.sus_online.model.AgendaExame;
import br.com.sus_online.model.Medicamento;
import br.com.sus_online.model.Vacina;

public class DaoMedicacaoVacina {
	
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
	
	public List<Vacina> getListaVacinas(int id_usuario) {

		try {
			Connection c = this.getConnection();
			PreparedStatement ps = null;
			ResultSet rs = null;

			ps = c.prepareStatement("select tipo,dataaplicacao,lotevalidade,validadevacina from vacina where id_usuario = ?");
			ps.setInt(1, id_usuario);

			rs = ps.executeQuery();

			List<Vacina> vacinas = new ArrayList<Vacina>();
			
			while (rs.next()) {
				// criando o objeto AgendaExame
				Vacina vac = new Vacina();

				vac.setTipoVacina(rs.getString("tipo"));
				vac.setDataApli(rs.getDate("dataaplicacao"));
				vac.setLoteValidade(rs.getDate("lotevalidade"));
				vac.setValidadeImune(rs.getDate("validadevacina"));

				// adicionando o objeto � lista
				vacinas.add(vac);

			}
			rs.close();
			ps.close();
			return vacinas;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public List<Medicamento> getListaMedicamentos(int id_usuario) {

		try {
			Connection c = this.getConnection();
			PreparedStatement ps = null;
			ResultSet rs = null;

			ps = c.prepareStatement("select nomemedicacao, dosagem, contra_indi, posologia from medicacao where id_usuario = ?");
			ps.setInt(1, id_usuario);

			rs = ps.executeQuery();

			List<Medicamento> medicamentos = new ArrayList<Medicamento>();
			
			while (rs.next()) {
				// criando o objeto AgendaExame
				Medicamento med = new Medicamento();

				med.setNomeMedicacao(rs.getString("nomemedicacao"));
				med.setDosagem(rs.getString("dosagem"));
				med.setContra_ind(rs.getString("contra_indi"));
				med.setPosologia(rs.getString("posologia"));
				
				// adicionando o objeto � lista
				medicamentos.add(med);

			}
			rs.close();
			ps.close();
			return medicamentos;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
