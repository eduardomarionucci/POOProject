package br.edu.ifpr.matricula.conexao;

import java.util.ArrayList;
import java.util.Iterator;

import br.edu.ifpr.acessar.bancodedados.CampusDAO;

public class TestaConexao {

	public static void main(String[] args) {
		CampusDAO campusDAO = new CampusDAO();
		
		ArrayList<Campus> listarCampus = campusDAO.listar();
		
		for (Campus campus : listarCampus) {
			System.out.println();
		}
	}

}
