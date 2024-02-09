package br.edu.senai.controller;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.util.ArrayList;

import br.edu.senai.model.Aluno;
import br.edu.senai.util.Log;


public class main {
	
	private static String pathDataBase = "C:\\TEMP\\Datas\\DataBase.csv";
	
	public static void main(String[] args) {
		
		Aluno a1 = new Aluno(123L, "Josue", "000.000.000-00");
	
		Aluno a2 = new Aluno();
		a2.setId(1234L);
		a2.setNome("JuJu");
		a2.setCpf("111.111.111-11");
		
		ArrayList<Aluno> lista = new ArrayList<Aluno>();
		lista.add(a1);
		lista.add(a2);
		
		try {
			
			PrintWriter pw = new PrintWriter(pathDataBase,
					Charset.forName("UTF-8"));
			
			for(Aluno aluno : lista) {
				pw.print(aluno.getId());
				pw.print(";" + aluno.getNome());
				pw.print(";" + aluno.getCpf());
				pw.println();
				
			}
			pw.close();
			Log.writeLog("Success!");
		}catch(Exception e) {
			Log.writeLog("Erro:" + e .getMessage());
			System.out.println("Erro: " + e.getMessage());
		}
		
		BufferedReader br;
		try {
			br = new BufferedReader(new FileReader(pathDataBase));
			
			String linha;
			while((linha = br.readLine()) != null) {
				System.out.println(linha);
			}
		} catch (Exception e) {
			Log.writeLog(e.getMessage());
		} finally {
			br.close();
		}
		
		
		
		
		
	}

}