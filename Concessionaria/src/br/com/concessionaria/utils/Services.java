package br.com.concessionaria.utils;

import br.com.concessionaria.view.FormVeiculos;

public class Services {
	
	public static void limparCampos() {
		FormVeiculos.txtIdVeiculo.setText("");
		FormVeiculos.txtModelo.setText("");
		FormVeiculos.txtChassi.setText("");
		FormVeiculos.txtCor.setText("");
		FormVeiculos.txtAno.setText("");
		FormVeiculos.txtPlaca.setText("");
		FormVeiculos.txtValor.setText("");
	}
}
