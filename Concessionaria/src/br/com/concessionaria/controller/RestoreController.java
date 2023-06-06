package br.com.concessionaria.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.sql.DriverManager;
import java.sql.SQLException;

public class RestoreController {
	public static void main(String[] args) {
		// captura o nome de usuário do sistema
		String username = System.getProperty("user.name");

		String databasePath = "src/br/com/concessionaria/dao/concessionaria.db";
		String backupFolderPath = "C:/Users/" + username + "/Documents/BackupConcessionaria/";

		// Fechar possiveis conexões existentes com o banco de dados
		try {
			DriverManager.getConnection("jdbc:sqlite:src/br/com/concessionaria/dao/concessionaria.db").close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		try {

			String databaseName = "concessionaria.db";
			String backupFilePath = backupFolderPath + databaseName;

			Files.copy(new File(backupFilePath).toPath(), new File(databasePath).toPath(),
					StandardCopyOption.REPLACE_EXISTING);

			System.out.println("Restauração do banco de dados realizada com sucesso!");

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
