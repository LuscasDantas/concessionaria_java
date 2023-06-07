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
import br.com.concessionaria.utils.Services;
import br.com.concessionaria.view.FormClientes;

public class DAOClientes {

	/*
	 * Cadastrar
	 */
	public static void cadastrarCliente(Cliente cliente) throws SQLException {
		Connection con = null;
		try {
			Class.forName("org.sqlite.JDBC");
			con = DriverManager.getConnection("jdbc:sqlite:src/br/com/concessionaria/dao/concessionaria.db");
			con.setAutoCommit(false);
			String query = "INSERT INTO clientes (id, nome, cpf, telefone, endereco)" + "VALUES (NULL, ?,?,?,?)";
			PreparedStatement stmt = con.prepareStatement(query);
			stmt.setString(1, Cliente.getNome());
			stmt.setString(2, Cliente.getCpf());
			stmt.setString(3, Cliente.getTelefone());
			stmt.setString(4, Cliente.getEndereco());
			stmt.execute();
			stmt.close();
			con.commit();
			con.close();

			JOptionPane.showMessageDialog(null, "Cadastrado com sucesso!");

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			e.printStackTrace();
			con.close();
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
					.executeQuery("SELECT * FROM clientes WHERE cpf LIKE '%" + FormClientes.txtCPF.getText() + "%';");

			boolean cliente = rs.next();

			if (!cliente) {
				Services.limparCampos(FormClientes.class);

				throw new Exception();
			} else {
				FormClientes.btnCadastrar.setEnabled(false);
			}

			while (cliente) {
				int idCliente = rs.getInt("id");
				String nome = rs.getString("nome");
				String cpf = rs.getString("cpf");
				String telefone = rs.getString("telefone");
				String endereco = rs.getString("endereco");

				FormClientes.txtIdCliente.setText(Integer.toString(idCliente));
				FormClientes.txtNome.setText(nome);
				FormClientes.txtCPF.setText(cpf);
				FormClientes.txtTelefone.setText(telefone);
				FormClientes.txtEndereco.setText(endereco);

				cliente = false;
			}
			rs.close();
			stmt.close();
			con.close();

		} catch (Exception e) {
			JOptionPane.showMessageDialog(new JFrame(), "Registro inexistente", "Dialog", JOptionPane.ERROR_MESSAGE);

		}
	}

	/*
	 * Editar
	 */
	public static void editarCliente(Cliente cliente) throws SQLException {
		int response = JOptionPane.showConfirmDialog(null, "Deseja realmente editar o cliente?", "Confirmar",
				JOptionPane.YES_NO_OPTION);
		if (response == JOptionPane.NO_OPTION) {
			JOptionPane.getDefaultLocale();
		} else if (response == JOptionPane.YES_OPTION) {

			Connection con = null;
			try {
				Class.forName("org.sqlite.JDBC");
				con = DriverManager.getConnection("jdbc:sqlite:src/br/com/concessionaria/dao/concessionaria.db");
				con.setAutoCommit(false);
				String query = "UPDATE clientes SET nome = ?, cpf = ?, telefone = ?, endereco = ?" + " WHERE id = "
						+ FormClientes.txtIdCliente.getText() + ";";

				PreparedStatement stmt = con.prepareStatement(query);
				stmt.setString(1, Cliente.getNome());
				stmt.setString(2, Cliente.getCpf());
				stmt.setString(4, Cliente.getTelefone());
				stmt.setString(3, Cliente.getEndereco());
				stmt.execute();
				stmt.close();
				con.commit();
				con.close();

				JOptionPane.showMessageDialog(null, "Editado com sucesso!");

			} catch (Exception e) {
				e.printStackTrace();
			}
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
				Class.forName("org.sqlite.JDBC");
				con = DriverManager.getConnection("jdbc:sqlite:src/br/com/concessionaria/dao/concessionaria.db");
				con.setAutoCommit(false);
				stmt = con.createStatement();
				String query = "DELETE from clientes WHERE id =" + FormClientes.txtIdCliente.getText() + ";";
				stmt.executeUpdate(query);
				con.commit();
				stmt.close();
				con.close();

				Services.limparCampos(FormClientes.class);
				JOptionPane.showMessageDialog(null, "Deletado com sucesso!");

			} catch (Exception e) {
				JOptionPane.showMessageDialog(new JFrame(), "Registro inexistente", "Atenção",
						JOptionPane.ERROR_MESSAGE);
			}
		}

	}

}
