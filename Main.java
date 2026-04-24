import java.sql.Connection; 
import java.sql.DriverManager; 
import java.sql.Statement; 

public class Main { 
	public static void main(String[] args) throws Exception { 
		String host = System.getenv("DB_HOST"); 
		String port = System.getenv("DB_PORT"); 
		String db = System.getenv("DB_NAME"); 
		String user = System.getenv("DB_USER"); 
		String pass = System.getenv("DB_PASSWORD"); 
		
		Connection conn = DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/" + db, user, pass); 
		
		Statement stmt = conn.createStatement(); 
		stmt.executeUpdate("""
			CREATE TABLE IF NOT EXISTS DISCIPLINA (
				NOME VARCHAR(255),
				QTD_HORAS INT,
				DESCRICAO VARCHAR(255)
			)
		""");
		stmt.executeUpdate(""" 
			INSERT INTO DISCIPLINA (
				NOME, 
				QTD_HORAS, 
				DESCRICAO
			) VALUES (
				'TÓPICOS ESPECIAIS EM TECNOLOGIAS EMERGENTES I', 
				30, 
				'GIT, DOCKER, GIT ACTIONS e KUBERNETES'
			) 
		"""); 
		
		System.out.println("Tabela criada e dados inseridos!"); 
		conn.close();
	} 
}