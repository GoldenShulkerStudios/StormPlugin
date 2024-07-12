package me.ewahv1.plugin.Database;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class DatabaseConnection {

    private HikariDataSource dataSource;

    // Constructor para inicializar la conexión a la base de datos
    public DatabaseConnection(String url, String username, String password) {
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl(url); // Establece la URL de la base de datos
        config.setUsername(username); // Establece el nombre de usuario para la base de datos
        config.setPassword(password); // Establece la contraseña para la base de datos
        config.addDataSourceProperty("cachePrepStmts", "true"); // Habilita la caché de declaraciones preparadas
        config.addDataSourceProperty("prepStmtCacheSize", "250"); // Establece el tamaño de la caché de declaraciones
                                                                  // preparadas
        config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048"); // Establece el límite de SQL para la caché de
                                                                       // declaraciones preparadas
        dataSource = new HikariDataSource(config); // Inicializa la fuente de datos de Hikari
    }

    // Método para obtener una conexión a la base de datos
    public Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }

    // Método para cerrar la conexión a la base de datos
    public void close() {
        if (dataSource != null) {
            dataSource.close(); // Cierra la fuente de datos si está inicializada
        }
    }
}
