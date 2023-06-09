package br.com.concessionaria.dao;

import java.sql.*;

public class CreateDatabase {

	public static void main(String[] args) {
		Connection con = null;
		Statement stmt = null;

		try {
			Class.forName("org.sqlite.JDBC");
			con = DriverManager.getConnection("jdbc:sqlite:src/br/com/concessionaria/dao/concessionaria.db");
			System.out.println("Banco de dados aberto com sucesso.");

			stmt = con.createStatement();
			String sql = "CREATE TABLE clientes " + "" + "(id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,"
					+ " nome VARCHAR(100) NOT NULL," + " cpf VARCHAR(14) NOT NULL UNIQUE," + " endereco VARCHAR(255),"
					+ " telefone VARCHAR(12));"

					+ "CREATE TABLE colaboradores " + "" + "(id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,"
					+ " nome VARCHAR(100) NOT NULL," + " cpf VARCHAR(14) NOT NULL UNIQUE," + " endereco VARCHAR(255), "
					+ " telefone VARCHAR(12)," + " salario DOUBLE," + " cargo VARCHAR(20)); "

					+ "CREATE TABLE servicos " + "" + "(id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,"
					+ " nome VARCHAR(100) NOT NULL," + " descricao TEXT(255)," + " valor DOUBLE ); "

					+ "CREATE TABLE veiculos " + "" + "(id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,"
					+ " modelo VARCHAR(30) NOT NULL," + " chassi VARCHAR(30) NOT NULL," + " cor VARCHAR(30),"
					+ " placa VARCHAR(10) NOT NULL UNIQUE," + " ano VARCHAR(10)," + " valor DOUBLE );"

					+ "CREATE TABLE ordens_servicos " + "" + "(id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,"
					+ " cliente INTEGER NOT NULL," + " colaborador INTEGER NOT NULL," + " servico INTEGER NOT NULL,"
					+ " veiculo INTEGER NOT NULL," + " valor_os DOUBLE NOT NULL,"
					+ " FOREIGN KEY (cliente) REFERENCES clientes (id),"
					+ " FOREIGN KEY (colaborador) REFERENCES colaboradores (id),"
					+ " FOREIGN KEY (servico) REFERENCES servicos (id),"
					+ " FOREIGN KEY (veiculo) REFERENCES veiculos (id));"

					+ "CREATE TABLE vendas " + "" + "(id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,"
					+ " cliente INTEGER NOT NULL," + " colaborador INTEGER NOT NULL," + " veiculo INTEGER NOT NULL,"
					+ " valor_total DOUBLE NOT NULL," + " FOREIGN KEY (cliente) REFERENCES clientes (id),"
					+ " FOREIGN KEY (colaborador) REFERENCES colaboradores (id),"
					+ " FOREIGN KEY (veiculo) REFERENCES veiculos (id));";

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
