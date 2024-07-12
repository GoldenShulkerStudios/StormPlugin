package me.ewahv1.plugin.Database;

public class DatabaseConfig {
    private String url; // URL de la base de datos
    private String username; // Nombre de usuario para la base de datos
    private String password; // Contraseña para la base de datos

    // Constructor para inicializar la configuración de la base de datos
    public DatabaseConfig(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    // Método para obtener la URL de la base de datos
    public String getUrl() {
        return url;
    }

    // Método para establecer la URL de la base de datos
    public void setUrl(String url) {
        this.url = url;
    }

    // Método para obtener el nombre de usuario de la base de datos
    public String getUsername() {
        return username;
    }

    // Método para establecer el nombre de usuario de la base de datos
    public void setUsername(String username) {
        this.username = username;
    }

    // Método para obtener la contraseña de la base de datos
    public String getPassword() {
        return password;
    }

    // Método para establecer la contraseña de la base de datos
    public void setPassword(String password) {
        this.password = password;
    }
}
