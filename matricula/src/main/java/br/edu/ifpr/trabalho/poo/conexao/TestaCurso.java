package br.edu.ifpr.trabalho.poo.conexao;

import java.util.ArrayList;
import java.util.Scanner;

import br.edu.ifpr.trabalho.poo.dao.CursoDAO;
import br.edu.ifpr.trabalho.poo.implementacao.ImplementacaoBusca;
import br.edu.ifpr.trabalho.poo.implementacao.ImplementacaoInserir;
import br.edu.ifpr.trabalho.poo.implementacao.ImplementacaoLerDados;
import br.edu.ifpr.trabalho.poo.modelo.Campus;
import br.edu.ifpr.trabalho.poo.modelo.Curso;

public class TestaCurso {
	public static void main(String[] args) {
		
		ImplementacaoLerDados leitura = new ImplementacaoLerDados();
		ImplementacaoBusca busca = new ImplementacaoBusca();
		ImplementacaoInserir insercao = new ImplementacaoInserir();
		
		Curso curso = leitura.lerDadosCurso();
		
		CursoDAO.salvarCurso(curso);

		CursoDAO cursoDAO = new CursoDAO();
		ArrayList<Curso> listarCurso = cursoDAO.listar();

		for (Curso c : listarCurso) {
			System.out.println(c.getNome());
			System.out.println(c.getIdCurso());
		}
	}
}
