package br.edu.ifpr.trabalho.poo.modelo;

import java.util.ArrayList;

import br.edu.ifpr.trabalho.poo.conexao.Campus;
import br.edu.ifpr.trabalho.poo.interfaces.IBuscaDeDados;
import br.edu.ifpr.trabalho.poo.interfaces.IInserirDados;
import br.edu.ifpr.trabalho.poo.interfaces.ILeituraDeDados;

public class Disciplina implements IInserirDados, IBuscaDeDados, ILeituraDeDados{

	public Aluno lerDadosAluno() {
		// TODO Auto-generated method stub
		return null;
	}

	public Professor lerDadosProfessor() {
		// TODO Auto-generated method stub
		return null;
	}

	public Curso lerDadosCurso() {
		// TODO Auto-generated method stub
		return null;
	}

	public Turma lerDadosTurma() {
		// TODO Auto-generated method stub
		return null;
	}

	public Turma lerDadosTurma(Curso curso) {
		// TODO Auto-generated method stub
		return null;
	}

	public Disciplina lerDadosDisciplina(Professor professor, Turma turma) {
		// TODO Auto-generated method stub
		return null;
	}

	public Matricula lerDadosMatricula() {
		// TODO Auto-generated method stub
		return null;
	}

	public Matricula lerDadosMatricula(Aluno aluno, Turma turma) {
		// TODO Auto-generated method stub
		return null;
	}

	public Campus lerDadosCampus() {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<Matricula> buscarMatriculasAtivas() {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<Matricula> buscarTodasMatriculas() {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<Aluno> buscarAlunos() {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<Turma> buscarTurmas() {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<Professor> buscarProfessores() {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<Disciplina> buscarDisciplinas() {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<Curso> buscarCursos() {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<br.edu.ifpr.trabalho.poo.campus.Campus> buscarCampi() {
		// TODO Auto-generated method stub
		return null;
	}

	public void salvarAluno(Aluno aluno) {
		// TODO Auto-generated method stub
		
	}

	public void salvarProfessor(Professor professor) {
		// TODO Auto-generated method stub
		
	}

	public void salvarCurso(Curso curso) {
		// TODO Auto-generated method stub
		
	}

	public void salvarTurma(Turma turma) {
		// TODO Auto-generated method stub
		
	}

	public void salvarDisciplina(Disciplina disciplina) {
		// TODO Auto-generated method stub
		
	}

	public void salvarMatricula(Matricula matricula) {
		// TODO Auto-generated method stub
		
	}

	public void salvarCampus(br.edu.ifpr.trabalho.poo.campus.Campus campus) {
		// TODO Auto-generated method stub
		
	}

}
