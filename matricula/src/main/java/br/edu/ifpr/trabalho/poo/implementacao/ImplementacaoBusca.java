package br.edu.ifpr.trabalho.poo.implementacao;

import java.util.ArrayList;

import br.edu.ifpr.trabalho.poo.dao.AlunoDAO;
import br.edu.ifpr.trabalho.poo.dao.CampusDAO;
import br.edu.ifpr.trabalho.poo.dao.CursoDAO;
import br.edu.ifpr.trabalho.poo.dao.DisciplinaDAO;
import br.edu.ifpr.trabalho.poo.dao.MatriculaDAO;
import br.edu.ifpr.trabalho.poo.dao.ProfessorDAO;
import br.edu.ifpr.trabalho.poo.dao.TurmaDAO;
import br.edu.ifpr.trabalho.poo.interfaces.IBuscaDeDados;
import br.edu.ifpr.trabalho.poo.modelo.Aluno;
import br.edu.ifpr.trabalho.poo.modelo.Campus;
import br.edu.ifpr.trabalho.poo.modelo.Curso;
import br.edu.ifpr.trabalho.poo.modelo.Disciplina;
import br.edu.ifpr.trabalho.poo.modelo.Matricula;
import br.edu.ifpr.trabalho.poo.modelo.Professor;
import br.edu.ifpr.trabalho.poo.modelo.Turma;

public class ImplementacaoBusca implements IBuscaDeDados{

	public ArrayList<Matricula> buscarMatriculasAtivas() {
		MatriculaDAO matriculadao = new MatriculaDAO();
		return matriculadao.listar();
	}

	public ArrayList<Matricula> buscarTodasMatriculas() {
		MatriculaDAO matricula = new MatriculaDAO();
		return matricula.listar();
	}

	public ArrayList<Aluno> buscarAlunos() {
		AlunoDAO  aluno = new AlunoDAO();
		return aluno.listar();
	}

	public ArrayList<Turma> buscarTurmas() {
		TurmaDAO turma = new TurmaDAO();
		return turma.listar();
		}

	public ArrayList<Professor> buscarProfessores() {
		ProfessorDAO  professor = new ProfessorDAO();
		return professor.listar();
	}

	public ArrayList<Disciplina> buscarDisciplinas() {
		DisciplinaDAO disciplina = new DisciplinaDAO();
		return disciplina.listar();
	}

	public ArrayList<Curso> buscarCursos() {
		CursoDAO curso = new CursoDAO();
		return curso.listar();
	}

	public ArrayList<Campus> buscarCampi() {
		CampusDAO campus = new CampusDAO();
		return campus.listar();
	}

}
