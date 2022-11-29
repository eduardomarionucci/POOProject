package br.edu.ifpr.trabalho.poo.implementacao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.edu.ifpr.trabalho.poo.conexao.Conexao;
import br.edu.ifpr.trabalho.poo.dao.AlunoDAO;
import br.edu.ifpr.trabalho.poo.dao.CampusDAO;
import br.edu.ifpr.trabalho.poo.dao.CursoDAO;
import br.edu.ifpr.trabalho.poo.dao.DisciplinaDAO;
import br.edu.ifpr.trabalho.poo.dao.MatriculaDAO;
import br.edu.ifpr.trabalho.poo.dao.ProfessorDAO;
import br.edu.ifpr.trabalho.poo.dao.TurmaDAO;
import br.edu.ifpr.trabalho.poo.interfaces.IInserirDados;
import br.edu.ifpr.trabalho.poo.modelo.Aluno;
import br.edu.ifpr.trabalho.poo.modelo.Campus;
import br.edu.ifpr.trabalho.poo.modelo.Curso;
import br.edu.ifpr.trabalho.poo.modelo.Disciplina;
import br.edu.ifpr.trabalho.poo.modelo.Matricula;
import br.edu.ifpr.trabalho.poo.modelo.Professor;
import br.edu.ifpr.trabalho.poo.modelo.Turma;

public class ImplementacaoInserir implements IInserirDados {

	public void salvarAluno(Aluno aluno) {
		AlunoDAO.salvarAluno(aluno);
	}

	public void salvarProfessor(Professor professor) {
		ProfessorDAO.salvarProfessor(professor);
	}

	public void salvarCurso(Curso curso) {
		CursoDAO.salvarCurso(curso);
	}

	public void salvarTurma(Turma turma) {
		TurmaDAO.salvarTurma(turma);

	}

	public void salvarDisciplina(Disciplina disciplina) {
		DisciplinaDAO.salvarDisciplina(disciplina);
	}

	public void salvarMatricula(Matricula matricula) {
		MatriculaDAO.salvarMatricula(matricula);

	}

	public void salvarCampus(Campus campus) {
		CampusDAO.salvarCampus(campus);
	}
}
