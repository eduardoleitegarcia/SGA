package dao;

import conexao.Conexao;
import static conexao.Conexao.connection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import modelo.ModeloPessoa;

public class DAOPessoa {

//Método par ainserir pessoa
    public void inserePessoa(ModeloPessoa pessoa) {
        //Abrir conexao
        Connection con = Conexao.getConnection();
        PreparedStatement stmt = null;
        String sql = "insert into tb_pessoas (NomePessoa,Categoria) values(?,?)";
        try {
            stmt = connection.prepareStatement(sql);
            stmt.setString(1, pessoa.getNomePessoa());
            stmt.setString(2, pessoa.getCategoria());
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Não foi Possível cadastrar essa pessoa", JOptionPane.ERROR_MESSAGE);
            //Encerra conexão
        } finally {
            Conexao.closeConnection(con, stmt);
        }
    }

    //Método para encontrar uma pessoa especifica usando o ID
    public void obterPessoa(ModeloPessoa pessoa) {
        //Abrir conexao
        Connection con = Conexao.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            stmt = con.prepareStatement("SELECT * FROM tb_pessoas where idPessoa = '" + pessoa.getIdPessoa() + "'");
            rs = stmt.executeQuery();
            while (rs.next()) {
                pessoa.setIdPessoa(rs.getInt("idPessoa"));
                pessoa.setNomePessoa(rs.getString("NomePessoa"));
                pessoa.setCategoria(rs.getString("Categoria"));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Não foi Possível retornar pessoa da DAOPessoa", JOptionPane.ERROR_MESSAGE);
            //Encerra conexão
        } finally {
            Conexao.closeConnection(con, stmt, rs);
        }
    }

    //método para alerar uma pessoa
    public void alteraPessoa(ModeloPessoa pessoa) {
        //Abrir conexao
        Connection con = Conexao.getConnection();
        PreparedStatement stmt = null;
        String sql = "update tb_pessoas set NomePessoa=?,Categoria=? where idPessoa = '" + pessoa.getIdPessoa() + "'";
        try {
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setString(1, pessoa.getNomePessoa());
            pst.setString(2, pessoa.getCategoria());
            pst.executeUpdate();
        
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Não foi Possível alterar esta origem!", JOptionPane.ERROR_MESSAGE);
            //Encerra conexão
        } finally {
            Conexao.closeConnection(con, stmt);
        }
    }

//método para listar todas as pessoas em um ArrayList
    public List<ModeloPessoa> readPessoa() {
        //Abrir conexão
        Connection con = Conexao.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<ModeloPessoa> pessoas = new ArrayList<>();
        try {
            stmt = con.prepareStatement("SELECT * FROM tb_pessoas");
            rs = stmt.executeQuery();
            while (rs.next()) {
                ModeloPessoa pessoa = new ModeloPessoa();
                pessoa.setIdPessoa(rs.getInt("idPessoa"));
                pessoa.setNomePessoa(rs.getString("NomePessoa"));
                pessoa.setCategoria(rs.getString("Categoria"));
                pessoas.add(pessoa);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Não foi Possível ler informações do banco de dados", JOptionPane.ERROR_MESSAGE);
            //Encerra conexão
        } finally {
            Conexao.closeConnection(con, stmt, rs);
        }
        return pessoas;
    }

    //método para deletar uma pessoa
    public void delete(ModeloPessoa pessoa) {
        //Abrir conexao
        Connection con = Conexao.getConnection();
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("DELETE FROM tb_pessoas WHERE idPessoa = ?");
            stmt.setInt(1, pessoa.getIdPessoa());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Não foi Possível deletar esta pessoa!", JOptionPane.ERROR_MESSAGE);
            //Encerra conexão
        } finally {
            Conexao.closeConnection(con, stmt);
        }
    }

}
