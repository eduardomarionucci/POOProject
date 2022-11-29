package br.edu.ifpr.trabalho.poo.modelo;

import java.util.ArrayList;

import br.edu.ifpr.trabalho.poo.interfaces.IBuscaDeDados;
import br.edu.ifpr.trabalho.poo.interfaces.IInserirDados;
import br.edu.ifpr.trabalho.poo.interfaces.ILeituraDeDados;

public class Disciplina {

	private int idDisciplina;
	private String nome;
	private String cargaHoraria;
	
	private Turma turma;
	private Professor professor;

	public Disciplina() {
		super();
	}

	public Disciplina(int idDisciplina, String nome, String cargaHoraria, Disciplina disciplina, Turma turma,
			Professor professor) {
		super();
		this.idDisciplina = idDisciplina;
		this.nome = nome;
		this.cargaHoraria = cargaHoraria;
		
		this.turma = turma;
		this.professor = professor;
	}

	public Turma getTurma() {
		return turma;
	}

	public void setTurma(Turma turma) {
		this.turma = turma;
	}

	public Professor getProfessor() {
		return professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}

	public int getIdDisciplina() {
		return idDisciplina;
	}

	public void setIdDisciplina(int idDisciplina) {
		this.idDisciplina = idDisciplina;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCargaHoraria() {
		return cargaHoraria;
	}

	public void setCargaHoraria(String cargaHoraria) {
		this.cargaHoraria = cargaHoraria;
	}


}
