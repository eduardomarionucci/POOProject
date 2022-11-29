package br.edu.ifpr.trabalho.poo.conexao;

import java.util.ArrayList;
import java.util.Scanner;

import br.edu.ifpr.trabalho.poo.dao.AlunoDAO;
import br.edu.ifpr.trabalho.poo.implementacao.ImplementacaoBusca;
import br.edu.ifpr.trabalho.poo.implementacao.ImplementacaoInserir;
import br.edu.ifpr.trabalho.poo.implementacao.ImplementacaoLerDados;
import br.edu.ifpr.trabalho.poo.modelo.Aluno;

public class TestaAluno {

	public static void main(String[] args) {

		ImplementacaoLerDados leitura = new ImplementacaoLerDados();
		ImplementacaoBusca busca = new ImplementacaoBusca();
		ImplementacaoInserir insercao = new ImplementacaoInserir();

		Aluno aluno = leitura.lerDadosAluno();
		AlunoDAO alunoDAO = new AlunoDAO();
		AlunoDAO.salvarAluno(aluno);
		ArrayList<Aluno> listarAlunos = alunoDAO.listar();
		for (Aluno a : listarAlunos) {
			a.imprimirDados();
		}
	}

}
