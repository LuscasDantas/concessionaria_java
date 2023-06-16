package br.com.concessionaria.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import br.com.concessionaria.model.OrdemServico;

public class DAOOrdemServico {
	
	/*
	 * Cadastrar
	 */
	public static void cadastrarOS(OrdemServico ordemServico) throws SQLException {
		Connection con = null;
		try {
			Class.forName("org.sqlite.JDBC");
			con = DriverManager.getConnection("jdbc:sqlite:src/br/com/concessionaria/dao/concessionaria.db");
			con.setAutoCommit(false);
			String insertOsQuery = "INSERT INTO ordens_servicos (id, cliente, colaborador, servico, veiculo, valor_os) "
					+ "VALUES (NULL, ?, ?, ?, ?, ?)";
			
			PreparedStatement insertOsStmt = con.prepareStatement(insertOsQuery);
			insertOsStmt.setInt(1, OrdemServico.getClienteSelecionado().getIdCliente());
			insertOsStmt.setInt(2, OrdemServico.getColaboradorSelecionado().getIdColaborador());
			insertOsStmt.setInt(3, OrdemServico.getServicoSelecionado().getIdServico());
			insertOsStmt.setInt(4, OrdemServico.getVeiculoSelecionado().getIdVeiculo());
			insertOsStmt.setDouble(5,OrdemServico.getValorOS());
			insertOsStmt.execute();
			insertOsStmt.close();
			con.commit();
			con.close();

			JOptionPane.showMessageDialog(null, "Ordem de serviço cadastrada com sucesso!");

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			e.printStackTrace();
			con.close();
		}
	}

}
