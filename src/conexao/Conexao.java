/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conexao {

    public static Connection connection = null;

    // classe para efetuar a conexao
    public static Connection getConnection() {

        System.out.println("Conectando ... ");
        try {
            //carregar driver do MySQL
            Class.forName("com.mysql.jdbc.Driver");
            //caminho da base de dados
            String url = "jdbc:mysql://localhost:3306/bd_almoxarifado?useSSL=false";
            String usuario = "root";
            String senha = "";

            connection = DriverManager.getConnection(url, usuario, senha);
            System.out.println("Conectado !!!");

        } catch (ClassNotFoundException e) {
            System.out.println("erro ao carregar o driver");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("erro na base de dados");
            e.printStackTrace();
        }

        return connection;
    }

    public static void main(String[] args) throws SQLException {
        Connection connection = new Conexao().getConnection();

        connection.close();

    }

    public static void closeConnection(Connection con) {
        try {
            if (con != null) {
                con.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void closeConnection(Connection con, PreparedStatement stmt) {

        closeConnection(con);

        try {

            if (stmt != null) {
                stmt.close();
            }

        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void closeConnection(Connection con, PreparedStatement stmt, ResultSet rs) {

        closeConnection(con, stmt);

        try {

            if (rs != null) {
                rs.close();
            }

        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
