package br.com.concessionaria.view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import br.com.concessionaria.model.Veiculo;

public class FormVeiculos extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public static JTextField txtIdVeiculo;
	public static JTextField txtModelo;
	public static JTextField txtChassi;
	public static JTextField txtCor;
	public static JTextField txtPlaca;
	public static JTextField txtAno;
	public static JFormattedTextField txtValor;
	static JButton btnAlterar;
	static JButton btnDeletar;
	static JButton btnCadastrar;
	
	/**
	 * Create the panel.
	 */
	public FormVeiculos() {
		setLayout(null);
		setBounds(10, 11, 1004, 485);
		
		JLabel lblCadVeiculo = new JLabel("VEÍCULOS");
		lblCadVeiculo.setHorizontalAlignment(SwingConstants.CENTER);
		lblCadVeiculo.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblCadVeiculo.setFont(new Font("Arial", Font.BOLD, 18));
		lblCadVeiculo.setBounds(459, 32, 100, 25);
		this.add(lblCadVeiculo);
		
		JLabel lblIdVeiculo = new JLabel("ID:");
		lblIdVeiculo.setBounds(39, 72, 15, 14);
		this.add(lblIdVeiculo);
		
		txtIdVeiculo = new JTextField();
		txtIdVeiculo.setBounds(64, 70, 38, 20);
		this.add(txtIdVeiculo);
		txtIdVeiculo.setColumns(10);
		
		JLabel lblModelo = new JLabel("Modelo:");
		lblModelo.setBounds(32, 139, 58, 14);
		this.add(lblModelo);
		
		txtModelo = new JTextField();
		txtModelo.setBounds(87, 136, 160, 20);
		this.add(txtModelo);
		txtModelo.setColumns(10);
		
		JLabel lblAno = new JLabel("Ano:");
		lblAno.setPreferredSize(new Dimension(38, 14));
		lblAno.setBounds(304, 205, 45, 14);
		this.add(lblAno);
		
		txtAno = new JTextField();
		txtAno.setBounds(355, 202, 86, 20);
		this.add(txtAno);
		txtAno.setColumns(10);
		
		JLabel lblCor = new JLabel("Cor:");
		lblCor.setBounds(39, 208, 38, 14);
		this.add(lblCor);
		
		txtCor = new JTextField();
		txtCor.setBounds(87, 205, 160, 20);
		this.add(txtCor);
		txtCor.setColumns(10);
		
		JLabel lblChassi = new JLabel("Chassi:");
		lblChassi.setBounds(304, 139, 51, 14);
		this.add(lblChassi);
		
		txtChassi = new JTextField();
		txtChassi.setBounds(355, 136, 160, 20);
		this.add(txtChassi);
		txtChassi.setColumns(10);
		
		JLabel lblValor = new JLabel("Valor:");
		lblValor.setBounds(39, 266, 45, 14);
		this.add(lblValor);
		
		txtValor = new JFormattedTextField();
		txtValor.setBounds(87, 263, 160, 20);
		this.add(txtValor);
		txtValor.setColumns(10);
		
		JLabel lblPlaca = new JLabel("Placa:");
		lblPlaca.setBounds(304, 266, 51, 14);
		this.add(lblPlaca);
		
		txtPlaca = new JTextField();
		txtPlaca.setBounds(355, 263, 86, 20);
		this.add(txtPlaca);
		txtPlaca.setColumns(10);
		
		/*
		 * Botões
		 */
		JButton btnCadastrar = new JButton("CADASTRAR");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Veiculo.cadastrarVeiculo();
			}
		});
		btnCadastrar.setBounds(111, 351, 110, 23);
		this.add(btnCadastrar);
		
		JButton btnPesquisar = new JButton("PESQUISAR");
		btnPesquisar.setBounds(351, 351, 110, 23);
		this.add(btnPesquisar);
		
		JButton btnEditar = new JButton("EDITAR");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnEditar.setBounds(231, 351, 110, 23);
		this.add(btnEditar);
		
		JButton btnCancelar = new JButton("CANCELAR");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtIdVeiculo.setText("");
				txtModelo.setText("");
				txtChassi.setText("");
				txtCor.setText("");
				txtAno.setText("");
				txtPlaca.setText("");
				txtValor.setText("");
			}
		});
		btnCancelar.setBounds(110, 385, 110, 23);
		this.add(btnCancelar);
		
		JButton btnDeletar = new JButton("DELETAR");
		btnDeletar.setBackground(new Color(255, 0, 0));
		btnDeletar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnDeletar.setBounds(351, 385, 110, 23);
		this.add(btnDeletar);
		
		JButton btnVoltar = new JButton("VOLTAR");
		btnVoltar.setBounds(231, 385, 110, 23);
		this.add(btnVoltar);

	}

}
