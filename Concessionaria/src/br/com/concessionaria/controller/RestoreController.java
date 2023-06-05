package br.com.concessionaria.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public class RestoreController {
	public static void main(String[] args) {
		// captura o nome de usuário do sistema
		String username = System.getProperty("user.name");

		String databasePath = "src/br/com/concessionaria/dao/concessionaria.db";
		String backupFolderPath = "C:/Users/" + username + "/Documents/BackupConcessionaria/";

		// Fechar conexões existentes com o banco de dados
		try {
			DriverManager.getConnection("jdbc:sqlite:" + databasePath).close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		try {
			// Estabelecer conexão com o banco de dados
			Connection connection = DriverManager.getConnection("jdbc:sqlite:" + databasePath);

			// Obter os nomes dos arquivos de backup no diretório
			List<String> backupFiles = getBackupFiles(backupFolderPath);

			// Restaurar cada arquivo de backup
			for (String backupFile : backupFiles) {
				String backupFilePath = backupFolderPath + backupFile;

				// Restaurar o arquivo de backup
				Files.copy(new File(backupFilePath).toPath(), new File(databasePath).toPath(),
						StandardCopyOption.REPLACE_EXISTING);
			}

			connection.close();

			System.out.println("Restauração do banco de dados realizada com sucesso!");

		} catch (SQLException | IOException e) {
			e.printStackTrace();
		}
	}

	private static List<String> getBackupFiles(String backupFolderPath) throws SQLException{
		File backupFolder = new File(backupFolderPath);
		return List.of(backupFolder.list());
	}
}
