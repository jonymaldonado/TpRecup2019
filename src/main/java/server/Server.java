package server;

import db.EntityManagerHelper;
import spark.Spark;
import spark.debug.DebugScreen;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Server {
	public static void main(String[] args) throws Exception {
		Spark.port(9000);
		Router.init();
		DebugScreen.enableDebugScreen();
		EntityManagerHelper db = new EntityManagerHelper();
		String valor = "false";

		try {
			Properties prop = new Properties();
			prop.load(new FileInputStream("src\\main\\java\\Config.properties"));
			valor = prop.getProperty("DATOS_INICIALES");

		} catch (IOException e) {
			System.out.println(e.toString());
		}

		Boolean b = Boolean.parseBoolean(valor);
		if(b){
			db.index();
		}

	}
}
