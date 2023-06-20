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
import br.com.concessionaria.model.OrdemServico;
import br.com.concessionaria.model.Servico;
import br.com.concessionaria.model.Veiculo;
import br.com.concessionaria.utils.Services;
import br.com.concessionaria.view.FormOS;

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
	
	/*
	 * Pesquisar
	 */
	public static void pesquisarOS() {
		Connection con = null;
		Statement stmt = null;

		try {
			Class.forName("org.sqlite.JDBC");
			con = DriverManager.getConnection("jdbc:sqlite:src/br/com/concessionaria/dao/concessionaria.db");
			con.setAutoCommit(false);
			stmt = con.createStatement();
			ResultSet rs = stmt
					.executeQuery("SELECT * FROM ordens_servicos WHERE id =" + FormOS.txtIdOS.getText() + ";");

			boolean os = rs.next();

			if (!os) {
				Services.limparCampos(FormOS.class);
				
				throw new Exception();
			} else {				
				FormOS.btnCadastrar.setEnabled(false);
			}

			while (os) {
				Integer idOS = rs.getInt("id");
				String cliente = rs.getString("cliente");
				String colaborador = rs.getString("colaborador");
				String veiculo = rs.getString("veiculo");
				String servico = rs.getString("servico");
				double valorTotal = rs.getDouble("valor_total");

				FormOS.txtIdOS.setText(Integer.toString(idOS));
				FormOS.pesquisaCliente.setText(Cliente.getIdCliente() + " - " + Cliente.getNome());
				FormOS.pesquisaColaborador.setText(Colaborador.getIdColaborador() + " - " + Colaborador.getNome());
				FormOS.pesquisaVeiculo.setText(Veiculo.getIdVeiculo() + " - " + Veiculo.getModelo());
				FormOS.pesquisaServico.setText(Servico.getIdServico() + " - " + Servico.getNome());
				FormOS.pesquisaValor.setText(Double.toString(valorTotal));

				os = false;
			}
			rs.close();
			stmt.close();
			con.close();

		} catch (Exception e) {
			JOptionPane.showMessageDialog(new JFrame(), "Registro inexistente", "Dialog", JOptionPane.ERROR_MESSAGE);

		}
	}
	
	/*
	 * Deletar OS
	 */
	public static void deletarOS() {
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
				String query = "DELETE from ordens_servicos WHERE id =" + FormOS.txtIdOS.getText() + ";";
				stmt.executeUpdate(query);
				con.commit();
				stmt.close();
				con.close();

				Services.limparCampos(FormOS.class);
				JOptionPane.showMessageDialog(null, "Deletado com sucesso!");

			} catch (Exception e) {
				JOptionPane.showMessageDialog(new JFrame(), "Registro inexistente", "Atenção",
						JOptionPane.ERROR_MESSAGE);
			}
		}

	}

}
