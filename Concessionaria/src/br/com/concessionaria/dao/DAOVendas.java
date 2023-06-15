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
import br.com.concessionaria.model.Veiculo;
import br.com.concessionaria.model.Venda;
import br.com.concessionaria.utils.Services;
import br.com.concessionaria.view.FormVendas;

public class DAOVendas {
	
	/*
	 * Cadastrar
	 */
	public static void cadastrarVenda(Venda venda) throws SQLException {
		Connection con = null;
		try {
			Class.forName("org.sqlite.JDBC");
			con = DriverManager.getConnection("jdbc:sqlite:src/br/com/concessionaria/dao/concessionaria.db");
			con.setAutoCommit(false);
			String insertVendaQuery = "INSERT INTO vendas (id, cliente, colaborador, veiculo, valor_total) "
					+ "VALUES (NULL, ?, ?, ?, ?)";
			
			PreparedStatement insertVendaStmt = con.prepareStatement(insertVendaQuery);
			insertVendaStmt.setInt(1, Venda.getClienteSelecionado().getIdCliente());
			insertVendaStmt.setInt(2, Venda.getColaboradorSelecionado().getIdColaborador());
			insertVendaStmt.setInt(3, Venda.getVeiculoSelecionado().getIdVeiculo());
			insertVendaStmt.setDouble(4,Venda.getValorTotal());
			insertVendaStmt.execute();
			insertVendaStmt.close();
			con.commit();
			con.close();

			JOptionPane.showMessageDialog(null, "Venda cadastrada com sucesso!");

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
//	public static void pesquisarVenda() {
//		Connection con = null;
//		Statement stmt = null;
//		
//		try {
//			Class.forName("org.sqlite.JDBC");
//			con = DriverManager.getConnection("jdbc:sqlite:src/br/com/concessionaria/dao/concessionaria.db");
//			con.setAutoCommit(false);
//			stmt = con.createStatement();
//			ResultSet rs = stmt.executeQuery(
//					"SELECT * FROM vendas WHERE id =" + FormVendas.txtIdVenda.getText() + ";");
//
//			boolean venda = rs.next();
//
//			if (!venda) {
//				Services.limparCampos(FormVendas.class);
//
//				throw new Exception();
//			} else {
//				FormVendas.btnCadastrar.setEnabled(false);
//			}
//			
//			while (venda) {
//				Integer idVenda = rs.getInt("id");
//				String cliente = rs.getString("cliente");
//				String colaborador = rs.getString("colaborador");
//				String veiculo = rs.getString("veiculo");
//				double valorTotal = rs.getDouble("valor_total");
//
//				FormVendas.txtIdVenda.setText(Integer.toString(idVenda));
//				FormVendas.cmbCliente.setSelectedItem(Cliente.getIdCliente() + " - " + Cliente.getNome());
//				FormVendas.cmbColaborador.setSelectedItem(Colaborador.getIdColaborador() + " - " + Colaborador.getNome());
//				FormVendas.cmbVeiculo.setSelectedItem(Veiculo.getIdVeiculo() + " - " + Veiculo.getModelo());
//				FormVendas.txtValorTotal.setText(Double.toString(valorTotal));
//
//				venda = false;
//			}
//			rs.close();
//			stmt.close();
//			con.close();
//						
//		}catch (Exception e) {
//			JOptionPane.showMessageDialog(new JFrame(), "Registro inexistente", "Dialog", JOptionPane.ERROR_MESSAGE);
//
//		}
//	}
	
	public static void deletarVenda() {
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
				String query = "DELETE from vendas WHERE id =" + FormVendas.txtIdVenda.getText() + ";";
				stmt.executeUpdate(query);
				con.commit();
				stmt.close();
				con.close();

				Services.limparCampos(FormVendas.class);
				JOptionPane.showMessageDialog(null, "Deletado com sucesso!");

			} catch (Exception e) {
				JOptionPane.showMessageDialog(new JFrame(), "Registro inexistente", "Atenção",
						JOptionPane.ERROR_MESSAGE);
			}
		}

	}
}
