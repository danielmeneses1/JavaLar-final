package model;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbConnector {
	
//	private String HOST = "localhost";
//	private String banco = "javalar";
//	private String usuario = "root";
//	private String senha = "root";
    private String HOST = "da_java.mysql.dbaas.com.br";
    private String banco = "da_java";
    private String usuario = "da_java";
    private String senha = "Tecnicas*2023@";

    public DbConnector(){

    }

    public Connection conectar(){
        try{
            System.out.println("Conectando ao banco...");
            Connection conexao = DriverManager.getConnection("jdbc:mysql://"+HOST+"/"+banco+"?useTimezone=true&serverTimezone=UTC",usuario,senha);
            return conexao;
        }catch (Exception e){
            System.out.println("Erro ao conectar ao banco");
            e.printStackTrace();
            return null;
        }
    }
}
