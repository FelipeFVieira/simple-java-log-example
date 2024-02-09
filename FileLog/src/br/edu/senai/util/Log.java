package br.edu.senai.util;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.time.LocalDate;

public class Log {
	
	private static String pathFile = "C:\\Temp\\log\\" ;	
	
	public static boolean writeLog(String msg) {
		String pathDestiny = pathFile 
				+ LocalDate.now().getYear() + "_"
				+ LocalDate.now().getMonth() + "_"
				+ LocalDate.now().getDayOfMonth() + ".log";
		
		PrintWriter pw;
		try {
		    pw = new PrintWriter(new FileWriter(pathDestiny,Charset.forName("UTF-8"),true));
			
			pw.append(msg).append("\n");
			
			pw.close();
			return true;
		} catch (Exception e) {
			System.out.println("Erro:" + e.getMessage());
			return false;
		}
	} 
}
