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
		System.out.println("Informe a carga horária da Disciplina:");
		String cargaHoraria = teclado.nextLine();
		Turma turma = new Turma();
		System.out.println("Informe o ID da Turma: ");
		int idTurma = teclado.nextInt();
		turma.setIdTurma(idTurma);
		
		Professor professor = new Professor();
		System.out.println("Informe o ID do Professor(a): ");
		int idProfessor = teclado.nextInt();
		professor.setIdProfessor(idProfessor);
		
		Disciplina disciplina = new Disciplina();
		disciplina.setNome(nome);
		disciplina.setCargaHoraria(cargaHoraria);
		disciplina.setTurma(turma);
		turma.setIdTurma(idTurma);
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
		String SQL = "INSERT INTO tb_disciplina (nome, carga_horaria, fk_turma, fk_professor) VALUES (?, ?, ?, ?)";
		try {
			// PreparedStatement é um comando que aumenta a segunça contra ataques de
			// SQLInjection
			PreparedStatement preparacaoDaInstrucao = Conexao.getConexao().prepareStatement(SQL);
			preparacaoDaInstrucao.setString(1, disciplina.getNome());
			preparacaoDaInstrucao.setString(2, disciplina.getCargaHoraria());
			preparacaoDaInstrucao.setInt(3, disciplina.getTurma().getIdTurma());
			preparacaoDaInstrucao.setInt(4, disciplina.getProfessor().getIdProfessor());

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
			disciplina.setIdDisciplina(resultSet.getInt("id_disciplina"));
			disciplina.setNome(resultSet.getString("nome"));
			disciplina.setCargaHoraria(resultSet.getString("carga_horaria"));
			turma.setIdTurma(resultSet.getInt("fk_turma"));
			professor.setIdProfessor(resultSet.getInt("fk_professor"));

		} catch (Exception e) {
			e.printStackTrace();
			throw new SQLException("Erro ao transformar");
		}

		return disciplina;
	}

}
