package br.com.olimpiada.http;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Competicao {
	
	private int id;
	private String modalidade;
	private String local;
	private String data_hora_inicio;
	private String data_hora_termino;
	private String competidor1;
	private String competidor2;
	private String etapa;
	
	public Competicao(){
	
	}
	
	public Competicao(int id, String modalidade, String local, 
							  String data_hora_inicio, String data_hora_termino,
							  String competidor1, String competidor2, String etapa){
		super();
		this.id = id;
		this.modalidade = modalidade;
		this.local = local;
		this.data_hora_inicio = data_hora_inicio;
		this.data_hora_termino = data_hora_termino;
		this.competidor1 = competidor1;
		this.competidor2 = competidor2;
		this.etapa = etapa;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
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

	public String getData_hora_termino() {
		return data_hora_termino;
	}

	public void setData_hora_termino(String data_hora_termino) {
		this.data_hora_termino = data_hora_termino;
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
