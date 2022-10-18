package br.edu.ifpr.acessar.bancodedados;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.edu.ifpr.matricula.conexao.Campus;
import br.edu.ifpr.matricula.conexao.Conexao;

public class CampusDAO {
	// inserção
	// atualização
	// remoção
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

	// transformar
	public Campus transformarResultSetEmObjeto(ResultSet resultSet) throws SQLException {
		Campus campus = new Campus();
		try {
			campus.setIdCampus(resultSet.getInt("idtb_campus"));
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
