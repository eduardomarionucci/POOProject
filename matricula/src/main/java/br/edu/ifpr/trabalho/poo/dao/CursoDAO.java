package br.edu.ifpr.trabalho.poo.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import br.edu.ifpr.trabalho.poo.modelo.Campus;
import br.edu.ifpr.trabalho.poo.modelo.Curso;
import br.edu.ifpr.trabalho.poo.modelo.Professor;
import br.edu.ifpr.trabalho.poo.conexao.Conexao;

public class CursoDAO {
	public Curso lerDadosCurso() {
		Scanner teclado = new Scanner(System.in);

		// Formulário para o usuário
		CursoDAO cursoDAO = new CursoDAO();
		System.out.print("Informe o nome do curso:");
		String nome = teclado.nextLine();
		System.out.print("Informe a Duração do Curso:");
		String duracao = teclado.nextLine();
		System.out.print("Informe a Modalidade do Curso:");
		String modalidade = teclado.nextLine();
		System.out.println("Informe o código do Campus: ");
		int idCampus = teclado.nextInt();
		System.out.println();

		// Setando os valores aos objetos do CursoDAO
		Curso curso = new Curso();
		Campus campus = new Campus();
		curso.setNome(nome);
		curso.setDuracao(duracao);
		curso.setModalidade(modalidade);
		campus.setIdCampus(idCampus);
		curso.setCampus(campus);
		return curso;
	}

	public ArrayList<Curso> listar() {
		ArrayList<Curso> listaDeCursos = new ArrayList<Curso>();
		String SQL = "SELECT * FROM matricula.tb_curso";

		try {
			// executar sql, que retorna um resultSet
			PreparedStatement preparacaoDaInstrucao = Conexao.getConexao().prepareStatement(SQL);
			// percorrer o resultSet e transformar cada resgistro ara objeto
			ResultSet resultado = preparacaoDaInstrucao.executeQuery();

			// adicionar cada registro na listaDeCampus
			while (resultado.next()) {
				Curso curso = transformarResultSetEmObjeto(resultado);
				listaDeCursos.add(curso);
			}
		} catch (Exception e) {

		}

		return listaDeCursos;

	}

	public static void salvarCurso(Curso curso) {
		String SQL = "INSERT INTO tb_curso (nome, duracao, modalidade, fk_campus) VALUES (?, ?, ?, ?)";

		try {
			// PreparedStatement é um comando que aumenta a segunça contra ataques de
			// SQLInjection
			PreparedStatement preparacaoDaInstrucao = Conexao.getConexao().prepareStatement(SQL);
			preparacaoDaInstrucao.setString(1, curso.getNome());
			preparacaoDaInstrucao.setString(2, curso.getDuracao());
			preparacaoDaInstrucao.setString(3, curso.getModalidade());
			preparacaoDaInstrucao.setInt(4, curso.getCampus().getIdCampus());
			// falta colocar a f

			preparacaoDaInstrucao.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// transformar
	public Curso transformarResultSetEmObjeto(ResultSet resultSet) throws SQLException {
		Curso curso = new Curso();
		Campus campus = new Campus();
		try {
			curso.setIdCurso(resultSet.getInt("id_curso"));
			curso.setNome(resultSet.getString("nome"));
			curso.setDuracao(resultSet.getString("duracao"));
			curso.setModalidade(resultSet.getString("modalidade"));
			campus.setIdCampus(resultSet.getInt("fk_campus"));


		} catch (Exception e) {
			e.printStackTrace();
			throw new SQLException("Erro ao transformar");
		}

		return curso;
	}

}