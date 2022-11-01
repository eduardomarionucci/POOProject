package br.edu.ifpr.trabalho.poo.modelo;

import java.util.ArrayList;

import br.edu.ifpr.trabalho.poo.conexao.Campus;
import br.edu.ifpr.trabalho.poo.interfaces.IBuscaDeDados;
import br.edu.ifpr.trabalho.poo.interfaces.ILeituraDeDados;

public class Aluno extends Pessoa {

	private int anoIngresso;

	public int getAnoIngresso() {
		return anoIngresso;
	}

	public Aluno() {

	}

	public Aluno(int anoIngresso) {
		super();
		this.anoIngresso = anoIngresso;
	}

	public void setAnoIngresso(int anoIngresso) {
		this.anoIngresso = anoIngresso;
	}

	@Override
	public void imprimirDados() {
		// TODO Auto-generated method stub
		
	}

}
