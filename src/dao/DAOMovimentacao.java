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
import modelo.ModeloEntrada;
import modelo.ModeloMovimentacao;
import modelo.ModeloPessoa;
import modelo.ModeloProduto;

public class DAOMovimentacao {

    ModeloProduto produto = new ModeloProduto();

    private Connection connection;
    private String sql;

    public DAOMovimentacao() {
        this.connection = new Conexao().getConnection();
    }

    //método para inserir saída
    public void insereSaida(ModeloMovimentacao saida) {
        Connection con = Conexao.getConnection();
        PreparedStatement smt = null;
        PreparedStatement up = null;
        sql = "insert into tb_movimentacao(TipoMovimentacao, DataMovimentacao,Destino,QtdMovimentacao,DescricaoMovimentacao,"
                + "FKProduto,FKPessoa) values(?,?,?,?,?,?,?)";
        String upd = "update tb_produtos set qtd_estoque = (qtd_estoque - ?) where idProduto = ? ";
        try {

            smt = connection.prepareStatement(sql);
            smt.setString(1, saida.getTipoMovimentacao());
            smt.setDate(2, new java.sql.Date(saida.getDataMovimentacao().getTime()));
            smt.setString(3, saida.getDestinoMovimentacao());
            smt.setInt(4, saida.getQtdMovimentacao());
            smt.setString(5, saida.getDescricaoMovimentacao());
            smt.setInt(6, saida.getFKproduto());
            smt.setInt(7, saida.getFKpessoa());
            smt.execute();
            smt.close();
            up = connection.prepareStatement(upd);
            up.setInt(1, saida.getQtdMovimentacao());
            up.setInt(2, saida.getFKproduto());
            up.execute();
            up.close();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        } finally {
            Conexao.closeConnection(con, smt);
        }
        JOptionPane.showMessageDialog(null, "Retirada efetuada com sucesso! ");
    }

    public void insereSaidaID(ModeloMovimentacao movimentacao) {

        if (movimentacao.getQtdMovimentacao() > produto.getQtdEstoque()) {

            JOptionPane.showMessageDialog(null, "Retirada insuficiente no estoque!");
        } else {
            sql = "insert into tb_movimentacao(TipoMovimentacao, DataMovimentacao,Destino,QtdMovimentacao,DescricaoMovimentacao,FKProduto,FKPessoa) values(?,?,?,?,?,?,?)";
            String up = "update tb_produtos set qtd_estoque = (qtd_estoque - ?) where idProduto = ? ";
            try {
                PreparedStatement smt = connection.prepareStatement(sql);
                smt.setString(1, movimentacao.getTipoMovimentacao());
                smt.setDate(2, new java.sql.Date(movimentacao.getQtdMovimentacao()));
                smt.setString(3, movimentacao.getDestinoMovimentacao());
                smt.setInt(4, movimentacao.getQtdMovimentacao());
                smt.setString(5, movimentacao.getDescricaoMovimentacao());
                smt.setInt(6, movimentacao.getFKproduto());
                smt.setInt(7, movimentacao.getFKpessoa());

                smt.execute();
                smt.close();

                PreparedStatement update = connection.prepareStatement(up);
                update.setInt(1, movimentacao.getQtdMovimentacao());
                update.setInt(2, movimentacao.getFKproduto());

                update.execute();
                update.close();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
            JOptionPane.showMessageDialog(null, "Retirada para " + movimentacao.getTempProduto() + " efetuada com sucesso! ");
        }
    }

    public int obterEstoque(int idproduto) {

        Connection con = Conexao.getConnection();
        int qtdEstoque = 0;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            stmt = con.prepareStatement("SELECT qtd_estoque FROM tb_produtos where idProduto = '" + idproduto + "'");
            rs = stmt.executeQuery();

            while (rs.next()) {
                qtdEstoque = rs.getInt("qtd_estoque");
            }

        } catch (SQLException ex) {
            Logger.getLogger(DAOProduto.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Conexao.closeConnection(con, stmt, rs);
        }
        return qtdEstoque;
    }

    public void obterIdProduto(ModeloMovimentacao movimentacao) {

        Connection con = Conexao.getConnection();

        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            stmt = con.prepareStatement("SELECT * FROM tb_produtos where NomeProduto = '" + movimentacao.getTempProduto() + "'");
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

    public void obterIdPessoa(ModeloMovimentacao movimentacao) {
        ModeloMovimentacao mov = new ModeloMovimentacao();
        Connection con = Conexao.getConnection();

        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            stmt = con.prepareStatement("SELECT idPessoa FROM tb_pessoas where NomePessoa = '" + mov.getTemPessoa() + "'");
            rs = stmt.executeQuery();

            while (rs.next()) {
                pessoa.setIdPessoa(rs.getInt("idPessoa"));
            }

        } catch (SQLException ex) {
            Logger.getLogger(DAOProduto.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Conexao.closeConnection(con, stmt, rs);
        }
    }

    public List<ModeloMovimentacao> readObrterProduto() {
        Connection con = Conexao.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<ModeloMovimentacao> readProdutos = new ArrayList<>();
        try {
            stmt = con.prepareStatement("select NomeProduto from tb_produtos inner join tb_movimentacao on idProduto=FKProduto");
            rs = stmt.executeQuery();
            while (rs.next()) {
                ModeloMovimentacao retirada = new ModeloMovimentacao();
                retirada.setTempProduto(rs.getString("NomeProduto"));
                readProdutos.add(retirada);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOProduto.class
                    .getName()).log(Level.SEVERE, null, ex);
        } finally {
            Conexao.closeConnection(con, stmt, rs);

        }

        return readProdutos;

    }

    public List<ModeloMovimentacao> readObterPessoa() {
        Connection con = Conexao.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<ModeloMovimentacao> readPessoas = new ArrayList<>();
        try {
            stmt = con.prepareStatement("Select NomePessoa from tb_pessoas inner join tb_movimentacao on idPessoa=FKPessoa");
            rs = stmt.executeQuery();
            while (rs.next()) {
                ModeloMovimentacao retirada = new ModeloMovimentacao();
                retirada.setTempProduto(rs.getString("NomePessoa"));
                readPessoas.add(retirada);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOProduto.class
                    .getName()).log(Level.SEVERE, null, ex);
        } finally {
            Conexao.closeConnection(con, stmt, rs);
        }
        return readPessoas;

    }

    public List<ModeloMovimentacao> readSaida() {
        Connection con = Conexao.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<ModeloMovimentacao> retiradas = new ArrayList<>();
        try {
            stmt = con.prepareStatement("select mov.idmovimentacao,mov.TipoMovimentacao,mov.DataMovimentacao,mov.Destino,mov.QtdMovimentacao,\n"
                    + "mov.DescricaoMovimentacao, prod.NomeProduto, pes.NomePessoa from tb_movimentacao mov\n"
                    + "inner join tb_pessoas pes on pes.idPessoa = mov.FKPessoa\n"
                    + "inner join tb_produtos prod on prod.idProduto=mov.FKProduto where TipoMovimentacao='Saída'");
            rs = stmt.executeQuery();
            while (rs.next()) {
                ModeloMovimentacao retirada = new ModeloMovimentacao();

                retirada.setIdMovimentacao(rs.getInt("idMovimentacao"));
                retirada.setTipoMovimentacao(rs.getString("TipoMovimentacao"));
                retirada.setDataMovimentacao(rs.getDate("DataMovimentacao"));
                retirada.setQtdMovimentacao(rs.getInt("QtdMovimentacao"));
                retirada.setTempProduto(rs.getString("NomeProduto"));
                retirada.setTemPessoa(rs.getString("NomePessoa"));

                retiradas.add(retirada);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOProduto.class
                    .getName()).log(Level.SEVERE, null, ex);
        } finally {
            Conexao.closeConnection(con, stmt, rs);
        }
        return retiradas;
    }

    public void obterFKProduto(ModeloMovimentacao movimentacao) {
        //Abrir conexao
        Connection con = Conexao.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            stmt = con.prepareStatement("select * from tb_movimentacao where idMovimentacao = '" + movimentacao.getIdMovimentacao() + "'");
            rs = stmt.executeQuery();
            while (rs.next()) {
                movimentacao.setIdMovimentacao(rs.getInt("idmovimentacao"));
                movimentacao.setTipoMovimentacao(rs.getString("TipoMovimentacao"));
                movimentacao.setDataMovimentacao(rs.getDate("DataMovimentacao"));
                movimentacao.setDestinoMovimentacao(rs.getString("Destino"));
                movimentacao.setQtdMovimentacao(rs.getInt("QtdMovimentacao"));
                movimentacao.setDescricaoMovimentacao(rs.getString("DescricaoMovimentacao"));
                movimentacao.setFKproduto(rs.getInt("FKProduto"));
                movimentacao.setFKpessoa(rs.getInt("FKPessoa"));

            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Não foi Possível retornar produto de DAOProduto", JOptionPane.ERROR_MESSAGE);
            //Encerra conexão
        } finally {
            Conexao.closeConnection(con, stmt, rs);
        }
    }

    public void deleteSaida(ModeloMovimentacao movimentacao) {
        //Abrir conexao
        Connection con = Conexao.getConnection();
        PreparedStatement stmt = null;
        PreparedStatement up = null;
        DAOProduto prod = new DAOProduto();

        prod.obterProduto(produto);
        try {
            up = con.prepareStatement("update tb_produtos set qtd_estoque = (qtd_estoque  + ?) where idProduto = ? ");
            up.setInt(1, movimentacao.getQtdMovimentacao());
            up.setInt(2, produto.getIdProduto());
            up.execute();
      
            stmt = con.prepareStatement("DELETE FROM tb_movimentacao WHERE idMovimentacao = ?");
            stmt.setInt(1, movimentacao.getIdMovimentacao());
            stmt.executeUpdate();

            stmt.close();
            up.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Não foi Possível deletar este produto!", JOptionPane.ERROR_MESSAGE);
        } finally {
            Conexao.closeConnection(con, stmt);
        }
        JOptionPane.showMessageDialog(null, "Excluido com sucesso!");
    }

    public void delete(ModeloMovimentacao movimentacao) {
        //Abrir conexao
        Connection con = Conexao.getConnection();
        PreparedStatement stmt = null;
        DAOProduto prod = new DAOProduto();
        prod.obterProduto(produto);
        try {
            stmt = con.prepareStatement("DELETE FROM tb_movimentacao WHERE idMovimentacao = ?");
            stmt.setInt(1, movimentacao.getIdMovimentacao());

            stmt.executeUpdate();
            stmt.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Não foi Possível deletar este produto!", JOptionPane.ERROR_MESSAGE);
        } finally {
            Conexao.closeConnection(con, stmt);
        }
        JOptionPane.showMessageDialog(null, "Excluido com sucesso!");
    }
    ModeloMovimentacao ret = new ModeloMovimentacao();
    ModeloPessoa pessoa = new ModeloPessoa();

    //método para inserir empréstimo
    public void insereSaidaEmprestimo(ModeloMovimentacao emp) {
        Connection con = Conexao.getConnection();
        PreparedStatement smt = null;
        PreparedStatement up = null;
        sql = "insert into tb_movimentacao(TipoMovimentacao, DataMovimentacao,QtdMovimentacao,DescricaoMovimentacao,"
                + "Situacao,FKProduto,FKPessoa) values(?,?,?,?,?,?,?)";
        String upd = "update tb_produtos set qtd_estoque = (qtd_estoque - ?) where idProduto = ? ";
        try {
            smt = connection.prepareStatement(sql);
            smt.setString(1, emp.getTipoMovimentacao());
            smt.setString(2, emp.getDataMovimentacaoSTR());
            smt.setInt(3, emp.getQtdMovimentacao());
            smt.setString(4, emp.getDescricaoMovimentacao());
            smt.setString(5, emp.getSituacao());
            smt.setInt(6, emp.getFKproduto());
            smt.setInt(7, emp.getFKpessoa());
            smt.execute();
            smt.close();
            up = connection.prepareStatement(upd);
            up.setInt(1, emp.getQtdMovimentacao());
            up.setInt(2, emp.getFKproduto());
            up.execute();
            up.close();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        } finally {
            Conexao.closeConnection(con, smt);
        }
        JOptionPane.showMessageDialog(null, "Empréstimo efetuado com sucesso! ");
    }

    public List<ModeloMovimentacao> readEprestimo() {
        Connection con = Conexao.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<ModeloMovimentacao> retiradas = new ArrayList<>();
        try {
            ModeloMovimentacao ret = new ModeloMovimentacao();
            stmt = con.prepareStatement("select mov.idmovimentacao,mov.TipoMovimentacao,mov.DataMovimentacao,mov.QtdMovimentacao,\n"
                    + "mov.DescricaoMovimentacao,mov.DataDevolucao,mov.Situacao, prod.NomeProduto, pes.NomePessoa from tb_movimentacao mov\n"
                    + "inner join tb_pessoas pes on pes.idPessoa = mov.FKPessoa\n"
                    + "inner join tb_produtos prod on prod.idProduto=mov.FKProduto where TipoMovimentacao='Empréstimo'");

            rs = stmt.executeQuery();

            while (rs.next()) {

                ModeloMovimentacao retirada = new ModeloMovimentacao();

                retirada.setIdMovimentacao(rs.getInt("idMovimentacao"));
                retirada.setTipoMovimentacao(rs.getString("TipoMovimentacao"));
                retirada.setDataMovimentacaoSTR(rs.getString("DataMovimentacao"));
                retirada.setQtdMovimentacao(rs.getInt("QtdMovimentacao"));
                retirada.setDataDevolucaoSTR(rs.getString("DataDevolucao"));
                retirada.setTempProduto(rs.getString("NomeProduto"));
                retirada.setTemPessoa(rs.getString("NomePessoa"));
                retirada.setSituacao(rs.getString("Situacao"));

                retiradas.add(retirada);

            }

        } catch (SQLException ex) {
            Logger.getLogger(DAOProduto.class
                    .getName()).log(Level.SEVERE, null, ex);
        } finally {
            Conexao.closeConnection(con, stmt, rs);

        }

        return retiradas;
    }

    public void DevolveEmpréstimo(ModeloMovimentacao movimentacao) {
        //Abrir conexao
        Connection con = Conexao.getConnection();
        ModeloProduto prod = new ModeloProduto();

        String uptm = "update tb_movimentacao set DataDevolucao=?,Situacao='Devolvido' where idmovimentacao = '" + movimentacao.getIdMovimentacao() + "'";
        String upt = "update tb_produtos set qtd_estoque=(qtd_estoque + ?) where idProduto = '" + produto.getIdProduto() + "'";

        try {
            PreparedStatement pst = connection.prepareStatement(uptm);
            pst.setString(1, movimentacao.getDataDevolucaoSTR());

            pst.executeUpdate();
            pst.close();

            PreparedStatement update = connection.prepareStatement(upt);
            update.setInt(1, movimentacao.getQtdMovimentacao());

            update.executeUpdate();
            update.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Não foi Possível finalizar este empréstimo!", JOptionPane.ERROR_MESSAGE);
            //Encerra conexão
        } finally {
            Conexao.closeConnection(con);
        }

    }

    

}
