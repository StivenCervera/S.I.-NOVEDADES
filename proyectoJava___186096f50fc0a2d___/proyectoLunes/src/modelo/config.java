package modelo;
import java.sql.*;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;

public class config {
	private static final String bbdd="jdbc:mysql://localhost:3306/usuario";
	private static final String usuario="root";
	private static final String clave="";
	private static Connection con;
	private static BasicDataSource ds = null;
	
	public static DataSource getDataSource() {
		if (ds == null) {
			ds = new BasicDataSource();
			ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
			ds.setUsername(usuario);
			ds.setPassword(clave);
			ds.setUrl(bbdd);
			// Definimos el tamaño del pool de conexiones
			ds.setInitialSize(50);// 50 Conexiones iniciales
			ds.setMaxIdle(10); //conexiones mínimas activas
			ds.setMaxTotal(20); //total conexiones 
			ds.setMaxWaitMillis(5000); //Tiempo de espera

		}
		return ds;
	}

	public Connection getConexion() {
		
		try {
			con=getDataSource().getConnection();
		}catch(Exception e) {
			System.out.print("Error de conexión a la base de datos "+e.getMessage().toString());			
		}
		
		return con;
	}

	
}
