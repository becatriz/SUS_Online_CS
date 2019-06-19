package br.com.sus_online.model;

import java.util.Date;
import java.sql.*;

public class Vacina {
	
	int id_vacina;
	String tipoVacina;
	Date dataApli;
	Date loteValidade;
	Date validadeImune;
	int idUsuario;
	
	
	public int getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}
	public int getId_vacina() {
		return id_vacina;
	}
	public void setId_vacina(int id_vacina) {
		this.id_vacina = id_vacina;
	}
	public String getTipoVacina() {
		return tipoVacina;
	}
	public void setTipoVacina(String tipoVacina) {
		this.tipoVacina = tipoVacina;
	}
	public Date getDataApli() {
		return dataApli;
	}
	public void setDataApli(Date dataApli) {
		this.dataApli = dataApli;
	}
	public Date getLoteValidade() {
		return loteValidade;
	}
	public void setLoteValidade(Date loteValidade) {
		this.loteValidade = loteValidade;
	}
	public Date getValidadeImune() {
		return validadeImune;
	}
	public void setValidadeImune(Date validadeImune) {
		this.validadeImune = validadeImune;
	}
	
	
	
	

}
