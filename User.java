import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class User {
    public Connection conectarBD() { //Realiza a conexão com o banco e retorna o objeto
        Connection conn = null;
        try {
            Class.forName("com.mysql.Driver.Manager").newInstance();
            String url = "jdbc:mysql://127.0.0.1/test?user=lopes&password=123"; //String de conexão
            conn = DriverManager.getConnection(url); //Tenta realizar a conexão
        } catch (Exception e) {
        }
        return conn;
    }

    public String nome = "";
    public boolean result = false;

    public boolean verificarUsuario(String login, String senha) {
        String sql = "";
        Connection conn = conectarBD(); //Recebe objeto de conexão
        // INSTRUÇÃO SQL
        sql += "select nome from usuarios ";
        sql += "where login = " + "'" + login + "'";
        sql += " and senha = " + "'" + senha + "';";
        try {
            Statement st = conn.createStatement(); //Cria objeto responsável por executar queries sql
            ResultSet rs = st.executeQuery(sql); //Executa a query pela conexão e retorna o resultado
            if (rs.next()) { //Verifica se a query retornou resultado
                result = true;
                nome = rs.getString("nome"); //Pega a coluna "nome" do resultado retornado
            }
        } catch (Exception e) {
        }
        return result;
    } // fim da class
}