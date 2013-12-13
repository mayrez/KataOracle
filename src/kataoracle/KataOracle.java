package kataoracle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class KataOracle {
    private static final String URL = "jdbc:oracle:thin:@localhost:1521:orcl";
    private static final String USR= "system";
    private static final String PASSWD= "orcl";
    
    public static void main(String[] args) throws SQLException {
        DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
        Connection connection = DriverManager.getConnection(URL, USR, PASSWD);
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM CAMBIO_EUR_A");
        while(resultSet.next()){
            System.out.print(resultSet.getString("DIVISA")+ " ");
            System.out.println(resultSet.getBigDecimal("CAMBIO"));
        }
        connection.close();
    }
}
