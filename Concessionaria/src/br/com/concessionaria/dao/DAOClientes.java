package br.com.concessionaria.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import br.com.concessionaria.model.Cliente;
import br.com.concessionaria.view.FormClientes;

public class DAOClientes {

	/*
	 * Cadastrar
	 */
	public static void cadastrarCliente() throws SQLException {
		int response = JOptionPane.showConfirmDialog(null, "Deseja realmente cadastrar o colaborador", "Confirmar",
				JOptionPane.YES_NO_OPTION);
		if (response == JOptionPane.NO_OPTION) {
			JOptionPane.getDefaultLocale();
		} else if (response == JOptionPane.YES_OPTION) {

			Connection con = null;

			try {
				Class.forName("org.sqlite.JDBC");
				con = DriverManager.getConnection("jdbc:sqlite:src/br/com/concessionaria/dao/concessionaria.db");
				con.setAutoCommit(false);
				String query = "INSERT INTO CLIENTE (ID, NOME, CPF, TELEFONE, ENDERECO)" + "VALUES (NULL, ?,?,?,?)";
				PreparedStatement stmt = con.prepareStatement(query);
				stmt.setString(1, Cliente.getNome());
				stmt.setString(2, Cliente.getCpf());
				stmt.setString(3, Cliente.getTelefone());
				stmt.setString(4, Cliente.getEndereco());
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
	public static void pesquisarCliente() {
		Connection con = null;
		Statement stmt = null;
		try {
			Class.forName("org.sqlite.JDBC");
			con = DriverManager.getConnection("jdbc:sqlite:src/br/com/concessionaria/dao/concessionaria.db");
			con.setAutoCommit(false);
			System.out.println("Banco de dados aberto com sucesso");
			stmt = con.createStatement();
			ResultSet rs = stmt
					.executeQuery("SELECT * FROM CLIENTES WHERE CPF =" + FormClientes.txtCPF.getText() + ";");
			while (rs.next()) {
				int id = rs.getInt("idCliente");
				String nome = rs.getString("Nome");
				String cpf = rs.getString("Cpf");
				String telefone = rs.getString("Telefone");
				String Endereco = rs.getString("Endereço");

				// FormClientes.txtId.setText(id);
				FormClientes.txtNome.setText(nome);
				FormClientes.txtCPF.setText(cpf);
				FormClientes.txtTelefone.setText(telefone);
				FormClientes.txtEndereco.setText(Endereco);
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
	public static void deletarCliente() {
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
				String query = "DELETE from CLIENTE WHERE CPF=" + FormClientes.txtCPF.getText() + ";";
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
