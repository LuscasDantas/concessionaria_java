package br.com.concessionaria.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

public class RelatorioCliente {
	public RelatorioCliente() throws SQLException {
		String databasePath = "C:\\Users\\ADMTI\\git\\concessionaria_java\\Concessionaria\\src\\br\\com\\concessionaria\\dao\\concessionaria.db";
		Connection connection = DriverManager.getConnection("jdbc:sqlite:" + databasePath);

		try {
			JasperReport jasperReport = JasperCompileManager.compileReport(
					"C:\\Users\\ADMTI\\git\\concessionaria_java\\Concessionaria\\relatorio\\Coffee.jrxml");
			
			JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, new HashMap<>(), connection);
			
			JasperViewer jasperViewer = new JasperViewer(jasperPrint, false);
			
			jasperViewer.setVisible(true);

		} catch (JRException e) {

			e.printStackTrace();
		}

	}
}
