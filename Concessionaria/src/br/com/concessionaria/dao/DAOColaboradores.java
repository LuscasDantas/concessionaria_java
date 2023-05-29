package br.com.concessionaria.dao;

import javax.swing.JFrame;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;
import javax.swing.JOptionPane;
import java.sql.PreparedStatement;
import br.com.concessionaria.utils.Services;
import br.com.concessionaria.model.Colaborador;
import br.com.concessionaria.view.FormColaboradores;

public class DAOColaboradores {

	/*
	 * Cadastrar
	 */
	public static void cadastrarColaborador(Colaborador colaborador) throws SQLException {
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
				String query = "INSERT INTO colaboradores (id, nome, cpf, telefone, endereco, salario, cargo)"
						+ "VALUES (NULL, ?,?,?,?,?,?)";
				PreparedStatement stmt = con.prepareStatement(query);
				stmt.setString(1, Colaborador.getNome());
				stmt.setString(2, Colaborador.getCpf());
				stmt.setString(3, Colaborador.getTelefone());
				stmt.setString(4, Colaborador.getEndereco());
				stmt.setDouble(5, Colaborador.getSalario());
				stmt.setString(6, Colaborador.getCargo().toString());
				stmt.execute();
				stmt.close();
				con.commit();
				con.close();
				System.out.println("Cadastrado com sucesso!");
				
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
			ResultSet rs = stmt.executeQuery(
					"SELECT * FROM colaboradores WHERE id =" + FormColaboradores.txtIdColaborador.getText() + ";");

			boolean colaborador = rs.next();

			if (!colaborador) {
				Services.limparCampos(FormColaboradores.class);

				throw new Exception();
			}
			
			while (colaborador) {
				// Integer idColaborador = rs.getInt("idColaborador");
				String nome = rs.getString("nome");
				String cpf = rs.getString("cpf");
				String telefone = rs.getString("telefone");
				String endereco = rs.getString("endereco");
				double salario = rs.getDouble("salario");
				String cargo = rs.getString("cargo");

				// FormColaboradores.txtId.setText(id);
				FormColaboradores.txtNome.setText(nome);
				FormColaboradores.txtCPF.setText(cpf);
				FormColaboradores.txtTelefone.setText(telefone);
				FormColaboradores.txtEndereco.setText(endereco);
				FormColaboradores.txtSalario.setText(Double.toString(salario));
				FormColaboradores.cmbCargo.setSelectedItem(cargo);
				
				colaborador = false;
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
	public static void editarColaborador(Colaborador colaborador) throws SQLException {
		int response = JOptionPane.showConfirmDialog(null, "Deseja realmente editar o colaborador?", "Confirmar",
				JOptionPane.YES_NO_OPTION);
		if (response == JOptionPane.NO_OPTION) {
			JOptionPane.getDefaultLocale();
		} else if (response == JOptionPane.YES_OPTION) {

			Connection con = null;
			try {
				Class.forName("org.sqlite.JDBC");
				con = DriverManager.getConnection("jdbc:sqlite:src/br/com/concessionaria/dao/concessionaria.db");
				con.setAutoCommit(false);
				String query = "UPDATE colaboradores SET nome = ?, cpf = ?, endereco = ?, telefone = ?, salario = ?, cargo = ?"
						+ " WHERE id = " + FormColaboradores.txtIdColaborador.getText() + ";";

				PreparedStatement stmt = con.prepareStatement(query);
				stmt.setString(1, Colaborador.getNome());
				stmt.setString(2, Colaborador.getCpf());
				stmt.setString(3, Colaborador.getEndereco());
				stmt.setString(4, Colaborador.getTelefone());
				stmt.setDouble(5, Colaborador.getSalario());
				stmt.setString(6, Colaborador.getCargo().toString());
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
	public static void deletarColaborador() {
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
				String query = "DELETE from colaboradores WHERE id=" + FormColaboradores.txtIdColaborador.getText() + ";";
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
