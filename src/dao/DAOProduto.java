package dao;

import conexao.Conexao;
import static conexao.Conexao.connection;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import modelo.ModeloProduto;

public class DAOProduto {

    //Método para inserir produto
    public void insereProduto(ModeloProduto produto) {
        //Abrir conexao
        Connection con = Conexao.getConnection();
        PreparedStatement stmt = null;
        String sql = "insert into tb_produtos(NomeProduto,Patrimonio,Localizacao,DescricaoProduto,qtd_estoque) "
                + "values(?,?,?,?,?)";
        try {
            stmt = connection.prepareStatement(sql);
            stmt.setString(1, produto.getNomeProduto());
            stmt.setInt(2, produto.getPatrimonio());
            stmt.setString(3, produto.getLocalizacaoProduto());
            stmt.setString(4, produto.getDescricaoProduto());
            stmt.setInt(5, 0);
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Não foi Possível cadastrar este produto!", JOptionPane.ERROR_MESSAGE);
            //Encerra conexão
        } finally {
            Conexao.closeConnection(con, stmt);
        }
    }

    //Método para inserir produto com validade
    public void insereProdutoValidade(ModeloProduto produto) {
        //Abrir conexao
        Connection con = Conexao.getConnection();
        PreparedStatement stmt = null;
        String sql = "insert into tb_produtos(NomeProduto,Patrimonio,Localizacao,Validade,DescricaoProduto,qtd_estoque) values(?,?,?,?,?,?)";
        try {
            stmt = connection.prepareStatement(sql);
            stmt.setString(1, produto.getNomeProduto());
            stmt.setInt(2, produto.getPatrimonio());
            stmt.setString(3, produto.getLocalizacaoProduto());
            stmt.setDate(4, new java.sql.Date(produto.getValidadeProduto().getTime()));
            stmt.setString(5, produto.getDescricaoProduto());
            stmt.setInt(6, 0);
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Não foi Possível cadastrar este produto!", JOptionPane.ERROR_MESSAGE);
            //Encerra conexão
        } finally {
            Conexao.closeConnection(con, stmt);
        }

    }

    //método para listar todos os produtos em um ArrayList
    public List<ModeloProduto> readProduto() {
        //Abrir conexão
        Connection con = Conexao.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<ModeloProduto> produtos = new ArrayList<>();
        try {
            stmt = con.prepareStatement("SELECT * FROM tb_produtos");
            rs = stmt.executeQuery();
            while (rs.next()) {
                ModeloProduto produto = new ModeloProduto();
                produto.setIdProduto(rs.getInt("idProduto"));
                produto.setNomeProduto(rs.getString("NomeProduto"));
                produto.setPatrimonio(rs.getInt("Patrimonio"));
                produto.setLocalizacaoProduto(rs.getString("Localizacao"));
                produto.setQtdEstoque(rs.getInt("qtd_estoque"));
                produto.setValidadeProduto(rs.getDate("Validade"));
                produto.setDescricaoProduto(rs.getString("DescricaoProduto"));
                produtos.add(produto);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Não foi Possível ler informações do banco de dados", JOptionPane.ERROR_MESSAGE);
            //Encerra conexão
        } finally {
            Conexao.closeConnection(con, stmt, rs);
        }
        return produtos;
    }

    public void delete(ModeloProduto produto) {
        //Abrir conexao
        Connection con = Conexao.getConnection();
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("DELETE FROM tb_produtos WHERE idProduto = ?");
            stmt.setInt(1, produto.getIdProduto());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Não foi Possível deletar este produto!", JOptionPane.ERROR_MESSAGE);
        } finally {
            Conexao.closeConnection(con, stmt);
        }
    }

    //método para alerar um produto
    public void alteraProduto(ModeloProduto produto) {
        //Abrir conexao
        Connection con = Conexao.getConnection();
        PreparedStatement stmt = null;
        String sql = "update tb_produtos set NomeProduto=?,Localizacao=?,Validade=?,DescricaoProduto=? where idProduto = '" + produto.getIdProduto() + "'";
             
        try {
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setString(1, produto.getNomeProduto());
            pst.setString(2, produto.getLocalizacaoProduto());
            pst.setDate(3, new java.sql.Date(produto.getValidadeProduto().getTime()));
            pst.setString(4, produto.getDescricaoProduto());
            pst.executeUpdate();
     
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Não foi Possível alterar este produto!", JOptionPane.ERROR_MESSAGE);
            //Encerra conexão
        } finally {
            Conexao.closeConnection(con, stmt);
        }
    }

    //método para alerar um produto sem validade
    public void alteraProdutoSemValidade(ModeloProduto produto) {
        //Abrir conexao
        Connection con = Conexao.getConnection();
        PreparedStatement stmt = null;
        String sql = "update tb_produtos set NomeProduto=?,Localizacao=?,DescricaoProduto=? where idProduto = '" + produto.getIdProduto() + "'";
          
        try {
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setString(1, produto.getNomeProduto());
            pst.setString(2, produto.getLocalizacaoProduto());
            pst.setString(3, produto.getDescricaoProduto());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Não foi Possível alterar este produto!", JOptionPane.ERROR_MESSAGE);
            //Encerra conexão
        } finally {
            Conexao.closeConnection(con, stmt);
        }
    }

    //Método para encontrar um produto especifico usando o ID
    public void obterProduto(ModeloProduto produto) {
        //Abrir conexao
        Connection con = Conexao.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            stmt = con.prepareStatement("SELECT * FROM tb_produtos where idProduto = '" + produto.getIdProduto() + "'");
            rs = stmt.executeQuery();
            while (rs.next()) {
                produto.setIdProduto(rs.getInt("idProduto"));
                produto.setNomeProduto(rs.getString("NomeProduto"));
                produto.setPatrimonio(rs.getInt("Patrimonio"));
                produto.setLocalizacaoProduto(rs.getString("Localizacao"));
                produto.setQtdEstoque(rs.getInt("qtd_estoque"));
                produto.setValidadeProduto(rs.getDate("Validade"));
                produto.setDescricaoProduto(rs.getString("DescricaoProduto"));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Não foi Possível retornar produto de DAOProduto", JOptionPane.ERROR_MESSAGE);
            //Encerra conexão
        } finally {
            Conexao.closeConnection(con, stmt, rs);
        }
    }
}
