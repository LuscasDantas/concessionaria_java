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

import br.com.concessionaria.dao.DAOVeiculos;
import br.com.concessionaria.model.Veiculo;
import br.com.concessionaria.utils.Services;

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
	public static JButton btnCadastrar;
	public static JButton btnPesquisar;
	public static JButton btnEditar;
	
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
		btnCadastrar = new JButton("CADASTRAR");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Veiculo.cadastrarVeiculo();
			}
		});
		btnCadastrar.setBounds(111, 351, 110, 23);
		this.add(btnCadastrar);
		
		btnPesquisar = new JButton("PESQUISAR");
		btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DAOVeiculos.pesquisarVeiculo();
			}
		});
		btnPesquisar.setBounds(351, 351, 110, 23);
		this.add(btnPesquisar);
		
		btnEditar = new JButton("EDITAR");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Veiculo.editarVeiculo();
			}
		});
		btnEditar.setBounds(231, 351, 110, 23);
		this.add(btnEditar);
		
		JButton btnLimpar = new JButton("LIMPAR");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Services.limparCampos(FormVeiculos.class);
				btnCadastrar.setEnabled(true);
			}
		});
		btnLimpar.setBounds(110, 385, 110, 23);
		this.add(btnLimpar);
		
		JButton btnDeletar = new JButton("DELETAR");
		btnDeletar.setBackground(new Color(255, 0, 0));
		btnDeletar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DAOVeiculos.deletarVeiculo();
			}
		});
		btnDeletar.setBounds(231, 385, 110, 23);
		this.add(btnDeletar);
	}

}
