package br.com.concessionaria.utils;
import java.lang.reflect.Field;

import javax.swing.JTextField;


public class Services {
	
	public static void limparCampos(Class<?> classe) {
		
		Field[] campos = classe.getFields();
		
		for (Field campo : campos) {

            try {
                Object valor = campo.get(classe);
                if (valor instanceof JTextField) {
                    JTextField campoTexto = (JTextField) valor;
                    campoTexto.setText("");
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
	}
}
