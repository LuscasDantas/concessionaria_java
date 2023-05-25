package br.com.concessionaria.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class TableServicos {

	public static void main(String[] args) {
		Connection con = null;
		Statement stmt = null;

		try {
			Class.forName("org.sqlite.JDBC");
			con = DriverManager.getConnection("jdbc:sqlite:src/br/com/concessionaria/dao/concessionaria.db");
			System.out.println("Banco de dados aberto com sucesso.");

			stmt = con.createStatement();
			String sql = "CREATE TABLE SERVICOS " + "" + "(ID INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,"
					+ " NOME VARCHAR(100)," + " DESCRICAO TEXT(255)," + " VALOR DOUBLE )";
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
