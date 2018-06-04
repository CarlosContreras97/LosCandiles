package Conexion;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ResourceBundle;
import java.sql.SQLException;

public class ConeLosCandiles{
	private static Connection con=null;
	public static Connection getConnection(){
		try{
			if(con==null){
            
				Runtime.getRuntime().addShutdownHook(new MiShHook());
				//ResourceBundle rb= new ResourceBundle.getBundle("jd");
				String driver="com.microsoft.sqlserver.jdbc.SQLServerDriver";
                Class.forName(driver);
				String url="jdbc:sqlserver://localhost:1433;"+"DatabaseName=LosCandiles;";
				String pwd="sistemas";
				String usr="sa";
				
				con=DriverManager.getConnection(url,usr,pwd);
			}
			return con;
		}
		catch(Exception ex){
			ex.printStackTrace();
			throw new RuntimeException("Error al crear la conexion",ex);
		}
	}
	static class MiShHook extends Thread{
		public void run(){
			try{
				Connection con= ConeLosCandiles.getConnection();
				con.close();
			}
			catch(Exception ex){
				ex.printStackTrace();
				throw new RuntimeException("yeah",ex);
			}
		}
	}
}
