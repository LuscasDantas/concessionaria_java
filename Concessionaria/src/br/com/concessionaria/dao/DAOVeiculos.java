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
import br.com.concessionaria.utils.Services;

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
				String query = "INSERT INTO veiculos (id, modelo, chassi, cor, placa, ano, valor)"
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
				System.out.println("Cadastrado com sucesso!");

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
					.executeQuery("SELECT * FROM veiculos WHERE id =" + FormVeiculos.txtIdVeiculo.getText() + ";");
			
			boolean veiculo = rs.next();
			
			if (!veiculo) {
				Services.limparCampos(FormVeiculos.class);;
				
				throw new Exception();
			}else {
				FormVeiculos.btnCadastrar.setEnabled(false);
			}
			
			while (veiculo) {
				//Integer idVeiculo = rs.getInt("idVeiculo");
				String modelo = rs.getString("modelo");
				String chassi = rs.getString("chassi");
				String cor = rs.getString("cor");
				String placa = rs.getString("placa");
				String ano = rs.getString("ano");
				double valor = rs.getDouble("valor");
				
				//FormVeiculos.txtIdVeiculo.setText(idVeiculo.toString());
				FormVeiculos.txtModelo.setText(modelo);
				FormVeiculos.txtChassi.setText(chassi);
				FormVeiculos.txtCor.setText(cor);
				FormVeiculos.txtAno.setText(placa);
				FormVeiculos.txtPlaca.setText(ano);
				FormVeiculos.txtValor.setText(Double.toString(valor));
				
				//interrompe o loop se encontrar o registro
				veiculo = false;
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
	public static void editarVeiculo(Veiculo veiculo) throws SQLException {
		int response = JOptionPane.showConfirmDialog(null, "Deseja realmente editar o veiculo?", "Confirmar",
				JOptionPane.YES_NO_OPTION);
		if (response == JOptionPane.NO_OPTION) {
			JOptionPane.getDefaultLocale();
		} else if (response == JOptionPane.YES_OPTION) {

			Connection con = null;
			try {				
				Class.forName("org.sqlite.JDBC");
				con = DriverManager.getConnection("jdbc:sqlite:src/br/com/concessionaria/dao/concessionaria.db");
				con.setAutoCommit(false);
				String query = "UPDATE veiculos SET modelo = ?, chassi = ?, cor = ?, ano = ?, "
						+ "placa = ?, valor = ?" + " WHERE id = " + FormVeiculos.txtIdVeiculo.getText() + ";";
				
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
				System.out.println("Editado com sucesso!");

			} catch (Exception e) {
				e.printStackTrace();
			}
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
				Class.forName("org.sqlite.JDBC");
				con = DriverManager.getConnection("jdbc:sqlite:src/br/com/concessionaria/dao/concessionaria.db");
				con.setAutoCommit(false);
				stmt = con.createStatement();
				String query = "DELETE from veiculos WHERE id =" + FormVeiculos.txtIdVeiculo.getText() + ";";
				stmt.executeUpdate(query);
				con.commit();
				stmt.close();
				con.close();
				
				Services.limparCampos(FormVeiculos.class);

			} catch (Exception e) {
				JOptionPane.showMessageDialog(new JFrame(), "Registro inexistente", "Atenção",
						JOptionPane.ERROR_MESSAGE);
			}
			System.out.println("Registro Deletado com sucesso!");
		}

	}
}
