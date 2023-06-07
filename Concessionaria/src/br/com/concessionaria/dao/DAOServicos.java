package br.com.concessionaria.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import br.com.concessionaria.model.Servico;
import br.com.concessionaria.utils.Services;
import br.com.concessionaria.view.FormServicos;

public class DAOServicos {

	/*
	 * Cadastrar
	 */
	public static void cadastrarServico(Servico servico) throws SQLException {
		Connection con = null;
		try {
			Class.forName("org.sqlite.JDBC");
			con = DriverManager.getConnection("jdbc:sqlite:src/br/com/concessionaria/dao/concessionaria.db");
			con.setAutoCommit(false);
			String query = "INSERT INTO servicos (id, nome, descricao, valor)" + "VALUES (NULL, ?,?,?)";
			PreparedStatement stmt = con.prepareStatement(query);
			stmt.setString(1, Servico.getNome());
			stmt.setString(2, Servico.getDescricao());
			stmt.setDouble(3, Servico.getValor());
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
	public static void pesquisarServico() {
		Connection con = null;
		Statement stmt = null;
		try {
			Class.forName("org.sqlite.JDBC");
			con = DriverManager.getConnection("jdbc:sqlite:src/br/com/concessionaria/dao/concessionaria.db");
			con.setAutoCommit(false);
			System.out.println("Banco de dados aberto com sucesso");
			stmt = con.createStatement();
			ResultSet rs = stmt
					.executeQuery("SELECT * FROM servicos WHERE nome LIKE '%" + FormServicos.txtNome.getText() + "%';");

			boolean servico = rs.next();

			if (!servico) {
				Services.limparCampos(FormServicos.class);

				throw new Exception();
			} else {
				FormServicos.btnCadastrar.setEnabled(false);
			}

			while (servico) {
				Integer idServico = rs.getInt("id");
				String nome = rs.getString("nome");
				String descricao = rs.getString("descricao");
				double valor = rs.getDouble("valor");

				FormServicos.txtIdServico.setText(Integer.toString(idServico));
				FormServicos.txtNome.setText(nome);
				FormServicos.textDescricao.setText(descricao);
				FormServicos.txtValor.setText(Double.toString(valor));

				servico = false;
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
	public static void editarServico(Servico servico) throws SQLException {
		int response = JOptionPane.showConfirmDialog(null, "Deseja realmente editar o serviço?", "Confirmar",
				JOptionPane.YES_NO_OPTION);
		if (response == JOptionPane.NO_OPTION) {
			JOptionPane.getDefaultLocale();
		} else if (response == JOptionPane.YES_OPTION) {

			Connection con = null;
			try {
				Class.forName("org.sqlite.JDBC");
				con = DriverManager.getConnection("jdbc:sqlite:src/br/com/concessionaria/dao/concessionaria.db");
				con.setAutoCommit(false);
				String query = "UPDATE servicos SET nome = ?, descricao = ?, valor = ?" + " WHERE id = "
						+ FormServicos.txtIdServico.getText() + ";";

				PreparedStatement stmt = con.prepareStatement(query);
				stmt.setString(1, Servico.getNome());
				stmt.setString(2, Servico.getDescricao());
				stmt.setDouble(3, Servico.getValor());
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
	public static void deletarServico() {
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
				String query = "DELETE from servicos WHERE id = " + FormServicos.txtIdServico.getText() + ";";
				stmt.executeUpdate(query);
				con.commit();
				stmt.close();
				con.close();

				Services.limparCampos(FormServicos.class);
				JOptionPane.showMessageDialog(null, "Deletado com sucesso!");

			} catch (Exception e) {
				JOptionPane.showMessageDialog(new JFrame(), "Registro inexistente", "Atenção",
						JOptionPane.ERROR_MESSAGE);
			}
		}
	}
}
