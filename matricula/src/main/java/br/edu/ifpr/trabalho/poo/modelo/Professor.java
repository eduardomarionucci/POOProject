package br.edu.ifpr.trabalho.poo.modelo;

public class Professor extends Pessoa {

	private int idProfessor;
	private String siape;

	public Professor() {
		super();

	}

	public Professor(String nome, String cpf, String telefone, String dataNascimento,String endereco, String siape, int idProfessor) {
		super(nome, cpf, telefone, endereco, dataNascimento);
		this.siape = siape;
		this.idProfessor = idProfessor;

	}

	public String getSiape() {
		return siape;
	}

	public void setSiape(String siape) {
		this.siape = siape;
	}


	public int getIdProfessor() {
		return idProfessor;
	}

	public void setIdProfessor(int idProfessor) {
		this.idProfessor = idProfessor;
	}

	@Override
	public void imprimirDados() {
		System.out.println();
		System.out.println("Nome do professor: " + this.getNome());
		System.out.println("CPF do professor: " + this.getCpf());
		System.out.println("Telefone do professor: " + this.getTelefone());
		System.out.println("Endereço do professor: " + this.getEndereco());
		System.out.println("Data de nascimento do professor: " + this.getDataNascimento());
		System.out.println("Número do Siape: " + this.siape);
	}
}
