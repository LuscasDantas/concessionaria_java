package br.com.concessionaria.view;

import java.awt.Component;
import java.awt.Font;
import br.com.concessionaria.controller.*;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class FormRelatorios extends JPanel {

	/**
	 * Create the panel.
	 */
	public FormRelatorios() {
		setLayout(null);
		setBounds(10, 11, 1004, 485);
		
		JLabel lblRelatorio = new JLabel("Relatórios");
		lblRelatorio.setHorizontalAlignment(SwingConstants.CENTER);
		lblRelatorio.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblRelatorio.setFont(new Font("Arial", Font.BOLD, 18));
		lblRelatorio.setBounds(459, 32, 100, 25);
		this.add(lblRelatorio);
		
		JLabel lblRelatorioCliente = new JLabel("Relatórios de clientes");
		lblRelatorioCliente.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblRelatorioCliente.setBounds(35, 96, 154, 33);
		add(lblRelatorioCliente);
		
		JLabel lblRelatriosDeColaboradores = new JLabel("Relatórios de colaboradores");
		lblRelatriosDeColaboradores.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblRelatriosDeColaboradores.setBounds(35, 163, 203, 33);
		add(lblRelatriosDeColaboradores);
		
		JLabel lblRelatriosDeVendas = new JLabel("Relatórios de vendas");
		lblRelatriosDeVendas.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblRelatriosDeVendas.setBounds(35, 234, 176, 33);
		add(lblRelatriosDeVendas);
		
		JLabel lblRelatriosDeServios = new JLabel("Relatórios de serviços");
		lblRelatriosDeServios.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblRelatriosDeServios.setBounds(35, 308, 176, 33);
		add(lblRelatriosDeServios);
		
		JLabel lblRelatriosDeVeiculos = new JLabel("Relatórios de veiculos");
		lblRelatriosDeVeiculos.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblRelatriosDeVeiculos.setBounds(35, 382, 176, 33);
		add(lblRelatriosDeVeiculos);
		
		JButton btnRelatorioClientes = new JButton("Gerar relatório de clientes");
		btnRelatorioClientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					new RelatorioCliente();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnRelatorioClientes.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnRelatorioClientes.setBounds(45, 144, 235, 21);
		add(btnRelatorioClientes);
		
		JButton btnRelatorioVendas = new JButton("Gerar relatório de vendas");
		btnRelatorioVendas.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnRelatorioVendas.setBounds(45, 277, 235, 21);
		add(btnRelatorioVendas);
		
		JButton btnRelatorioColaboradores = new JButton("Gerar relatório de colaboradores");
		btnRelatorioColaboradores.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnRelatorioColaboradores.setBounds(45, 203, 235, 21);
		add(btnRelatorioColaboradores);
		
		JButton btnRelatorioServicos = new JButton("Gerar relatório de serviços");
		btnRelatorioServicos.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnRelatorioServicos.setBounds(45, 351, 235, 21);
		add(btnRelatorioServicos);
		
		JButton btnRelatorioVeiculos = new JButton("Gerar relatórios de veículos");
		btnRelatorioVeiculos.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnRelatorioVeiculos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnRelatorioVeiculos.setBounds(45, 424, 235, 21);
		add(btnRelatorioVeiculos);
	}
}
