package Util;
import static Util.Constantes.senha;
import static Util.Constantes.url;
import static Util.Constantes.usuario;
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
                 Connection connection = DriverManager.getConnection(url, usuario, senha);
                 return connection;
            } 
        
}
