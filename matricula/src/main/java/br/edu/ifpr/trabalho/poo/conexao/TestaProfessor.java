package br.edu.ifpr.trabalho.poo.conexao;

import java.util.ArrayList;

import br.edu.ifpr.trabalho.poo.implementacao.ImplementacaoBusca;
import br.edu.ifpr.trabalho.poo.implementacao.ImplementacaoInserir;
import br.edu.ifpr.trabalho.poo.implementacao.ImplementacaoLerDados;
import br.edu.ifpr.trabalho.poo.modelo.Professor;

public class TestaProfessor {

	public static void main(String[] args) {
		ImplementacaoLerDados leitura = new ImplementacaoLerDados();
		ImplementacaoBusca busca = new ImplementacaoBusca();
		ImplementacaoInserir insercao = new ImplementacaoInserir();
		
		Professor professor = leitura.lerDadosProfessor();
		insercao.salvarProfessor(professor);
		ArrayList<Professor> listaProfessores = busca.buscarProfessores();
		for (Professor p : listaProfessores) {
			p.imprimirDados();
		}
	}

}
