package dao;

import conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modelo.ModeloEntrada;
import modelo.ModeloOrigem;
import modelo.ModeloProduto;

public class DAOEntrada {

    ModeloOrigem origem = new ModeloOrigem();

    private Connection connection;
    private String sql;

    public DAOEntrada() {
        this.connection = new Conexao().getConnection();
    }

//método para inserir entrada
    public void insereEntrada(ModeloEntrada entrada) {
        sql = "INSERT INTO tb_entrada(TipoMovimentacao,DataEntrada,qtdEntrada,DescricaoEntrada,Fornecedor,FKOrigem,FKProduto) "
                + "VALUES(?,?,?,?,?,?,?)";
        String up = "update tb_produtos set qtd_estoque = (qtd_estoque  + ?) where idProduto = ? ";
        try {
            PreparedStatement smt = connection.prepareStatement(sql);

            smt.setString(1, entrada.getTipoMovimentacao());
            smt.setDate(2, new java.sql.Date(entrada.getDataEntrada().getTime()));
            smt.setInt(3, entrada.getQtdEntrada());
            smt.setString(4, entrada.getDescricaoEntrada());
            smt.setString(5, entrada.getFornecedorEntrada());
            smt.setInt(6, origem.getIdOrigem());
            smt.setInt(7, produto.getIdProduto());

            smt.execute();
            smt.close();

            PreparedStatement update = connection.prepareStatement(up);
            update.setInt(1, entrada.getQtdEntrada());
            update.setInt(2, produto.getIdProduto());

            update.execute();
            update.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Verifique os dados digitados");
            throw new RuntimeException(ex);
        }
        JOptionPane.showMessageDialog(null, "Entrada cadastrada com sucesso!");
    }

    public List<ModeloEntrada> readEntrada() {
        Connection con = Conexao.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<ModeloEntrada> entradas = new ArrayList<>();
        try {
            stmt = con.prepareStatement("select ent.idEntrada,ent.TipoMovimentacao,ent.DataEntrada,ent.qtdEntrada,ent.DescricaoEntrada,ent.Fornecedor,\n"
                    + "ori.NomeOrigem,prod.NomeProduto from tb_entrada ent\n"
                    + "left join tb_origem ori on ori.idOrigem = ent.FKOrigem\n"
                    + "left join tb_produtos prod on prod.idProduto=ent.FKProduto;");
            rs = stmt.executeQuery();

            while (rs.next()) {
                ModeloEntrada entrada = new ModeloEntrada();

                entrada.setIdEntrada(rs.getInt("idEntrada"));
                entrada.setTipoMovimentacao("TipoMovimentacao");
                entrada.setDataEntrada(rs.getDate("DataEntrada"));
                entrada.setQtdEntrada(rs.getInt("qtdEntrada"));
                entrada.setDescricaoEntrada(rs.getString("DescricaoEntrada"));
                entrada.setFornecedorEntrada(rs.getString("Fornecedor"));
                entrada.setOrigemTemp(rs.getString("NomeOrigem"));
                entrada.setProdutoTemp(rs.getString("NomeProduto"));

                entradas.add(entrada);

            }

        } catch (SQLException ex) {
            Logger.getLogger(DAOProduto.class
                    .getName()).log(Level.SEVERE, null, ex);
        } finally {
            Conexao.closeConnection(con, stmt, rs);
        }

        return entradas;

    }

    //Método para encontrar uma entrada especifico usando o ID
    public void obterEntrada(ModeloEntrada entrada) {
        //Abrir conexao
        Connection con = Conexao.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            stmt = con.prepareStatement("select ent.idEntrada,ent.TipoMovimentacao,ent.DataEntrada,ent.qtdEntrada,ent.DescricaoEntrada,ent.Fornecedor,\n"
                    + "ori.NomeOrigem,prod.NomeProduto from tb_entrada ent\n"
                    + "left join tb_origem ori on ori.idOrigem = ent.FKOrigem\n"
                    + "left join tb_produtos prod on prod.idProduto=ent.FKProduto where idEntrada = '" + entrada.getIdEntrada() + "'");
            rs = stmt.executeQuery();
            while (rs.next()) {
                entrada.setIdEntrada(rs.getInt("idEntrada"));
                entrada.setTipoMovimentacao(rs.getString("TipoMovimentacao"));
                entrada.setDataEntrada(rs.getDate("DataEntrada"));
                entrada.setQtdEntrada(rs.getInt("qtdEntrada"));
                entrada.setDescricaoEntrada(rs.getString("DescricaoEntrada"));
                entrada.setFornecedorEntrada(rs.getString("Fornecedor"));
                entrada.setOrigemTemp(rs.getString("NomeOrigem"));
                entrada.setProdutoTemp(rs.getString("NomeProduto"));
                //entrada.setFkOrigem(rs.getInt("FKOrigem"));
                //entrada.setFKProduto(rs.getInt("FKProduto"));

            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Não foi Possível retornar produto de DAOProduto", JOptionPane.ERROR_MESSAGE);
            //Encerra conexão
        } finally {
            Conexao.closeConnection(con, stmt, rs);
        }
    }

    //Método para encontrar uma entrada especifico usando o ID
    public void obterFKProduto(ModeloEntrada entrada) {
        //Abrir conexao
        Connection con = Conexao.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            stmt = con.prepareStatement("select * from tb_entrada where idEntrada = '" + entrada.getIdEntrada() + "'");
            rs = stmt.executeQuery();
            while (rs.next()) {
                entrada.setIdEntrada(rs.getInt("idEntrada"));
                entrada.setTipoMovimentacao(rs.getString("TipoMovimentacao"));
                entrada.setDataEntrada(rs.getDate("DataEntrada"));
                entrada.setQtdEntrada(rs.getInt("qtdEntrada"));
                entrada.setDescricaoEntrada(rs.getString("DescricaoEntrada"));
                entrada.setFornecedorEntrada(rs.getString("Fornecedor"));
                entrada.setFkOrigem(rs.getInt("FKOrigem"));
                entrada.setFKProduto(rs.getInt("FKProduto"));

            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Não foi Possível retornar produto de DAOProduto", JOptionPane.ERROR_MESSAGE);
            //Encerra conexão
        } finally {
            Conexao.closeConnection(con, stmt, rs);
        }
    }

    public void delete(ModeloEntrada entrada) {
        //Abrir conexao
        Connection con = Conexao.getConnection();
        Connection con2 = Conexao.getConnection();
        PreparedStatement stmt = null;
        PreparedStatement stmt2 = null;
        PreparedStatement up = null;
        PreparedStatement up2 = null;

        try {
            up = con.prepareStatement("update tb_produtos set qtd_estoque = (qtd_estoque  - ?) where idProduto = ? ");
            up.setInt(1, entrada.getQtdEntrada());
            up.setInt(2, produto.getIdProduto());
            up.execute();
            stmt = con.prepareStatement("DELETE FROM tb_entrada WHERE idEntrada = ?");
            stmt.setInt(1, entrada.getIdEntrada());
            stmt.executeUpdate();

            stmt.close();
            up.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Não foi Possível deletar esta entrada!", JOptionPane.ERROR_MESSAGE);
        } finally {
           
        }

        obterIdProduto(entrada);
        if (produto.getQtdEstoque() < 0) {

            try {
                up2 = con2.prepareStatement("update tb_produtos set qtd_estoque = ? where idProduto = ? ");
                up2.setInt(1, 0);
                up2.setInt(2, produto.getIdProduto());
                up2.execute();
                up2.close();

            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(), "Não foi Possível atualizar o estoque!", JOptionPane.ERROR_MESSAGE);
            } finally {
                Conexao.closeConnection(con2, stmt2);
            }

        }
    }

    public void obteridOrigem(ModeloEntrada entrada) {

        Connection con = Conexao.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {

            stmt = con.prepareStatement("SELECT idOrigem FROM tb_origem WHERE NomeOrigem = '" + entrada.getOrigemTemp() + "'");
            String up = "update tb_produtos set qtd_estoque = (qtd_estoque  + ?) where idProduto = ? ";
            rs = stmt.executeQuery();

            while (rs.next()) {
                origem.setIdOrigem(rs.getInt("idOrigem"));

            }

        } catch (SQLException ex) {
            Logger.getLogger(DAOEntrada.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Conexao.closeConnection(con, stmt, rs);
        }
    }

    ModeloProduto produto = new ModeloProduto();

    public void obterIdProduto(ModeloEntrada entrada) {

        Connection con = Conexao.getConnection();

        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            stmt = con.prepareStatement("SELECT * FROM tb_produtos where NomeProduto = '" + entrada.getProdutoTemp() + "'");
            rs = stmt.executeQuery();

            while (rs.next()) {
                produto.setIdProduto(rs.getInt("idProduto"));
                produto.setQtdEstoque(rs.getInt("qtd_estoque"));
            }

        } catch (SQLException ex) {
            Logger.getLogger(DAOProduto.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Conexao.closeConnection(con, stmt, rs);
        }
    }

    public void obterIdProduto() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
