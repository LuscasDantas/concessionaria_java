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
				Class.forName("");
				con = DriverManager.getConnection("");
				con.setAutoCommit(false);
				String query = "INSERT INTO VEICULO (ID, MODELO, CHASSI, COR, PLACA, ANO, VALOR)"
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
	public static void pesquisarVeiculo(Veiculo veiculo) {
		Connection con = null;
		Statement stmt = null;
		try {
			Class.forName("");
			con = DriverManager.getConnection("");
			con.setAutoCommit(false);
			System.out.println("Banco de dados aberto com sucesso");
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM VEICULO WHERE PLACA ="
					+ FormVeiculos.txtPlaca.getText() + ";");
			while (rs.next()) {
				String modelo = rs.getString("modelo");
				String chassi = rs.getString("chassi");
				String cor = rs.getString("cor");
				String placa = rs.getString("placa");
				String ano = rs.getString("ano");
				double valor = rs.getDouble("valor");
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
		int response = JOptionPane.showConfirmDialog(null, "Deseja realmente deletar o registro?",
				"Confirmar", JOptionPane.YES_NO_OPTION);
		
		if(response == JOptionPane.NO_OPTION) {
			JOptionPane.getDefaultLocale();
		}else if(response == JOptionPane.YES_OPTION) {
			Connection con = null;
			Statement stmt = null;
			try {
				Class.forName("");
				con = DriverManager.getConnection("");
				con.setAutoCommit(false);
				stmt = con.createStatement();
				String query = "DELETE from PESSOA WHERE ID=" + FormVeiculos.txtIdVeiculo.getText()	+ ";";
				stmt.executeUpdate(query);
				con.commit();
				stmt.close();
				con.close();
				
			} catch (Exception e) {
				JOptionPane.showMessageDialog(new JFrame(), "Registro inexistente", 
						"Atenção", JOptionPane.ERROR_MESSAGE);
			}
			System.out.println("Registro Deletado com sucesso!");
		}
		
	}
}