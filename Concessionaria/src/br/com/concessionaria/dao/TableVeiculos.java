package br.com.concessionaria.dao;

import java.sql.*;

public class TableVeiculos {
	
	public static void main(String[] args) {
		Connection con = null;
		Statement stmt = null;
		
		try {
			Class.forName("org.sqlite.JDBC");
			con = DriverManager.getConnection("jdbc:sqlite:src/br/com/concessionaria/dao/concessionaria.db");
			System.out.println("Banco de dados aberto com sucesso.");
			
			stmt = con.createStatement();
			String sql = "CREATE TABLE VEICULOS " + ""
					+ "(ID INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, "
					+ "MODELO VARCHAR(30), " + "CHASSI VARCHAR(30), " 
					+ "COR VARCHAR(30), " + "PLACA VARCHAR(10) NOT NULL, "
					+ "ANO VARCHAR(10), " + "VALOR DOUBLE )";
			stmt.executeUpdate(sql);
			stmt.close();
			con.close();
		} catch (Exception e) {
			
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}
		
		System.out.println("Tabela criada com sucesso!");
	}
}
