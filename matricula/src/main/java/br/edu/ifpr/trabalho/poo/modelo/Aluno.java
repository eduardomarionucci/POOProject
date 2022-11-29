package br.edu.ifpr.trabalho.poo.modelo;

import java.util.ArrayList;

import br.edu.ifpr.trabalho.poo.interfaces.IBuscaDeDados;
import br.edu.ifpr.trabalho.poo.interfaces.ILeituraDeDados;

public final class Aluno extends Pessoa {

	private int idAluno;
	private int anoIngresso;
	private Aluno aluno;

	public Aluno() {
		super();
	}

	public Aluno(String nome, String cpf, String telefone, String endereco, String dataNascimento, int anoIngresso, int idAluno, Aluno aluno) {
		super(nome, cpf, telefone, endereco, dataNascimento);
		this.anoIngresso = anoIngresso;
		this.idAluno = idAluno;
	}

	public int getAnoIngresso() {
		return anoIngresso;
	}

	public void setAnoIngresso(int anoIngresso) {
		this.anoIngresso = anoIngresso;
	}
	

	public int getIdAluno() {
		return idAluno;
	}

	public void setIdAluno(int idAluno) {
		this.idAluno = idAluno;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	@Override
	public void imprimirDados() {
		System.out.println();
		System.out.println("Nome do aluno: " + this.getNome());
		System.out.println("CPF do aluno: " + this.getCpf());
		System.out.println("Telefone do aluno: " + this.getTelefone());
		System.out.println("Endereço do aluno: " + this.getEndereco());
		System.out.println("Data de nascimento do aluno: " + this.getDataNascimento());
		System.out.println("Data de ingresso do aluno: " + anoIngresso);
	}

}
