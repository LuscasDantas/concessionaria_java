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
import br.com.concessionaria.view.FormServicos;

public class DAOServicos {

	/*
	 * Cadastrar
	 */
	public static void cadastrarServico(Servico servico) throws SQLException {
		int response = JOptionPane.showConfirmDialog(null, "Deseja realmente cadastrar o serviço?", "Confirmar",
				JOptionPane.YES_NO_OPTION);
		if (response == JOptionPane.NO_OPTION) {
			JOptionPane.getDefaultLocale();
		} else if (response == JOptionPane.YES_OPTION) {

			Connection con = null;
			try {
				Class.forName("org.sqlite.JDBC");
				con = DriverManager.getConnection("jdbc:sqlite:src/br/com/concessionaria/dao/concessionaria.db");
				con.setAutoCommit(false);
				String query = "INSERT INTO SERVICOS (ID, NOME, DESCRICAO, VALOR)" + "VALUES (NULL, ?,?,?)";
				PreparedStatement stmt = con.prepareStatement(query);
				stmt.setString(1, Servico.getNome());
				stmt.setString(2, Servico.getDescricao());
				stmt.setDouble(3, Servico.getValor());
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
					.executeQuery("SELECT * FROM SERVICOS WHERE ID = " + FormServicos.txtIdServico.getText() + ";");
			
			boolean service = rs.next();
			
			if (!service) {
				FormServicos.txtIdServico.setText("");
				FormServicos.txtNome.setText("");
				FormServicos.textDescricao.setText("");
				FormServicos.txtValor.setText("");
				
				throw new Exception();
			}
			
			while (service) {
				// Integer idServico = rs.getInt("idServico");
				String nome = rs.getString("nome");
				String descricao = rs.getString("descricao");
				double valor = rs.getDouble("valor");

				// FormServicos.txtIdServico.setText(idServico.toString());
				FormServicos.txtNome.setText(nome);
				FormServicos.textDescricao.setText(descricao);
				FormServicos.txtValor.setText(Double.toString(valor));
				
				service = false;
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
				String query = "DELETE from SERVICOS WHERE ID = " + FormServicos.txtIdServico.getText() + ";";
				stmt.executeUpdate(query);
				con.commit();
				stmt.close();
				con.close();
				System.out.println("Registro Deletado com sucesso!");

			} catch (Exception e) {
				JOptionPane.showMessageDialog(new JFrame(), "Registro inexistente", "Atenção",
						JOptionPane.ERROR_MESSAGE);
			}
		}

	}

}
