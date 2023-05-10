package br.com.concessionaria.view;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;

public class Servicos extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtIdServico;
	private JTextField txtNome;
	private JPanel geralPanel;

	/**
	 * Create the panel.
	 */
	public Servicos(JPanel panel) {
        this.geralPanel = panel;
        
		setLayout(null);
		setBounds(10, 11, 1004, 485);
		
		
		JLabel lblCadServico = new JLabel("SERVIÇOS");
		lblCadServico.setHorizontalAlignment(SwingConstants.CENTER);
		lblCadServico.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblCadServico.setFont(new Font("Arial", Font.BOLD, 18));
		lblCadServico.setBounds(459, 32, 100, 25);
		this.add(lblCadServico);
		
		JLabel lblIdServico = new JLabel("ID:");
		lblIdServico.setBounds(49, 89, 35, 14);
		add(lblIdServico);
		
		txtIdServico = new JTextField();
		txtIdServico.setBounds(71, 86, 48, 20);
		txtIdServico.setEditable(false);
		add(txtIdServico);
		txtIdServico.setColumns(10);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(49, 159, 46, 14);
		add(lblNome);
		
		txtNome = new JTextField();
		txtNome.setBounds(93, 156, 160, 20);
		add(txtNome);
		txtNome.setColumns(10);
		
		JLabel lblDescricao = new JLabel("Descrição:");
		lblDescricao.setBounds(49, 207, 61, 14);
		add(lblDescricao);
		
		JTextArea textDescricao = new JTextArea();
		textDescricao.setRows(10);
		textDescricao.setBounds(120, 202, 300, 50);
		add(textDescricao);
		
		JLabel lblValor = new JLabel("Valor:");
		lblValor.setBounds(279, 159, 48, 14);
		add(lblValor);
		
		JFormattedTextField txtValor = new JFormattedTextField();
		txtValor.setBounds(332, 156, 88, 20);
		add(txtValor);
		
		JButton btnCadastrar = new JButton("CADASTRAR");
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
				txtIdServico.setText("");
				txtNome.setText("");
				textDescricao.setText("");
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
		btnVoltar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				CardLayout cardLayout = (CardLayout) geralPanel.getLayout();
		        cardLayout.previous(geralPanel);
			}
		});
		btnVoltar.setBounds(231, 385, 110, 23);
		this.add(btnVoltar);

	}
}
