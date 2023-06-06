package br.com.concessionaria.view;

import java.awt.Component;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;

public class FormVendas extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtIdVenda;

	/**
	 * Create the panel.
	 */
	public FormVendas() {
		setLayout(null);
		setBounds(10, 11, 1004, 485);
		
		JLabel lblCadVendas = new JLabel("VENDAS");
		lblCadVendas.setHorizontalAlignment(SwingConstants.CENTER);
		lblCadVendas.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblCadVendas.setFont(new Font("Arial", Font.BOLD, 18));
		lblCadVendas.setBounds(459, 32, 100, 25);
		this.add(lblCadVendas);
		
		JLabel lblIdVenda = new JLabel("ID:");
		lblIdVenda.setBounds(34, 81, 25, 14);
		add(lblIdVenda);
		
		txtIdVenda = new JTextField();
		txtIdVenda.setBounds(56, 78, 40, 20);
		add(txtIdVenda);
		txtIdVenda.setColumns(10);
		
	}
}
