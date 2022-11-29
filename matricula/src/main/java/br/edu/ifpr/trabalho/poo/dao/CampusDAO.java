package br.edu.ifpr.trabalho.poo.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import br.edu.ifpr.trabalho.poo.modelo.Campus;
import br.edu.ifpr.trabalho.poo.conexao.Conexao;

public class CampusDAO {
	public Campus lerDadosCampus() {
		Scanner teclado = new Scanner(System.in);
		System.out.println("Informe o nome do campus:");
		String nome = teclado.nextLine();
		System.out.println("Informe o endereço do campus:");
		String endereco = teclado.nextLine();
		System.out.println("Informe a cidade do campus:");
		String cidade = teclado.nextLine();
		Campus campus = new Campus(nome, endereco, cidade);
		return campus;
		
	}
	public ArrayList<Campus> listar() {
		ArrayList<Campus> listaDeCampus = new ArrayList<Campus>();
		String SQL = "SELECT * FROM matricula.tb_campus";

		try {
			// executar sql, que retorna um resultSet
			PreparedStatement preparacaoDaInstrucao = Conexao.getConexao().prepareStatement(SQL);
			// percorrer o resultSet e transformar cada resgistro ara objeto
			ResultSet resultado = preparacaoDaInstrucao.executeQuery();
				
			// adicionar cada registro na listaDeCampus
			while (resultado.next()) {
				Campus campus = transformarResultSetEmObjeto(resultado);
				listaDeCampus.add(campus);
			}
		} catch (Exception e) {

		}

		return listaDeCampus;

	}

	public static void salvarCampus(Campus campus) {
		String SQL = "INSERT INTO tb_campus (nome, endereco, cidade) VALUES (?, ?, ?)";

		try {
			//PreparedStatement é um comando que aumenta a segunça contra ataques de SQLInjection
			PreparedStatement preparacaoDaInstrucao = Conexao.getConexao().prepareStatement(SQL);
			preparacaoDaInstrucao.setString(1, campus.getNome());
			preparacaoDaInstrucao.setString(2, campus.getEndereco());
			preparacaoDaInstrucao.setString(3, campus.getCidade());
			
			preparacaoDaInstrucao.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	// transformar
	public Campus transformarResultSetEmObjeto(ResultSet resultSet) throws SQLException {
		Campus campus = new Campus();
		try {
			campus.setIdCampus(resultSet.getInt("id_campus"));
			campus.setNome(resultSet.getString("nome"));
			campus.setEndereco(resultSet.getString("endereco"));
			campus.setCidade(resultSet.getString("cidade"));
		} catch (Exception e) {
			e.printStackTrace();
			throw new SQLException("Erro ao transformar");
		}

		return campus;
	}

}
