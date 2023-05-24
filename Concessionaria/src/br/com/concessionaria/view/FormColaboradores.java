package br.com.concessionaria.view;

import javax.swing.JPanel;
import javax.swing.JTextField;
import br.com.concessionaria.dao.DAOColaboradores;
import br.com.concessionaria.model.Colaborador;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class FormColaboradores extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static JTextField txtTelefone;
	public static JTextField txtEndereco;
	public static JTextField txtCPF;
	public static JTextField txtNome;
	public static JTextField txtId;
	public static JComboBox<String> cmbCargo;

	/**
	 * Create the panel.
	 */
	public FormColaboradores() {
		setLayout(null);

		txtTelefone = new JTextField();
		txtTelefone.setColumns(10);
		txtTelefone.setBounds(99, 216, 141, 19);
		add(txtTelefone);

		JLabel lblTelefone = new JLabel("Telefone");
		lblTelefone.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTelefone.setBounds(35, 209, 69, 28);
		add(lblTelefone);

		JLabel lblEndereco = new JLabel("Endereço");
		lblEndereco.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblEndereco.setBounds(32, 176, 69, 23);
		add(lblEndereco);

		txtEndereco = new JTextField();
		txtEndereco.setColumns(10);
		txtEndereco.setBounds(99, 180, 268, 19);
		add(txtEndereco);

		txtCPF = new JTextField();
		txtCPF.setColumns(10);
		txtCPF.setBounds(98, 141, 141, 19);
		add(txtCPF);

		JLabel lblCpf = new JLabel("CPF");
		lblCpf.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCpf.setBounds(35, 139, 45, 19);
		add(lblCpf);

		JLabel lblNome = new JLabel("Nome");
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNome.setBounds(35, 113, 45, 13);
		add(lblNome);

		txtNome = new JTextField();
		txtNome.setColumns(10);
		txtNome.setBounds(99, 112, 268, 19);
		add(txtNome);

		txtId = new JTextField();
		txtId.setEditable(false);
		txtId.setColumns(10);
		txtId.setBounds(90, 27, 43, 19);
		add(txtId);

		JLabel lblIdCliente = new JLabel("ID:");
		lblIdCliente.setBounds(55, 28, 15, 14);
		add(lblIdCliente);

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

		JLabel lblCargo = new JLabel("Cargo");
		lblCargo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCargo.setBounds(32, 258, 69, 28);
		add(lblCargo);
			
//		cmbCargo = new JComboBox();
//		cmbCargo.setBounds(128, 263, 187, 22);
//		cmbCargo.addItem("Atendente");
//		cmbCargo.addItem("Gerente");
//		cmbCargo.addItem("Mecanico");
//		add(cmbCargo);
		
		cmbCargo = new JComboBox();
		cmbCargo.setModel(new DefaultComboBoxModel(new String[] { "Atendente", "Mecanico", "Gerente" }));
		cmbCargo.setBounds(99, 264, 257, 21);
		add(cmbCargo);
	}
}
