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
import modelo.ModeloMovimentacao;
import modelo.ModeloRelatorio;

public class DAORelatorio {

    public List<ModeloRelatorio> readRelatorio() {
        //Abrir conexão
        Connection con = Conexao.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<ModeloRelatorio> relatorios = new ArrayList<>();
        try {
            stmt = con.prepareStatement("select mov.DataMovimentacao as data, mov.FKProduto, pro.nomeProduto as produto, mov.QtdMovimentacao as quantidade, mov.TipoMovimentacao as tipo_movimentacao \n"
                    + "from tb_movimentacao mov join tb_produtos pro on pro.idProduto = mov.FKProduto\n"
                    + "union\n"
                    + "select ent.DataEntrada as data, ent.FKProduto, pro.nomeProduto as produto, ent.qtdEntrada as quantidade, ent.TipoMovimentacao as tipo_movimentacao\n"
                    + "from tb_entrada ent join tb_produtos pro on pro.idProduto = ent.FKProduto;");
            rs = stmt.executeQuery();
            while (rs.next()) {
                ModeloRelatorio relatorio = new ModeloRelatorio();

                relatorio.setData(rs.getDate("data"));
                relatorio.setProduto(rs.getString("produto"));
                relatorio.setQtd(rs.getInt("quantidade"));
                relatorio.setTipo(rs.getString("tipo_movimentacao"));

                relatorios.add(relatorio);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Não foi Possível ler informações do banco de dados", JOptionPane.ERROR_MESSAGE);
            //Encerra conexão
        } finally {
            Conexao.closeConnection(con, stmt, rs);
        }
        return relatorios;
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
                entrada.setTipoMovimentacao(rs.getString("TipoMovimentacao"));
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

    public List<ModeloMovimentacao> readSaida() {

        Connection con = Conexao.getConnection();

        PreparedStatement stmt = null;
        // PreparedStatement stmtProd = null;
        // PreparedStatement stmtPess = null;

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
                retirada.setDataMovimentacaoSTR(rs.getString("DataMovimentacao"));
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

    public List<ModeloRelatorio> readRelatorioPorData(ModeloRelatorio relatorio) {
        //Abrir conexão
        Connection con = Conexao.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<ModeloRelatorio> relatorios = new ArrayList<>();

        try {
            stmt = con.prepareStatement("select mov.DataMovimentacao as data, pro.nomeProduto as produto, mov.QtdMovimentacao as quantidade, mov.TipoMovimentacao as tipo_movimentacao \n"
                    + "from tb_movimentacao mov join tb_produtos pro on pro.idProduto = mov.FKProduto where mov.DataMovimentacao BETWEEN '" + relatorio.getInicio() + "' and '" + relatorio.getFim() + "' \n"
                    + "union\n"
                    + "select ent.DataEntrada as data, pro.nomeProduto as produto, ent.qtdEntrada as quantidade, ent.TipoMovimentacao as tipo_movimentacao\n"
                    + "from tb_entrada ent join tb_produtos pro on pro.idProduto = ent.FKProduto where ent.DataEntrada BETWEEN '" + relatorio.getInicio() + "' and '" + relatorio.getFim() + "';");
            rs = stmt.executeQuery();
            while (rs.next()) {
                ModeloRelatorio relatorio1 = new ModeloRelatorio();
                relatorio1.setData(rs.getDate("data"));
                relatorio1.setProduto(rs.getString("produto"));
                relatorio1.setQtd(rs.getInt("quantidade"));
                relatorio1.setTipo(rs.getString("tipo_movimentacao"));
                relatorios.add(relatorio1);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Não foi Possível ler informações do banco de dados", JOptionPane.ERROR_MESSAGE);
            //Encerra conexão
        } finally {
            Conexao.closeConnection(con, stmt, rs);
        }
        return relatorios;
    }

}
