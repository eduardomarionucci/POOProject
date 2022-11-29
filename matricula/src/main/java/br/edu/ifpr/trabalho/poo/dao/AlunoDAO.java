package br.edu.ifpr.trabalho.poo.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import br.edu.ifpr.trabalho.poo.conexao.Conexao;
import br.edu.ifpr.trabalho.poo.modelo.Aluno;

public class AlunoDAO {

	public Aluno lerDadosAluno() {
		Scanner teclado = new Scanner(System.in);

		// Formulário para o usuário

		System.out.print("Informe o Nome do Aluno(a): ");
		String nome = teclado.nextLine();
		System.out.print("Informe a CPF do Aluno(a): ");
		String cpf = teclado.nextLine();
		System.out.print("Informe o Endereço do Aluno(a): ");
		String endereco = teclado.nextLine();
		System.out.print("Informe o Telefone do Aluno(a): ");
		String telefone = teclado.nextLine();
		System.out.print("Informe a Data de Nascimento do Aluno(a): ");
		String dataNascimento = teclado.nextLine();
		System.out.print("Informe a Ano de Ingresso do Aluno: ");
		int anoIngresso = teclado.nextInt();

		// Setando os valores aos objetos do AlunoDAO
		Aluno aluno = new Aluno();
		aluno.setNome(nome);
		aluno.setCpf(cpf);
		aluno.setEndereco(endereco);
		aluno.setTelefone(telefone);
		aluno.setDataNascimento(dataNascimento);
		aluno.setAnoIngresso(anoIngresso);

		return aluno;
	}

	public ArrayList<Aluno> listar() {
		ArrayList<Aluno> listaDeAlunos = new ArrayList<Aluno>();
		String SQL = "SELECT * FROM matricula.tb_aluno";

		try {
			// executar sql, que retorna um resultSet
			PreparedStatement preparacaoDaInstrucao = Conexao.getConexao().prepareStatement(SQL);
			// percorrer o resultSet e transformar cada resgistro ara objeto
			ResultSet resultado = preparacaoDaInstrucao.executeQuery();

			// adicionar cada registro na listaDeCampus
			while (resultado.next()) {
				Aluno aluno = transformarResultSetEmObjeto(resultado);
				listaDeAlunos.add(aluno);
			}
		} catch (Exception e) {

		}

		return listaDeAlunos;

	}

	public static void salvarAluno(Aluno aluno) {

		String SQL = "INSERT INTO tb_aluno (nome, cpf, telefone, endereco, data_nascimento, ano_ingresso) VALUES (?, ?, ?, ?, ?, ?)";
		try {
			PreparedStatement preparacaoDaInstrucao = Conexao.getConexao().prepareStatement(SQL);
			preparacaoDaInstrucao.setString(1, aluno.getNome());
			preparacaoDaInstrucao.setString(2, aluno.getCpf());
			preparacaoDaInstrucao.setString(3, aluno.getTelefone());
			preparacaoDaInstrucao.setString(4, aluno.getEndereco());
			preparacaoDaInstrucao.setString(5, aluno.getDataNascimento());
			preparacaoDaInstrucao.setInt(6, aluno.getAnoIngresso());
			preparacaoDaInstrucao.executeUpdate();
		} catch (SQLException excecao) {
			excecao.printStackTrace();
		}
	}

	// transformar
	public Aluno transformarResultSetEmObjeto(ResultSet resultSet) throws SQLException {
		Aluno aluno = new Aluno();
		try {
			aluno.setNome(resultSet.getString("nome"));
			aluno.setCpf(resultSet.getString("cpf"));
			aluno.setEndereco(resultSet.getString("endereco"));
			aluno.setTelefone(resultSet.getString("telefone"));
			aluno.setDataNascimento(resultSet.getString("data_nascimento"));
			aluno.setAnoIngresso(resultSet.getInt("ano_ingresso"));
		} catch (Exception e) {
			e.printStackTrace();
			throw new SQLException("Erro ao transformar");
		}

		return aluno;
	}
}
