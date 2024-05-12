package br.com.uniABC.ouvidoria.principal;

import br.com.uniABC.ouvidoria.entidades.Manifestacao;
import br.com.uniABC.ouvidoria.entidades.Ouvidoria;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class OuvidoriaMenu {

	public static void main(String[] args) {
		String menuOpcao = "Bem vindo a Ouvidoria ABC, oque deseja efetuar:"+"\n"+"1)Listar manifestações  2)Listar reclamações  3)Listar sugestões "
						+ "	4)Listar elogios  5)Adicionar nova manifestação  "
						+ "	6)Pesquisar manifestação por código  7)Remover manifestação por código  8)Alterar situação  9)Sair";
		Ouvidoria ouvidoria = new Ouvidoria();		
		int menu = 9;
		
		do {
			String opcaoStr = JOptionPane.showInputDialog(menuOpcao);
			menu = Integer.parseInt(opcaoStr);
			
			if(menu == 1) {
				//listar todas as arrays
				ArrayList<Manifestacao> listaManifestacao = ouvidoria.pesquisarManifestacao();
				
				String listaCompleta = "->  ";
				for (Manifestacao i : listaManifestacao) {
					String descricao = "Código: "+i.getCodigo()+" com título: "+i.getTitulo()+ " do reclamante "+i.getReclamante()
					+" com a descricão: "+i.getDescicao()+" de tipo: "+i.getTipoManifestacao()+" está em situação: "+i.getSituacao()+"\n";
					
					listaCompleta += descricao;
				}
				
				if(listaManifestacao.size() == 0) {
					JOptionPane.showMessageDialog(null, "Não existem manifestações!");
				} else {
					JOptionPane.showMessageDialog(null, listaCompleta);
				}
			}
			else if(menu == 2) {
				//listar reclamacoes
				ArrayList<Manifestacao> listaReclamacao = ouvidoria.listarReclamacao();
				
				String listaCompleta = "->  ";
				for (Manifestacao i : listaReclamacao) {
					String descricao = "Código: "+i.getCodigo()+" com título: "+i.getTitulo()+ " do reclamante "+i.getReclamante()
					+" com a descricão: "+i.getDescicao()+" de tipo: "+i.getTipoManifestacao()+" está em situação: "+i.getSituacao()+"\n";
					
					listaCompleta += descricao;
				}
				
				if(listaReclamacao.size() == 0) {
					JOptionPane.showMessageDialog(null, "Não existem reclamações!");
				} else {
					JOptionPane.showMessageDialog(null, listaCompleta);
				}
			}
			else if(menu == 3) {
				//listar sugestoes
				ArrayList<Manifestacao> listaSugestao = ouvidoria.listarSugestao();
				
				String listaCompleta = "->  ";
				for (Manifestacao i : listaSugestao) {
					String descricao = "Código: "+i.getCodigo()+" com título: "+i.getTitulo()+ " do reclamante "+i.getReclamante()
					+" com a descricão: "+i.getDescicao()+" de tipo: "+i.getTipoManifestacao()+" está em situação: "+i.getSituacao()+"\n";
					
					listaCompleta += descricao;
				}
				
				if(listaSugestao.size() == 0) {
					JOptionPane.showMessageDialog(null, "Não existem Sugestões!");
				} else {
					JOptionPane.showMessageDialog(null, listaCompleta);
				}
			}
			else if(menu == 4) {
				//listar elogios
				ArrayList<Manifestacao> listaElogio = ouvidoria.listarElogio();
				
				String listaCompleta = "->  ";
				for (Manifestacao i : listaElogio) {
					String descricao = "Código: "+i.getCodigo()+" com título: "+i.getTitulo()+ " do reclamante "+i.getReclamante()
					+" com a descricão: "+i.getDescicao()+" de tipo: "+i.getTipoManifestacao()+" está em situação: "+i.getSituacao()+"\n";
					
					listaCompleta += descricao;
				}
				
				if(listaElogio.size() == 0) {
					JOptionPane.showMessageDialog(null, "Não existem elogios!");
				} else {
					JOptionPane.showMessageDialog(null, listaCompleta);
				}
			}
			else if(menu == 5) {
				//add reclamacao
				Manifestacao novaReclamacao = null;
				
				String reclamante = JOptionPane.showInputDialog("Digite seu nome: ");
				String titulo = JOptionPane.showInputDialog("Digite o título: ");
				String descricao = JOptionPane.showInputDialog("Digite a descrição: ");
				String tipoManifestacao = JOptionPane.showInputDialog("Digite qual o tipo da manifestação: "+"\n"+"Reclamacao, Sugestao ou Elogio");
				
				//input pra qual manifestação
				if(tipoManifestacao == "Reclamacao") {
					tipoManifestacao = "Reclamacao";
				}
				else if (tipoManifestacao == "Sugestao") {
					tipoManifestacao = "Sugestao";
				}
				else if (tipoManifestacao == "Elogio") {
					tipoManifestacao = "Elogio";
				}
				novaReclamacao = new Manifestacao(reclamante,titulo,descricao,tipoManifestacao);
				ouvidoria.criarReclamacao(novaReclamacao);
				JOptionPane.showMessageDialog(null, "Sua manifestação com título: "+titulo+ " do reclamante: "+reclamante+" com a descricão: "+descricao+" de tipo: "+tipoManifestacao+" esta em situação: Aberta"+"\n"+"Foi adicionada com sucesso!");
		}
		else if (menu == 6) {
			//pesquisar reclamacao
			String reclamacaoPesquisadaSTR = JOptionPane.showInputDialog(null, "Digite o código da manifestacão a ser pesquisada: ");
			int reclamacaoPesquisada = Integer.parseInt(reclamacaoPesquisadaSTR);
			
			Manifestacao priReclamacaoPesquisada = ouvidoria.pesquisarReclamacao(reclamacaoPesquisada);
			
			if(priReclamacaoPesquisada != null) {
				JOptionPane.showMessageDialog(null, "A manifestação foi: "+"Código: "+priReclamacaoPesquisada.getCodigo()+" com título: "+priReclamacaoPesquisada.getTitulo()+ " do reclamante "+priReclamacaoPesquisada.getReclamante()+" com a descricão: "+priReclamacaoPesquisada.getDescicao()+" de tipo: "+priReclamacaoPesquisada.getTipoManifestacao()+" esta em situação: "+priReclamacaoPesquisada.getSituacao()+"\n");
			}
			else{
				JOptionPane.showMessageDialog(null, "Essa manifestação não existe");
			}
		} 
		else if (menu == 7) {
			//remover reclamacao
			ArrayList<Manifestacao> listaManifestacao = ouvidoria.pesquisarManifestacao();
			
			String listaCompleta = "->  ";
			for (Manifestacao i : listaManifestacao) {
				String descricao = "Código: "+i.getCodigo()+" com título: "+i.getTitulo()+ " do reclamante "+i.getReclamante()
				+" com a descricão: "+i.getDescicao()+" de tipo: "+i.getTipoManifestacao()+" está em situação: "+i.getSituacao()+"\n";
				
				listaCompleta += descricao;
			}
			JOptionPane.showMessageDialog(null, listaCompleta);
			
			String reclamacaoPesquisadaSTR = JOptionPane.showInputDialog(null, "Digite o código da manifestacão a ser removida: ");
			int reclamacaoPesquisada = Integer.parseInt(reclamacaoPesquisadaSTR);
			
			Manifestacao priReclamacaoPesquisada = ouvidoria.pesquisarReclamacao(reclamacaoPesquisada);
			ouvidoria.removerReclamacao(reclamacaoPesquisada);
			JOptionPane.showMessageDialog(null, "A manifestação foi: "+"Código: "+priReclamacaoPesquisada.getCodigo()+" com título: "+priReclamacaoPesquisada.getTitulo()+ " do reclamante "+priReclamacaoPesquisada.getReclamante()+" com a descricão: "+priReclamacaoPesquisada.getDescicao()+" de tipo: "+priReclamacaoPesquisada.getTipoManifestacao()+" esta em situação: "+priReclamacaoPesquisada.getSituacao()+"\n"+"\n"+"Foi removida com sucesso!");
		}
		else if (menu == 8) {
			//alterar tipo situacao
			ArrayList<Manifestacao> listaManifestacao = ouvidoria.pesquisarManifestacao();
			
			String listaCompleta = "->  ";
			for (Manifestacao i : listaManifestacao) {
				String descricao = "Código: "+i.getCodigo()+" com título: "+i.getTitulo()+ " do reclamante "+i.getReclamante()
				+" com a descricão: "+i.getDescicao()+" de tipo: "+i.getTipoManifestacao()+" está em situação: "+i.getSituacao()+"\n";
				
				listaCompleta += descricao;
			}
			JOptionPane.showMessageDialog(null, listaCompleta);
			
			String reclamacaoPesquisadaSTR = JOptionPane.showInputDialog(null, "Digite o código da manifestacão a ser removida: ");
			int reclamacaoPesquisada = Integer.parseInt(reclamacaoPesquisadaSTR);
			
			String novaReclamacaoStr = JOptionPane.showInputDialog(null, "Digite a nova situação de manifestação: "+"\n"+"Em atendimento ou finalizado");
			
			Manifestacao priReclamacaoPesquisada = ouvidoria.pesquisarReclamacao(reclamacaoPesquisada);
			ouvidoria.alterarTipoReclamacao(reclamacaoPesquisada,novaReclamacaoStr);
			
			JOptionPane.showMessageDialog(null, "A manifestação foi: "+"Código: "+priReclamacaoPesquisada.getCodigo()+" com título: "+priReclamacaoPesquisada.getTitulo()+ " do reclamante "+priReclamacaoPesquisada.getReclamante()+" com a descricão: "+priReclamacaoPesquisada.getDescicao()+" de tipo: "+priReclamacaoPesquisada.getTipoManifestacao()+" esta em situação: "+priReclamacaoPesquisada.getSituacao()+"\n"+"\n"+"O tipo foi alterado com sucesso!");
		}
			
	} while(menu !=9);
}
}