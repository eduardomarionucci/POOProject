package br.edu.ifpr.trabalho.poo.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import br.edu.ifpr.trabalho.poo.conexao.Conexao;
import br.edu.ifpr.trabalho.poo.modelo.Aluno;
import br.edu.ifpr.trabalho.poo.modelo.Disciplina;
import br.edu.ifpr.trabalho.poo.modelo.Matricula;
import br.edu.ifpr.trabalho.poo.modelo.Professor;
import br.edu.ifpr.trabalho.poo.modelo.Turma;

public class MatriculaDAO {
	public static Matricula lerDadosMatricula() {
		Scanner teclado = new Scanner(System.in);

		System.out.println("Informe o RA: ");
		String ra = teclado.nextLine();
		System.out.println("Informe a data: ");
		String data = teclado.nextLine();
		System.out.println("Informe a Situação (APROVADO = true /REPROVADO = false)");
		boolean situacao = teclado.nextBoolean();
		System.out.println("Informe o ID do Aluno:");
		int idAluno = teclado.nextInt();
		System.out.println("Informe o ID da Turma:");
		int idTurma = teclado.nextInt();

		Matricula matricula = new Matricula();
		Aluno aluno = new Aluno();
		Turma turma = new Turma();

		matricula.setRa(ra);
		matricula.setData(data);
		matricula.setSituacao(situacao);
		turma.setIdTurma(idTurma);
		matricula.setTurma(turma);
		aluno.setIdAluno(idAluno);
		matricula.setAluno(aluno);

		return matricula;

	}

	public ArrayList<Matricula> listar() {
		ArrayList<Matricula> listaDeMatricula = new ArrayList<Matricula>();
		String SQL = "SELECT * FROM matricula.tb_matricula";

		try {
			// executar sql, que retorna um resultSet
			PreparedStatement preparacaoDaInstrucao = Conexao.getConexao().prepareStatement(SQL);
			// percorrer o resultSet e transformar cada resgistro ara objeto
			ResultSet resultado = preparacaoDaInstrucao.executeQuery();

			// adicionar cada registro na listaDeMatricula
			while (resultado.next()) {
				Matricula matricula = transformarResultSetEmObjeto(resultado);
				listaDeMatricula.add(matricula);
			}
		} catch (Exception e) {

		}

		return listaDeMatricula;

	}
	public ArrayList<Matricula> listarAtivo() {
		ArrayList<Matricula> listaDeMatricula = new ArrayList<Matricula>();
		String SQL = "SELECT * FROM matricula.tb_matricula WHERE situacao = 1";

		try {
			// executar sql, que retorna um resultSet
			PreparedStatement preparacaoDaInstrucao = Conexao.getConexao().prepareStatement(SQL);
			// percorrer o resultSet e transformar cada resgistro ara objeto
			ResultSet resultado = preparacaoDaInstrucao.executeQuery();

			// adicionar cada registro na listaDeMatricula
			while (resultado.next()) {
				Matricula matricula = transformarResultSetEmObjeto(resultado);
				listaDeMatricula.add(matricula);
			}
		} catch (Exception e) {

		}

		return listaDeMatricula;

	}

	public static void salvarMatricula(Matricula matricula) {
		String SQL = "INSERT INTO tb_matricula (ra, data, fk_turma, fk_aluno) VALUES (?, ?, ?, ?)";
		try {
			PreparedStatement preparacaoDaInstrucao = Conexao.getConexao().prepareStatement(SQL);
			preparacaoDaInstrucao.setString(1, matricula.getRa());
			preparacaoDaInstrucao.setString(2, matricula.getData());
			preparacaoDaInstrucao.setInt(3, matricula.getTurma().getIdTurma());
			preparacaoDaInstrucao.setInt(4, matricula.getAluno().getIdAluno());
			preparacaoDaInstrucao.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Matricula transformarResultSetEmObjeto(ResultSet resultSet) throws SQLException {
		Matricula matricula = new Matricula();
		Aluno aluno = new Aluno();
		Turma turma = new Turma();
		try {
			matricula.setRa(resultSet.getString("ra"));
			matricula.setData(resultSet.getString("data"));
			matricula.setSituacao(resultSet.getBoolean("situacao"));
			aluno.setIdAluno(resultSet.getInt("fk_aluno"));
			turma.setIdTurma(resultSet.getInt("fk_turma"));

		} catch (Exception e) {
			e.printStackTrace();
			throw new SQLException("Erro ao transformar");
		}
		return matricula;
	}
}
