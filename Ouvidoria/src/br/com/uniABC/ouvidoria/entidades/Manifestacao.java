/*
 * Grupo:
 * Alana
 * Joalyson
 * Luis Gustavo
 * Wictor
 * 
 * 
 * 
 * 
 */


package br.com.uniABC.ouvidoria.entidades;

public class Manifestacao {
	private int codigo;
	private String reclamante;
	private String titulo;
	private String descicao;
	private String tipoManifestacao;
	
	
	private String situacao = "Aberto";
	private static int contador = 1;


	public Manifestacao(String reclamante, String titulo, String descicao, String tipoManifestacao) {
		this.reclamante = reclamante;
		this.titulo = titulo;
		this.descicao = descicao;
		this.tipoManifestacao = tipoManifestacao;
		
		this.codigo = contador++;
	}


	public int getCodigo() {
		return codigo;
	}


	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}


	public String getReclamante() {
		return reclamante;
	}


	public void setReclamante(String reclamante) {
		this.reclamante = reclamante;
	}


	public String getTitulo() {
		return titulo;
	}


	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}


	public String getDescicao() {
		return descicao;
	}


	public void setDescicao(String descicao) {
		this.descicao = descicao;
	}


	public String getSituacao() {
		return situacao;
	}


	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}


	public String getTipoManifestacao() {
		return tipoManifestacao;
	}


	public void setTipoManifestacao(String tipoManifestacao) {
		this.tipoManifestacao = tipoManifestacao;
	}

	
	
	
}
