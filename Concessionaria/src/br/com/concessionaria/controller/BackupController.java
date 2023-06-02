package br.com.concessionaria.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BackupController {
    public static void main(String[] args) {
    	
    	//captura o nome de usuario do sistema
    	String username = System.getProperty("user.name");
        
        String databasePath = "src/br/com/concessionaria/dao/concessionaria.db";
        String backupFolderPath = "C:/Users/" + username + "/Documents/BackupConcessionaria/";

        try {
            // Estabelecer conexão com o banco de dados
            Connection connection = DriverManager.getConnection("jdbc:sqlite:" + databasePath);

            // Obter os nomes das tabelas do banco de dados
            List<String> tableNames = getTableNames(connection);
            
            // Criar uma pasta de backup, se não existir
            File backupFolder = new File(backupFolderPath);
            if (!backupFolder.exists()) {
                backupFolder.mkdirs();
            }
            
            // Realizar o backup de cada tabela
            for (String tableName : tableNames) {
                String backupFilePath = backupFolderPath + tableName + ".db";

                // Criar uma cópia do arquivo da tabela
                Files.copy(new File(databasePath).toPath(), new File(backupFilePath).toPath(),
                        StandardCopyOption.REPLACE_EXISTING);
            }

            connection.close();

            System.out.println("Backup do banco de dados realizado com sucesso!");

        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
    }

    private static List<String> getTableNames(Connection connection) throws SQLException {
        List<String> tableNames = new ArrayList<>();
        DatabaseMetaData metaData = connection.getMetaData();
        ResultSet resultSet = metaData.getTables(null, null, null, new String[]{"TABLE"});
        while (resultSet.next()) {
            tableNames.add(resultSet.getString("TABLE_NAME"));
        }
        resultSet.close();
        return tableNames;
    }
}
