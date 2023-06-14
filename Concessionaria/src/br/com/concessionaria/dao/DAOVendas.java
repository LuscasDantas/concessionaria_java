package br.com.concessionaria.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import br.com.concessionaria.model.Cliente;
import br.com.concessionaria.model.Colaborador;
import br.com.concessionaria.model.Veiculo;
import br.com.concessionaria.model.Venda;
import br.com.concessionaria.view.FormColaboradores;
import br.com.concessionaria.view.FormVendas;

public class DAOVendas {
	
	/*
	 * Cadastrar
	 */
	public void cadastrarVenda(Venda venda) throws SQLException {
		Connection con = null;
		try {
			Class.forName("org.sqlite.JDBC");
			con = DriverManager.getConnection("jdbc:sqlite:src/br/com/concessionaria/dao/concessionaria.db");
			con.setAutoCommit(false);
			String insertVendaQuery = "INSERT INTO vendas (id, cliente, colaborador, veiculo, valor_total) "
					+ "VALUES (NULL, ?, ?, ?, ?)";
			
			PreparedStatement insertVendaStmt = con.prepareStatement(insertVendaQuery);
			insertVendaStmt.setInt(3, Venda.getClienteSelecionado().getIdCliente());
			insertVendaStmt.setInt(1, Venda.getColaboradorSelecionado().getIdColaborador());
			insertVendaStmt.setInt(2, Venda.getVeiculoSelecionado().getIdVeiculo());
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
}
