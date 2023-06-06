package br.com.concessionaria.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.sql.*;

public class BackupController {
    public static void main(String[] args) {
    	
    	//captura o nome de usuario do sistema
    	String username = System.getProperty("user.name");
        
        String databasePath = "src/br/com/concessionaria/dao/concessionaria.db";
        String backupFolderPath = "C:/Users/" + username + "/Documents/BackupConcessionaria/";

        try {
            // Estabelecer conexão com o banco de dados
            Connection connection = DriverManager.getConnection("jdbc:sqlite:" + databasePath);
            
            // Criar uma pasta de backup, se não existir
            File backupFolder = new File(backupFolderPath);
            if (!backupFolder.exists()) {
                backupFolder.mkdirs();
            }
            
            String databaseName = "concessionaria.db";
            String backupFilePath = backupFolderPath + databaseName;
            
            Files.copy(new File(databasePath).toPath(), new File(backupFilePath).toPath(),
                    StandardCopyOption.REPLACE_EXISTING);

            connection.close();

            System.out.println("Backup do banco de dados realizado com sucesso!");

        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
    }
}
