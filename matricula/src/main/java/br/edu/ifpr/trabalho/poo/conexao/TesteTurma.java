package br.edu.ifpr.trabalho.poo.conexao;

import java.util.ArrayList;

import br.edu.ifpr.trabalho.poo.dao.TurmaDAO;
import br.edu.ifpr.trabalho.poo.dao.TurmaDAO;
import br.edu.ifpr.trabalho.poo.implementacao.ImplementacaoBusca;
import br.edu.ifpr.trabalho.poo.implementacao.ImplementacaoInserir;
import br.edu.ifpr.trabalho.poo.implementacao.ImplementacaoLerDados;
import br.edu.ifpr.trabalho.poo.modelo.Turma;
import br.edu.ifpr.trabalho.poo.modelo.Turma;

public class TesteTurma {
	public static void main(String[] args) {

		ImplementacaoLerDados leitura = new ImplementacaoLerDados();
		ImplementacaoBusca busca = new ImplementacaoBusca();
		ImplementacaoInserir insercao = new ImplementacaoInserir();

		Turma turma = leitura.lerDadosTurma();

		TurmaDAO.salvarTurma(turma);

		TurmaDAO turmaDAO = new TurmaDAO();
		ArrayList<Turma> listarTurma = turmaDAO.listar();

		for (Turma t : listarTurma) {
			System.out.println(t.getNome());

		}
	}
}
