package br.com.uniABC.ouvidoria.entidades;

import java.util.ArrayList;

public class Ouvidoria {
	
	private static final String ABREVIACAO_REC = "Reclamacao";
	private static final String ABREVIACAO_SUG = "Sugestao";
	private static final String ABREVIACAO_ELO  = "Elogio";
	
	private ArrayList<Manifestacao> listaReclamacao = new ArrayList<Manifestacao>();
	private ArrayList<Manifestacao> listaSugestao = new ArrayList<Manifestacao>();
	private ArrayList<Manifestacao> listaElogio = new ArrayList<Manifestacao>();
	
	//listar todas as arrays
	public ArrayList<Manifestacao> pesquisarManifestacao() {
		ArrayList<Manifestacao> listaManifestacao = new ArrayList<Manifestacao>();
		listaManifestacao.addAll(listaReclamacao);
		listaManifestacao.addAll(listaSugestao );
		listaManifestacao.addAll(listaElogio);
		
		return listaManifestacao;
	
	}
	//Listar as array individuais
	public ArrayList<Manifestacao> listarReclamacao(){
		return listaReclamacao;
	}
	public ArrayList<Manifestacao> listarSugestao(){
		return listaSugestao;
	}
	public ArrayList<Manifestacao> listarElogio(){
		return listaElogio;
	}
	
	
	public void criarReclamacao(Manifestacao novaReclamacao) {
		if(novaReclamacao != null) {
			if(novaReclamacao.getTipoManifestacao().equalsIgnoreCase(ABREVIACAO_REC)) {
				listaReclamacao.add(novaReclamacao);
			}
			else if(novaReclamacao.getTipoManifestacao().equalsIgnoreCase(ABREVIACAO_SUG)) {
				listaSugestao.add(novaReclamacao);
			}
			else if (novaReclamacao.getTipoManifestacao().equalsIgnoreCase(ABREVIACAO_ELO)){
				listaElogio.add(novaReclamacao);
			}
		}
	}
	
	public Manifestacao pesquisarReclamacao (int codReclamacaoPesquisada) {
		Manifestacao listagemReclamcoes = null;
		for (Manifestacao i : pesquisarManifestacao()) {
			if(i.getCodigo() == codReclamacaoPesquisada ) {
				
				listagemReclamcoes = i;
			}
		}
		return listagemReclamcoes;
	}
	
	public void removerReclamacao (int codRemoverReclamacao) {
		Manifestacao reclamacaoPesquisada = pesquisarReclamacao(codRemoverReclamacao);
		if(reclamacaoPesquisada != null) {
			
			if(reclamacaoPesquisada.getTipoManifestacao().equalsIgnoreCase(ABREVIACAO_REC)) {
				listaReclamacao.remove(reclamacaoPesquisada);
			}
			else if (reclamacaoPesquisada.getTipoManifestacao().equalsIgnoreCase(ABREVIACAO_SUG)) {
				listaSugestao.remove(reclamacaoPesquisada);
			}
			else if (reclamacaoPesquisada.getTipoManifestacao().equalsIgnoreCase(ABREVIACAO_ELO)) {
				listaElogio.remove(reclamacaoPesquisada);
			}
		}
	}
	
	public void alterarTipoReclamacao (int codAlterarSituacaoReclamacao, String novaSituacao) {
		Manifestacao reclamacaoPesquisada = pesquisarReclamacao(codAlterarSituacaoReclamacao);
		if(reclamacaoPesquisada != null) {
			reclamacaoPesquisada.setSituacao(novaSituacao);
			
		}
	}
}
