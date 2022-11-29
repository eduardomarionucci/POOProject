package br.edu.ifpr.trabalho.poo.conexao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import br.edu.ifpr.trabalho.poo.dao.CampusDAO;
import br.edu.ifpr.trabalho.poo.modelo.Campus;

public class TestaCampus {

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);

		// Formul�rio para o usu�rio
		CampusDAO campusDAO = new CampusDAO();
		System.out.print("Informe o nome do campus:");
		String nome = teclado.nextLine();
		System.out.print("Informe o Endere�o do Campus:");
		String endereco = teclado.nextLine();
		System.out.print("Informe a Cidade do Campus:");
		String cidade = teclado.nextLine();
		System.out.println();

		// Setando os valores aos objetos do CampusDAO
		Campus campus = new Campus();
		campus.setNome(nome);
		campus.setEndereco(endereco);
		campus.setCidade(cidade);

		CampusDAO.salvarCampus(campus);

		ArrayList<Campus> listarCampus = campusDAO.listar();

		for (Campus c : listarCampus) {
			System.out.println();
			System.out.println("INFORMA��ES DO CAMPUS");
			System.out.println("Nome do Campus: " + c.getNome());
			System.out.println("Endereco do Campus: " + c.getEndereco());
			System.out.println("Cidade do Campus: " + c.getCidade());

		}
	}

}
