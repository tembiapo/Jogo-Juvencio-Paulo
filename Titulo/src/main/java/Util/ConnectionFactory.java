package Util;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author aluno
 */
public class ConnectionFactory {
            // Tenta estabelecer a conexão
            public static Connection getConnection() throws SQLException {
                return DriverManager.getConnection(Constantes.url,Constantes.usuario,Constantes.senha);
            } 
        
}
