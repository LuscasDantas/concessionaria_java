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
import br.com.concessionaria.model.Colaborador;
import br.com.concessionaria.utils.Services;
import br.com.concessionaria.view.FormClientes;
import br.com.concessionaria.view.FormColaboradores;

public class DAOClientes {

	/*
	 * Cadastrar
	 */
	public static void cadastrarCliente(Cliente cliente) throws SQLException {
		int response = JOptionPane.showConfirmDialog(null, "Deseja realmente cadastrar o cliente", "Confirmar",
				JOptionPane.YES_NO_OPTION);
		if (response == JOptionPane.NO_OPTION) {
			JOptionPane.getDefaultLocale();
		} else if (response == JOptionPane.YES_OPTION) {

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
					.executeQuery("SELECT * FROM clientes WHERE id =" + FormClientes.txtIdCliente.getText() + ";");
			
			boolean cliente = rs.next();

			if (!cliente) {
				Services.limparCampos(FormClientes.class);

				throw new Exception();
			}
			
			while (cliente) {
				//int id = rs.getInt("idCliente");
				String nome = rs.getString("nome");
				String cpf = rs.getString("cpf");
				String telefone = rs.getString("telefone");
				String endereco = rs.getString("endereco");

				// FormClientes.txtId.setText(id);
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
				String query = "UPDATE clientes SET nome = ?, cpf = ?, telefone = ?, endereco = ?"
						+ " WHERE id = " + FormClientes.txtIdCliente.getText() + ";";

				PreparedStatement stmt = con.prepareStatement(query);
				stmt.setString(1, Cliente.getNome());
				stmt.setString(2, Cliente.getCpf());
				stmt.setString(4, Cliente.getTelefone());
				stmt.setString(3, Cliente.getEndereco());
				stmt.execute();
				stmt.close();
				con.commit();
				con.close();
				System.out.println("Editado com sucesso!");

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
				
				Services.limparCampos(FormColaboradores.class);
				System.out.println("Registro Deletado com sucesso!");

			} catch (Exception e) {
				JOptionPane.showMessageDialog(new JFrame(), "Registro inexistente", "Atenção",
						JOptionPane.ERROR_MESSAGE);
			}
		}

	}

}
