package br.com.concessionaria.view;

import java.awt.EventQueue;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FormCadastroPessoa extends JPanel {

	private JTextField textField;
	private JLabel lblNewLabel;
	private JTextField txtNome;
	private JTextField txtTelefone;
	private JTextField txtEndereco;
	private JTextField txtCPF;

	/**
	 * Create the frame.
	 */
	public FormCadastroPessoa() {
		setBounds(100, 100, 470, 440);
		this.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setLayout(null);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setBounds(68, 38, 43, 19);
		this.add(textField);
		textField.setColumns(10);
		
		lblNewLabel = new JLabel("ID");
		lblNewLabel.setBounds(13, 41, 26, 13);
		this.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nome");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(13, 124, 45, 13);
		this.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("CPF");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(13, 150, 45, 19);
		this.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Endereço");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(10, 187, 69, 23);
		this.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Telefone");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_4.setBounds(13, 220, 69, 28);
		this.add(lblNewLabel_4);
		
		txtNome = new JTextField();
		txtNome.setBounds(77, 123, 268, 19);
		this.add(txtNome);
		txtNome.setColumns(10);
		
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
		
		JButton btnNewButton = new JButton("Cadastrar");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton.setBounds(94, 336, 108, 28);
		this.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Limpar");
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtCPF.setText("");
				txtNome.setText("");
				txtEndereco.setText("");
				txtTelefone.setText("");
			}
		});
		btnNewButton_1.setBounds(266, 336, 85, 28);
		this.add(btnNewButton_1);
	}
}
