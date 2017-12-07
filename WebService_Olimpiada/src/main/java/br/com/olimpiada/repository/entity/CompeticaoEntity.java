package br.com.olimpiada.repository.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tb_competicao")
public class CompeticaoEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	
	@Column(name="modalidade")	
	private String  modalidade;
	
	@Column(name="local")
	private String  local;
	
	@Column(name="data_hora_inicio")
	private String  data_hora_inicio;
	
	@Column(name="data_hora_final")
	private String  data_hora_final;
	
	@Column(name="competidor1")
	private String  competidor1;
	
	@Column(name="competidor2")
	private String  competidor2;

	@Column(name="etapa")
	private String  etapa;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getModalidade() {
		return modalidade;
	}

	public void setModalidade(String modalidade) {
		this.modalidade = modalidade;
	}

	public String getLocal() {
		return local;
	}

	public void setLocal(String local) {
		this.local = local;
	}

	public String getData_hora_inicio() {
		return data_hora_inicio;
	}

	public void setData_hora_inicio(String data_hora_inicio) {
		this.data_hora_inicio = data_hora_inicio;
	}

	public String getData_hora_final() {
		return data_hora_final;
	}

	public void setData_hora_final(String data_hora_final) {
		this.data_hora_final = data_hora_final;
	}

	public String getCompetidor1() {
		return competidor1;
	}

	public void setCompetidor1(String competidor1) {
		this.competidor1 = competidor1;
	}

	public String getCompetidor2() {
		return competidor2;
	}

	public void setCompetidor2(String competidor2) {
		this.competidor2 = competidor2;
	}

	public String getEtapa() {
		return etapa;
	}

	public void setEtapa(String etapa) {
		this.etapa = etapa;
	}

}
