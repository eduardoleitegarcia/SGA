package dao;

import conexao.Conexao;
import static conexao.Conexao.connection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modelo.ModeloOrigem;

public class DAOOrigem {

//método para salvar uma origem no banco de dados
    public void insereOrigem(ModeloOrigem Origem) {
        //Abrir conexao
        Connection con = Conexao.getConnection();
        PreparedStatement stmt = null;
        String sql = "INSERT INTO tb_origem (NomeOrigem) VALUES(?)";
        try {
            stmt = connection.prepareStatement(sql);
            stmt.setString(1, Origem.getNomeOrigem());
            stmt.execute();
            stmt.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Não foi Possível cadastrar esta origem!", JOptionPane.ERROR_MESSAGE);
            //Encerra conexão
        } finally {
            Conexao.closeConnection(con, stmt);
        }
    }
    
//Método para encontrar uma origem especifica usando o ID
    public void obterOrigem(ModeloOrigem origem) {
        //Abrir conexao
        Connection con = Conexao.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            stmt = con.prepareStatement("SELECT * FROM tb_origem where idOrigem = '" + origem.getIdOrigem() + "'");
            rs = stmt.executeQuery();
            while (rs.next()) {
                origem.setIdOrigem(rs.getInt("idOrigem"));
                origem.setNomeOrigem(rs.getString("NomeOrigem"));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), " Não foi Possível retornar origem da OrigemDAO ", JOptionPane.ERROR_MESSAGE);
            //Encerra conexão
        } finally {
            Conexao.closeConnection(con, stmt, rs);
        }
    }

    //método para listar todas as origens em um ArrayList
    public List<ModeloOrigem> readOrigem() {
        //Abrir conexao
        Connection con = Conexao.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<ModeloOrigem> origens = new ArrayList<>();
        try {
            stmt = con.prepareStatement("SELECT * FROM tb_origem");
            rs = stmt.executeQuery();
            while (rs.next()) {
                ModeloOrigem origem = new ModeloOrigem();
                origem.setIdOrigem(rs.getInt("idOrigem"));
                origem.setNomeOrigem(rs.getString("NomeOrigem"));
                origens.add(origem);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Não foi Possível ler informações do banco de dados", JOptionPane.ERROR_MESSAGE);
            //Encerra conexão
        } finally {
            Conexao.closeConnection(con, stmt, rs);
        }
        return origens;
    }

    //método para alerar uma origem
    public void alterarOrigem(ModeloOrigem origem) {
        //Abrir conexao
        Connection con = Conexao.getConnection();
        PreparedStatement stmt = null;
        String sql = " update tb_origem set NomeOrigem = ? where idOrigem = '" + origem.getIdOrigem() + "'";
        try {
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setString(1, origem.getNomeOrigem());
            pst.executeUpdate();
           
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Não foi Possível alterar esta origem!", JOptionPane.ERROR_MESSAGE);
            //Encerra conexão
        } finally {
            Conexao.closeConnection(con, stmt);
        }
       // JOptionPane.showMessageDialog(null, "Alterações salvas com sucesso!");
    }

    //método para deletar uma origem
    public void delete(ModeloOrigem origem) {
        //Abrir conexao
        Connection con = Conexao.getConnection();
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("DELETE FROM tb_origem WHERE idOrigem = ?");
            stmt.setInt(1, origem.getIdOrigem());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Não foi Possível deletar esta origem!", JOptionPane.ERROR_MESSAGE);
            //Encerra conexão
        } finally {
            Conexao.closeConnection(con, stmt);
        }
    }

}
