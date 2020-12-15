package br.edu.faculdadedelta.modelo;

import java.util.Date;

public class BensWilliam {
	public BensWilliam() {
		super();
	}
	private Long id_bem;
	private String desc_bem;
	private String codigo_bem;
	private String classificacao_bem;
	private double valor_bem;
	private Date data_aquisicao_bem;
	
	
	public BensWilliam(Long id_bem, String desc_bem, String codigo_bem, String classificacao_bem, double valor_bem,
			Date data_aquisicao_bem) {
		super();
		this.id_bem = id_bem;
		this.desc_bem = desc_bem;
		this.codigo_bem = codigo_bem;
		this.classificacao_bem = classificacao_bem;
		this.valor_bem = valor_bem;
		this.data_aquisicao_bem = data_aquisicao_bem;
	}

	
	
	
	public Long getId_bem() {
		return id_bem;
	}
	public void setId_bem(Long id_bem) {
		this.id_bem = id_bem;
	}
	public String getDesc_bem() {
		return desc_bem;
	}
	public void setDesc_bem(String desc_bem) {
		this.desc_bem = desc_bem;
	}
	public String getCodigo_bem() {
		return codigo_bem;
	}
	public void setCodigo_bem(String codigo_bem) {
		this.codigo_bem = codigo_bem;
	}
	public String getClassificacao_bem() {
		return classificacao_bem;
	}
	public void setClassificacao_bem(String classificacao_bem) {
		this.classificacao_bem = classificacao_bem;
	}
	public double getValor_bem() {
		return valor_bem;
	}
	public void setValor_bem(double valor_bem) {
		this.valor_bem = valor_bem;
	}
	public Date getData_aquisicao_bem() {
		return data_aquisicao_bem;
	}
	public void setData_aquisicao_bem(Date data_aquisicao_bem) {
		this.data_aquisicao_bem = data_aquisicao_bem;
	}


}
