package br.com.concessionaria.view;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Component;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import br.com.concessionaria.model.Cliente;
import br.com.concessionaria.utils.Services;
import br.com.concessionaria.dao.DAOClientes;

public class FormClientes extends JPanel {

	private static final long serialVersionUID = 1L;
	public static JTextField txtIdCliente;
	public static JTextField txtNome;
	public static JTextField txtTelefone;
	public static JTextField txtEndereco;
	public static JTextField txtCPF;
	public static JButton btnCadastrar;
	public static JButton btnPesquisar;
	public static JButton btnEditar;

	/**
	 * Create the frame.
	 */
	public FormClientes() {
		setLayout(null);
		setBounds(10, 11, 1004, 485);

		JLabel lblCliente = new JLabel("CLIENTES");
		lblCliente.setHorizontalAlignment(SwingConstants.CENTER);
		lblCliente.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblCliente.setFont(new Font("Arial", Font.BOLD, 18));
		lblCliente.setBounds(459, 32, 100, 25);
		this.add(lblCliente);
		
		JLabel lblIdCliente = new JLabel("ID:");
		lblIdCliente.setBounds(33, 39, 15, 14);
		this.add(lblIdCliente);

		txtIdCliente = new JTextField();
		txtIdCliente.setEditable(true);
		txtIdCliente.setBounds(68, 38, 43, 19);
		this.add(txtIdCliente);
		txtIdCliente.setColumns(10);

		JLabel lblNome = new JLabel("Nome");
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNome.setBounds(13, 124, 45, 13);
		this.add(lblNome);

		txtNome = new JTextField();
		txtNome.setBounds(77, 123, 268, 19);
		this.add(txtNome);
		txtNome.setColumns(10);

		JLabel lblCpf = new JLabel("CPF");
		lblCpf.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCpf.setBounds(13, 150, 45, 19);
		this.add(lblCpf);

		JLabel lblEndereco = new JLabel("Endereço");
		lblEndereco.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblEndereco.setBounds(10, 187, 69, 23);
		this.add(lblEndereco);

		JLabel lblTelefone = new JLabel("Telefone");
		lblTelefone.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTelefone.setBounds(13, 220, 69, 28);
		this.add(lblTelefone);

		txtTelefone = new JTextField();
		txtTelefone.setColumns(10);
		txtTelefone.setBounds(77, 227, 141, 19);
		this.add(txtTelefone);

		txtEndereco = new JTextField();
		txtEndereco.setColumns(10);
		txtEndereco.setBounds(77, 191, 268, 19);
		this.add(txtEndereco);

		txtCPF = new JTextField();
		txtCPF.setColumns(10);
		txtCPF.setBounds(76, 152, 141, 19);
		this.add(txtCPF);

		/*
		 * Botões
		 */
		btnCadastrar = new JButton("CADASTRAR");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Cliente.cadastrarCliente();
			}
		});
		btnCadastrar.setBounds(111, 351, 110, 23);
		this.add(btnCadastrar);

		btnPesquisar = new JButton("PESQUISAR");
		btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DAOClientes.pesquisarCliente();
			
			}
		});
		btnPesquisar.setBounds(351, 351, 110, 23);
		this.add(btnPesquisar);

		btnEditar = new JButton("EDITAR");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Cliente.editarColaborador();
			}
		});
		btnEditar.setBounds(231, 351, 110, 23);
		this.add(btnEditar);

		JButton btnLimpar = new JButton("LIMPAR");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Services.limparCampos(FormClientes.class);
				btnCadastrar.setEnabled(true);
			}
		});
		btnLimpar.setBounds(110, 385, 110, 23);
		this.add(btnLimpar);

		JButton btnDeletar = new JButton("DELETAR");
		btnDeletar.setBackground(new Color(255, 0, 0));
		btnDeletar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DAOClientes.deletarCliente();
			}
		});
		btnDeletar.setBounds(231, 385, 110, 23);
		this.add(btnDeletar);
	}
}
