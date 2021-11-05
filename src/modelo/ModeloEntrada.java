package modelo;

import java.util.Date;

public class ModeloEntrada {

    private int idEntrada;
    private String tipoMovimentacao;
    private Date dataEntrada;
    private int qtdEntrada;
    private String DescricaoEntrada;
    private String fornecedorEntrada;
    private int fkOrigem;
    private int fkProduto;
    private String origemTemp;
    private String produtoTemp;
    private int idEntradaTEMP;

    /**
     * @return the idEntrada
     */
    public int getIdEntrada() {
        return idEntrada;
    }

    /**
     * @param idEntrada the idEntrada to set
     */
    public void setIdEntrada(int idEntrada) {
        this.idEntrada = idEntrada;
    }

    /**
     * @return the dataEntrada
     */
    public Date getDataEntrada() {
        return dataEntrada;
    }

    /**
     * @param dataEntrada the dataEntrada to set
     */
    public void setDataEntrada(Date dataEntrada) {
        this.dataEntrada = dataEntrada;
    }

    /**
     * @return the qtdEntrada
     */
    public int getQtdEntrada() {
        return qtdEntrada;
    }

    /**
     * @param qtdEntrada the qtdEntrada to set
     */
    public void setQtdEntrada(int qtdEntrada) {
        this.qtdEntrada = qtdEntrada;
    }

    /**
     * @return the DescricaoEntrada
     */
    public String getDescricaoEntrada() {
        return DescricaoEntrada;
    }

    /**
     * @param DescricaoEntrada the DescricaoEntrada to set
     */
    public void setDescricaoEntrada(String DescricaoEntrada) {
        this.DescricaoEntrada = DescricaoEntrada;
    }

    /**
     * @return the fornecedorEntrada
     */
    public String getFornecedorEntrada() {
        return fornecedorEntrada;
    }

    /**
     * @param fornecedorEntrada the fornecedorEntrada to set
     */
    public void setFornecedorEntrada(String fornecedorEntrada) {
        this.fornecedorEntrada = fornecedorEntrada;
    }

    /**
     * @return the FkOrigem
     */
    public int getFkOrigem() {
        return fkOrigem;
    }

    /**
     * @param FkOrigem the FkOrigem to set
     */
    public void setFkOrigem(int FkOrigem) {
        this.fkOrigem = FkOrigem;
    }

    /**
     * @return the FKProduto
     */
    public int getFKProduto() {
        return fkProduto;
    }

    /**
     * @param FKProduto the FKProduto to set
     */
    public void setFKProduto(int FKProduto) {
        this.fkProduto = FKProduto;
    }

    /**
     * @return the OrigemTemp
     */
    public String getOrigemTemp() {
        return origemTemp;
    }

    /**
     * @param OrigemTemp the OrigemTemp to set
     */
    public void setOrigemTemp(String OrigemTemp) {
        this.origemTemp = OrigemTemp;
    }

    /**
     * @return the ProdutoTemp
     */
    public String getProdutoTemp() {
        return produtoTemp;
    }

    /**
     * @param ProdutoTemp the ProdutoTemp to set
     */
    public void setProdutoTemp(String ProdutoTemp) {
        this.produtoTemp = ProdutoTemp;
    }

    /**
     * @return the idEntradaTEMP
     */
    public int getIdEntradaTEMP() {
        return idEntradaTEMP;
    }

    /**
     * @param idEntradaTEMP the idEntradaTEMP to set
     */
    public void setIdEntradaTEMP(int idEntradaTEMP) {
        this.idEntradaTEMP = idEntradaTEMP;
    }

    /**
     * @return the tipoMovimentacao
     */
    public String getTipoMovimentacao() {
        return tipoMovimentacao;
    }

    /**
     * @param tipoMovimentacao the tipoMovimentacao to set
     */
    public void setTipoMovimentacao(String tipoMovimentacao) {
        this.tipoMovimentacao = tipoMovimentacao;
    }

}
