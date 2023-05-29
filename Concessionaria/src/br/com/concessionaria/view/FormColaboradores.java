package br.com.concessionaria.view;

import java.awt.Font;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultComboBoxModel;
import br.com.concessionaria.model.Colaborador;
import br.com.concessionaria.utils.Services;
import br.com.concessionaria.dao.DAOColaboradores;
import javax.swing.JFormattedTextField;

public class FormColaboradores extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static JTextField txtIdColaborador;
	public static JTextField txtNome;
	public static JTextField txtCPF;
	public static JTextField txtEndereco;
	public static JTextField txtTelefone;
	public static JFormattedTextField txtSalario;
	public static JComboBox<String> cmbCargo;

	/**
	 * Create the panel.
	 */
	public FormColaboradores() {
		setLayout(null);
		setBounds(10, 11, 1004, 485);
		
		JLabel lblCadColaborador = new JLabel("COLABORADORES");
		lblCadColaborador.setHorizontalAlignment(SwingConstants.CENTER);
		lblCadColaborador.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblCadColaborador.setFont(new Font("Arial", Font.BOLD, 18));
		lblCadColaborador.setBounds(414, 32, 203, 25);
		this.add(lblCadColaborador);
		
		JLabel lblIdCliente = new JLabel("ID:");
		lblIdCliente.setBounds(55, 28, 15, 14);
		this.add(lblIdCliente);
		
		txtIdColaborador = new JTextField();
		txtIdColaborador.setEditable(true);
		txtIdColaborador.setColumns(10);
		txtIdColaborador.setBounds(90, 27, 43, 19);
		this.add(txtIdColaborador);
		
		JLabel lblTelefone = new JLabel("Telefone");
		lblTelefone.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTelefone.setBounds(32, 179, 69, 28);
		this.add(lblTelefone);

		txtTelefone = new JTextField();
		txtTelefone.setColumns(10);
		txtTelefone.setBounds(99, 185, 141, 19);
		this.add(txtTelefone);

		JLabel lblEndereco = new JLabel("Endereço");
		lblEndereco.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblEndereco.setBounds(32, 145, 69, 23);
		this.add(lblEndereco);

		txtEndereco = new JTextField();
		txtEndereco.setColumns(10);
		txtEndereco.setBounds(99, 149, 268, 19);
		this.add(txtEndereco);
		
		JLabel lblCpf = new JLabel("CPF");
		lblCpf.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCpf.setBounds(32, 115, 45, 19);
		this.add(lblCpf);

		txtCPF = new JTextField();
		txtCPF.setColumns(10);
		txtCPF.setBounds(99, 116, 141, 19);
		this.add(txtCPF);

		JLabel lblNome = new JLabel("Nome");
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNome.setBounds(32, 89, 45, 13);
		this.add(lblNome);

		txtNome = new JTextField();
		txtNome.setColumns(10);
		txtNome.setBounds(99, 88, 268, 19);
		this.add(txtNome);
		
		JLabel lblSalario = new JLabel("Salário");
		lblSalario.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSalario.setBounds(32, 218, 54, 14);
		this.add(lblSalario);
		
		txtSalario = new JFormattedTextField();
		txtSalario.setBounds(99, 218, 112, 20);
		this.add(txtSalario);
		
		JLabel lblCargo = new JLabel("Cargo");
		lblCargo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCargo.setBounds(32, 258, 69, 28);
		this.add(lblCargo);
			
//		cmbCargo = new JComboBox();
//		cmbCargo.setBounds(128, 263, 187, 22);
//		cmbCargo.addItem("Atendente");
//		cmbCargo.addItem("Gerente");
//		cmbCargo.addItem("Mecanico");
//		add(cmbCargo);
		
		cmbCargo = new JComboBox();
		cmbCargo.setModel(new DefaultComboBoxModel(new String[] { "Atendente", "Mecanico", "Gerente" }));
		cmbCargo.setBounds(99, 264, 257, 21);
		this.add(cmbCargo);

		/*
		 * Botões
		 */
		JButton btnCadastrar = new JButton("CADASTRAR");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Colaborador.cadastrarColaborador();
			}
		});
		btnCadastrar.setBounds(111, 351, 110, 23);
		this.add(btnCadastrar);

		JButton btnPesquisar = new JButton("PESQUISAR");
		btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DAOColaboradores.pesquisarColaborador();
			}
		});
		btnPesquisar.setBounds(351, 351, 110, 23);
		this.add(btnPesquisar);

		JButton btnEditar = new JButton("EDITAR");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Colaborador.editarColaborador();
			}
		});
		btnEditar.setBounds(231, 351, 110, 23);
		this.add(btnEditar);

		JButton btnCancelar = new JButton("LIMPAR");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Services.limparCampos(FormColaboradores.class);
			}
		});
		btnCancelar.setBounds(110, 385, 110, 23);
		this.add(btnCancelar);

		JButton btnDeletar = new JButton("DELETAR");
		btnDeletar.setBackground(new Color(255, 0, 0));
		btnDeletar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DAOColaboradores.deletarColaborador();
			}
		});
		btnDeletar.setBounds(351, 385, 110, 23);
		this.add(btnDeletar);

		JButton btnVoltar = new JButton("VOLTAR");
		btnVoltar.setBounds(231, 385, 110, 23);
		this.add(btnVoltar);

	}
}
