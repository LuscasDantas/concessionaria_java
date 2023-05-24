package br.com.concessionaria.view;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import br.com.concessionaria.dao.DAOClientes;
import br.com.concessionaria.dao.DAOVeiculos;
import br.com.concessionaria.model.Veiculo;
import br.com.concessionaria.model.Cliente;
import br.com.concessionaria.model.Colaborador;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FormClientes extends JPanel {

	private static final long serialVersionUID = 1L;
	public static JTextField txtId;
	public static JTextField txtNome;
	public static JTextField txtTelefone;
	public static JTextField txtEndereco;
	public static JTextField txtCPF;

	/**
	 * Create the frame.
	 */
	public FormClientes() {
		setLayout(null);
		setBounds(10, 11, 1004, 485);

		JLabel lblCliente = new JLabel("Cliente");
		lblCliente.setHorizontalAlignment(SwingConstants.CENTER);
		lblCliente.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblCliente.setFont(new Font("Arial", Font.BOLD, 18));
		lblCliente.setBounds(459, 32, 100, 25);
		this.add(lblCliente);

		txtId = new JTextField();
		txtId.setEditable(false);
		txtId.setBounds(68, 38, 43, 19);
		this.add(txtId);
		txtId.setColumns(10);

		JLabel lblIdCliente = new JLabel("ID:");
		lblIdCliente.setBounds(33, 39, 15, 14);
		this.add(lblIdCliente);

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
		JButton btnCadastrar = new JButton("CADASTRAR");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Cliente.cadastrarCliente();
			}
		});
		btnCadastrar.setBounds(111, 351, 110, 23);
		this.add(btnCadastrar);

		JButton btnPesquisar = new JButton("PESQUISAR");
		btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DAOClientes.pesquisarCliente();
			
			}
		});
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
				txtCPF.setText("");
				txtNome.setText("");
				txtEndereco.setText("");
				txtTelefone.setText("");
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
