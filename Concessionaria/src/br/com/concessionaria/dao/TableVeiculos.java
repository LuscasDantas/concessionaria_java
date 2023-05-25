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
			String sql = "CREATE TABLE clientes "+ ""
					+ "(id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,"
					+ " nome VARCHAR(100)," + " cpf VARCHAR(14),"
				    + " endereco VARCHAR(255)," + " telefone VARCHAR(12));"
					
					+ "CREATE TABLE colaboradores "+ ""
					+ "(id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,"
					+ " nome VARCHAR(100)," + " cpf VARCHAR(14),"
				    + " endereco VARCHAR(255), " + " telefone VARCHAR(12),"
					+ " salario DOUBLE," + " cargo VARCHAR(20)); "
			
					+ "CREATE TABLE servicos " + "" + "(id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,"
					+ " nome VARCHAR(100)," + " descricao TEXT(255)," + " valor DOUBLE ); "
					
					+"CREATE TABLE veiculos " + ""
					+ "(id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,"
					+ " modelo VARCHAR(30)," + " chassi VARCHAR(30)," 
					+ " cor VARCHAR(30)," + " placa VARCHAR(10) NOT NULL,"
					+ " ano VARCHAR(10)," + " valor DOUBLE )";
					
			stmt.executeUpdate(sql);
			stmt.close();
			con.close();
		} catch (Exception e) {
			
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}
		
		System.out.println("Banco criado com sucesso!");
	}
}
