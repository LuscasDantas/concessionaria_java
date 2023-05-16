package br.com.concessionaria.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import br.com.concessionaria.model.Veiculo;
import br.com.concessionaria.view.FormVeiculos;

public class DAOVeiculos {
	/*
	 * Cadastrar
	 */
	public static void cadastrarVeiculo(Veiculo veiculo) throws SQLException {
		int response = JOptionPane.showConfirmDialog(null, "Deseja realmente cadastrar o veículo?", "Confirmar",
				JOptionPane.YES_NO_OPTION);
		if (response == JOptionPane.NO_OPTION) {
			JOptionPane.getDefaultLocale();
		} else if (response == JOptionPane.YES_OPTION) {

			Connection con = null;
			try {
				Class.forName("org.sqlite.JDBC");
				con = DriverManager.getConnection("jdbc:sqlite:src/br/com/concessionaria/dao/concessionaria.db");
				con.setAutoCommit(false);
				String query = "INSERT INTO VEICULOS (ID, MODELO, CHASSI, COR, PLACA, ANO, VALOR)"
						+ "VALUES (NULL, ?,?,?,?,?,?)";
				PreparedStatement stmt = con.prepareStatement(query);
				stmt.setString(1, Veiculo.getModelo());
				stmt.setString(2, Veiculo.getChassi());
				stmt.setString(3, Veiculo.getCor());
				stmt.setString(4, Veiculo.getPlaca());
				stmt.setString(5, Veiculo.getAno());
				stmt.setDouble(6, Veiculo.getValor());
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
	public static void pesquisarVeiculo() {
		Connection con = null;
		Statement stmt = null;
		try {
			Class.forName("org.sqlite.JDBC");
			con = DriverManager.getConnection("jdbc:sqlite:src/br/com/concessionaria/dao/concessionaria.db");
			con.setAutoCommit(false);
			System.out.println("Banco de dados aberto com sucesso");
			stmt = con.createStatement();
			ResultSet rs = stmt
					.executeQuery("SELECT * FROM VEICULOS WHERE PLACA =" + FormVeiculos.txtPlaca.getText() + ";");
			while (rs.next()) {
				int id = rs.getInt("idVeiculo");
				String modelo = rs.getString("modelo");
				String chassi = rs.getString("chassi");
				String cor = rs.getString("cor");
				String placa = rs.getString("placa");
				String ano = rs.getString("ano");
				double valor = rs.getDouble("valor");
				
				//FormVeiculos.txtIdVeiculo.setText(idVeiculo);
				FormVeiculos.txtModelo.setText(modelo);
				FormVeiculos.txtChassi.setText(chassi);
				FormVeiculos.txtCor.setText(cor);
				//FormVeiculos.txtAno.setText(placa);
				FormVeiculos.txtPlaca.setText(ano);
				FormVeiculos.txtValor.setText(Double.toString(valor));
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
	public static void deletarVeiculo() {
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
				String query = "DELETE from VEICULOS WHERE ID=" + FormVeiculos.txtIdVeiculo.getText() + ";";
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
