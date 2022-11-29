package br.edu.ifpr.trabalho.poo.conexao;

import java.util.ArrayList;

import br.edu.ifpr.trabalho.poo.dao.DisciplinaDAO;
import br.edu.ifpr.trabalho.poo.implementacao.ImplementacaoBusca;
import br.edu.ifpr.trabalho.poo.implementacao.ImplementacaoInserir;
import br.edu.ifpr.trabalho.poo.implementacao.ImplementacaoLerDados;
import br.edu.ifpr.trabalho.poo.modelo.Disciplina;
import br.edu.ifpr.trabalho.poo.modelo.Professor;
import br.edu.ifpr.trabalho.poo.modelo.Turma;

public class TestaDisciplina {

	public static void main(String[] args) {
		ImplementacaoLerDados leitura = new ImplementacaoLerDados();
		ImplementacaoBusca busca = new ImplementacaoBusca();
		ImplementacaoInserir insercao = new ImplementacaoInserir();
		
		Professor professor = new Professor();
		Turma turma = new Turma();
		Disciplina disciplina = leitura.lerDadosDisciplina(professor, turma);
		
		DisciplinaDAO.salvarDisciplina(disciplina);

		DisciplinaDAO disciplinaDAO = new DisciplinaDAO();
		ArrayList<Disciplina> listarDisciplina = disciplinaDAO.listar();

		for (Disciplina d : listarDisciplina) {
			System.out.println(d.getTurma());
		}
	}
}
