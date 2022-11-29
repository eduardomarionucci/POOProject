package br.edu.ifpr.trabalho.poo.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import br.edu.ifpr.trabalho.poo.conexao.Conexao;
import br.edu.ifpr.trabalho.poo.modelo.Campus;
import br.edu.ifpr.trabalho.poo.modelo.Professor;

public class ProfessorDAO {
	public Professor lerDadosProfessor() {
		Scanner teclado = new Scanner(System.in);
		System.out.println("Informe o nome do professor:");
		String nome = teclado.nextLine();
		System.out.println("Informe o CPF do professor:");
		String cpf = teclado.nextLine();
		System.out.println("Informe o telefone do professor:");
		String telefone = teclado.nextLine();
		System.out.println("Informe a endereço do professor:");
		String endereco = teclado.nextLine();
		System.out.println("Informe a data de nascimento do professor:");
		String dataNascimento = teclado.nextLine();
		System.out.println("Informe o SIAPE: ");
		String siape = teclado.nextLine();

		Professor professor = new Professor();
		professor.setNome(nome);
		professor.setCpf(cpf);
		professor.setTelefone(telefone);
		professor.setEndereco(endereco);
		professor.setDataNascimento(dataNascimento);
		professor.setSiape(siape);
		
		
		return professor;

	}

	public ArrayList<Professor> listar() {
		ArrayList<Professor> listaDeProfessores = new ArrayList<Professor>();
		String SQL = "SELECT * FROM matricula.tb_professor";

		try {
			// executar sql, que retorna um resultSet
			PreparedStatement preparacaoDaInstrucao = Conexao.getConexao().prepareStatement(SQL);
			// percorrer o resultSet e transformar cada resgistro ara objeto
			ResultSet resultado = preparacaoDaInstrucao.executeQuery();

			// adicionar cada registro na listaDeCampus
			while (resultado.next()) {
				Professor professor = transformarResultSetEmObjeto(resultado);
				listaDeProfessores.add(professor);
			}
		} catch (Exception e) {

		}

		return listaDeProfessores;

	}

	public static void salvarProfessor(Professor Professor) {

		String SQL = "INSERT INTO tb_professor (nome, cpf, telefone, endereco, data_nascimento, siape) VALUES (?, ?, ?, ?, ?, ?)";
		try {
			PreparedStatement preparacaoDaInstrucao = Conexao.getConexao().prepareStatement(SQL);
			preparacaoDaInstrucao.setString(1, Professor.getNome());
			preparacaoDaInstrucao.setString(2, Professor.getCpf());
			preparacaoDaInstrucao.setString(3, Professor.getTelefone());
			preparacaoDaInstrucao.setString(4, Professor.getEndereco());
			preparacaoDaInstrucao.setString(5, Professor.getDataNascimento());
			preparacaoDaInstrucao.setString(6, Professor.getSiape());
			preparacaoDaInstrucao.executeUpdate();
		} catch (SQLException excecao) {
			excecao.printStackTrace();
		}
	}

	// transformar
	public Professor transformarResultSetEmObjeto(ResultSet resultSet) throws SQLException {
		Professor professor = new Professor();
		try {
			professor.setNome(resultSet.getString("nome"));
			professor.setCpf(resultSet.getString("cpf"));
			professor.setEndereco(resultSet.getString("endereco"));
			professor.setTelefone(resultSet.getString("telefone"));
			professor.setDataNascimento(resultSet.getString("data_nascimento"));
			professor.setSiape(resultSet.getString("siape"));
		} catch (Exception e) {
			e.printStackTrace();
			throw new SQLException("Erro ao transformar");
		}

		return professor;
	}
}
