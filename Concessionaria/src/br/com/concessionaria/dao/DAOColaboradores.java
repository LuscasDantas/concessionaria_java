package br.com.concessionaria.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import br.com.concessionaria.model.Colaborador;
import br.com.concessionaria.view.FormColaboradores;

public class DAOColaboradores {

	/*
	 * Cadastrar
	 */
	public static void cadastrarColaborador() throws SQLException {
		int response = JOptionPane.showConfirmDialog(null, "Deseja realmente cadastrar o colaborador?", "Confirmar",
				JOptionPane.YES_NO_OPTION);
		if (response == JOptionPane.NO_OPTION) {
			JOptionPane.getDefaultLocale();
		} else if (response == JOptionPane.YES_OPTION) {

			Connection con = null;

			try {
				Class.forName("org.sqlite.JDBC");
				con = DriverManager.getConnection("jdbc:sqlite:src/br/com/concessionaria/dao/concessionaria.db");
				con.setAutoCommit(false);
				String query = "INSERT INTO COLABORADORES (ID, NOME, CPF, TELEFONE, ENDERECO , CARGO)"
						+ "VALUES (NULL, ?,?,?,?,?)";
				PreparedStatement stmt = con.prepareStatement(query);
				stmt.setString(1, Colaborador.getNome());
				stmt.setString(2, Colaborador.getCpf());
				stmt.setString(3, Colaborador.getTelefone());
				stmt.setString(4, Colaborador.getEndereco());
				//smtt.setString(5, Colaborador.getCargo());
				stmt.execute();
				stmt.close();
				con.commit();
				con.close();

			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}

		}
	}

	/*
	 * Pesquisar
	 */
	public static void pesquisarColaborador() {
		Connection con = null;
		Statement stmt = null;
		try {
			Class.forName("org.sqlite.JDBC");
			con = DriverManager.getConnection("jdbc:sqlite:src/br/com/concessionaria/dao/concessionaria.db");
			con.setAutoCommit(false);
			System.out.println("Banco de dados aberto com sucesso");
			stmt = con.createStatement();
			ResultSet rs = stmt
					.executeQuery("SELECT * FROM COLABORADORES WHERE CPF =" + FormColaboradores.txtCPF.getText() + ";");
			while (rs.next()) {
				int id = rs.getInt("idColaborador");
				String nome = rs.getString("Nome");
				String cpf = rs.getString("Cpf");
				String telefone = rs.getString("Telefone");
				String Endereco = rs.getString("Endereço");

				//FormColaboradores.txtId.setText(id);
				FormColaboradores.txtNome.setText(nome);
				FormColaboradores.txtCPF.setText(cpf);
				FormColaboradores.txtTelefone.setText(telefone);
				FormColaboradores.txtEndereco.setText(Endereco);
			}
			rs.close();
			stmt.close();
			con.close();

		} catch (Exception e) {
			JOptionPane.showMessageDialog(new JFrame(), "Registro inexistente", "Dialog", JOptionPane.ERROR_MESSAGE);

		}
	}

	/*
	 * Deletar
	 */
	public static void deletarColaborador() {
		int response = JOptionPane.showConfirmDialog(null, "Deseja realmente deletar o registro?", "Confirmar",
				JOptionPane.YES_NO_OPTION);

		if (response == JOptionPane.NO_OPTION) {
			JOptionPane.getDefaultLocale();
		} else if (response == JOptionPane.YES_OPTION) {
			Connection con = null;
			Statement stmt = null;
			try {
				Class.forName("");
				con = DriverManager.getConnection("");
				con.setAutoCommit(false);
				stmt = con.createStatement();
				String query = "DELETE from COLABORADORES WHERE CPF=" + FormColaboradores.txtCPF.getText() + ";";
				stmt.executeUpdate(query);
				con.commit();
				stmt.close();
				con.close();

			} catch (Exception e) {
				JOptionPane.showMessageDialog(new JFrame(), "Registro inexistente", "Atenção",
						JOptionPane.ERROR_MESSAGE);
			}
			System.out.println("Registro Deletado com sucesso!");
		}

	}
}
