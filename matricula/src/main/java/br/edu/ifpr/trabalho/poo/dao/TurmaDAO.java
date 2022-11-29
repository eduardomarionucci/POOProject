package br.edu.ifpr.trabalho.poo.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import br.edu.ifpr.trabalho.poo.conexao.Conexao;
import br.edu.ifpr.trabalho.poo.modelo.Turma;
import br.edu.ifpr.trabalho.poo.modelo.Curso;

public class TurmaDAO {
	public Turma lerDadosTurma() {
		Scanner teclado = new Scanner(System.in);

		System.out.println("Informe o nome da Turma:");
		String nome = teclado.nextLine();
		System.out.println("Informe a número minimo da Turma:");
		int numeroMinimo = teclado.nextInt();
		System.out.println("Informe ano de Ingresso do Curso: ");
		int anoIngresso = teclado.nextInt();
		System.out.println("Informe o ID do Curso: ");
		int idCurso = teclado.nextInt();

		Turma turma = new Turma();
		Curso curso = new Curso();

		turma.setNome(nome);
		turma.setAnoIngresso(anoIngresso);
		turma.setNumeroMinimo(numeroMinimo);
		curso.setIdCurso(idCurso);
		turma.setCurso(curso);

		return turma;

	}

	public ArrayList<Turma> listar() {
		ArrayList<Turma> listaDeTurma = new ArrayList<Turma>();
		String SQL = "SELECT * FROM matricula.tb_turma";

		try {
			// executar sql, que retorna um resultSet
			PreparedStatement preparacaoDaInstrucao = Conexao.getConexao().prepareStatement(SQL);
			// percorrer o resultSet e transformar cada resgistro ara objeto
			ResultSet resultado = preparacaoDaInstrucao.executeQuery();

			// adicionar cada registro na listaDeTurma
			while (resultado.next()) {
				Turma turma = transformarResultSetEmObjeto(resultado);
				listaDeTurma.add(turma);
			}
		} catch (Exception e) {

		}

		return listaDeTurma;

	}

	public static void salvarTurma(Turma turma) {
		String SQL = "INSERT INTO tb_turma (nome, numero_minimo, ano_ingresso, fk_curso) VALUES (?, ?, ?, ?)";
		try {
			// PreparedStatement é um comando que aumenta a segunça contra ataques de
			// SQLInjection
			PreparedStatement preparacaoDaInstrucao = Conexao.getConexao().prepareStatement(SQL);
			preparacaoDaInstrucao.setString(1, turma.getNome());
			preparacaoDaInstrucao.setInt(2, turma.getNumeroMinimo());
			preparacaoDaInstrucao.setInt(3, turma.getAnoIngresso());
			preparacaoDaInstrucao.setInt(4, turma.getCurso().getIdCurso());

			preparacaoDaInstrucao.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// transformar
	public static Turma transformarResultSetEmObjeto(ResultSet resultSet) throws SQLException {
		Turma turma = new Turma();
		Curso curso = new Curso();
		try {
			turma.setIdTurma(resultSet.getInt("id_turma"));
			turma.setNome(resultSet.getString("nome"));
			turma.setNumeroMinimo(resultSet.getInt("numero_minimo"));
			turma.setAnoIngresso(resultSet.getInt("ano_ingresso"));
			curso.setIdCurso(resultSet.getInt("fk_curso"));

		} catch (Exception e) {
			e.printStackTrace();
			throw new SQLException("Erro ao transformar");
		}

		return turma;
	}
}
