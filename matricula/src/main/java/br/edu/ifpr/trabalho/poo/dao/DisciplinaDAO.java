package br.edu.ifpr.trabalho.poo.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import br.edu.ifpr.trabalho.poo.conexao.Conexao;
import br.edu.ifpr.trabalho.poo.modelo.Disciplina;
import br.edu.ifpr.trabalho.poo.modelo.Professor;
import br.edu.ifpr.trabalho.poo.modelo.Turma;

public class DisciplinaDAO {
	public Disciplina lerDadosDisciplina() {
		Scanner teclado = new Scanner(System.in);

		System.out.println("Informe o nome da Disciplina:");
		String nome = teclado.nextLine();
		System.out.println("Informe o ID da Turma: ");
		int idTurma = teclado.nextInt();
		System.out.println("Informe o ID do Professor(a): ");
		int idProfessor = teclado.nextInt();

		Disciplina disciplina = new Disciplina();
		Turma turma = new Turma();
		Professor professor = new Professor();

		disciplina.setNome(nome);
		turma.setIdTurma(idTurma);
		disciplina.setTurma(turma);

		professor.setIdProfessor(idProfessor);
		disciplina.setProfessor(professor);

		return disciplina;
	}

	public ArrayList<Disciplina> listar() {
		ArrayList<Disciplina> listaDeDisciplina = new ArrayList<Disciplina>();
		String SQL = "SELECT * FROM matricula.tb_disciplina";

		try {
			// executar sql, que retorna um resultSet
			PreparedStatement preparacaoDaInstrucao = Conexao.getConexao().prepareStatement(SQL);
			// percorrer o resultSet e transformar cada resgistro ara objeto
			ResultSet resultado = preparacaoDaInstrucao.executeQuery();

			// adicionar cada registro na listaDeDisciplina
			while (resultado.next()) {
				Disciplina disciplina = transformarResultSetEmObjeto(resultado);
				listaDeDisciplina.add(disciplina);
			}
		} catch (Exception e) {

		}

		return listaDeDisciplina;

	}

	public static void salvarDisciplina(Disciplina disciplina) {
		String SQL = "INSERT INTO tb_disciplina (nome, fk_turma, fk_professor) VALUES (?, ?, ?)";
		try {
			// PreparedStatement é um comando que aumenta a segunça contra ataques de
			// SQLInjection
			PreparedStatement preparacaoDaInstrucao = Conexao.getConexao().prepareStatement(SQL);
			preparacaoDaInstrucao.setString(1, disciplina.getNome());
			preparacaoDaInstrucao.setInt(2, disciplina.getTurma().getIdTurma());
			preparacaoDaInstrucao.setInt(3, disciplina.getProfessor().getIdProfessor());
			preparacaoDaInstrucao.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// transformar
	public Disciplina transformarResultSetEmObjeto(ResultSet resultSet) throws SQLException {
		Disciplina disciplina = new Disciplina();
		Turma turma = new Turma();
		Professor professor = new Professor();
		try {
			disciplina.setNome(resultSet.getString("nome"));
			turma.setIdTurma(resultSet.getInt("fk_turma"));
			professor.setIdProfessor(resultSet.getInt("fk_professor"));

		} catch (Exception e) {
			e.printStackTrace();
			throw new SQLException("Erro ao transformar");
		}

		return disciplina;
	}

}
