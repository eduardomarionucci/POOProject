package br.edu.ifpr.trabalho.poo.conexao;

import java.util.ArrayList;

import br.edu.ifpr.trabalho.poo.dao.MatriculaDAO;
import br.edu.ifpr.trabalho.poo.implementacao.ImplementacaoBusca;
import br.edu.ifpr.trabalho.poo.implementacao.ImplementacaoInserir;
import br.edu.ifpr.trabalho.poo.implementacao.ImplementacaoLerDados;
import br.edu.ifpr.trabalho.poo.modelo.Aluno;
import br.edu.ifpr.trabalho.poo.modelo.Matricula;
import br.edu.ifpr.trabalho.poo.modelo.Turma;

public class TesteMatricula {
	public static void main(String[] args) {
		ImplementacaoLerDados leitura = new ImplementacaoLerDados();
		ImplementacaoBusca busca = new ImplementacaoBusca();
		ImplementacaoInserir insercao = new ImplementacaoInserir();

		Matricula matricula = leitura.lerDadosMatricula();
		Turma turma = new Turma();
		Aluno aluno = new Aluno();

		MatriculaDAO.salvarMatricula(matricula);

		MatriculaDAO matriculaDAO = new MatriculaDAO();
		ArrayList<Matricula> listarMatricula = matriculaDAO.listar();
		
		for (Matricula d : listarMatricula) {
			System.out.println(d.getRa());
		}

	}
}
