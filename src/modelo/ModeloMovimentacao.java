package modelo;

import java.util.Date;

public class ModeloMovimentacao {

    private int idMovimentacao;
    private String tipoMovimentacao;
    private Date dataMovimentacao;
    private String dataMovimentacaoSTR;
    private String destinoMovimentacao;
    private Date dataDevolucao;
    private String dataDevolucaoSTR;
    private int qtdMovimentacao;
    private String descricaoMovimentacao;
    private String situacao;
    private int FKproduto;
    private int FKpessoa;

    private String tempProduto;
    private String temPessoa;

    /**
     * @return the idMovimentacao
     */
    public int getIdMovimentacao() {
        return idMovimentacao;
    }

    /**
     * @param idMovimentacao the idMovimentacao to set
     */
    public void setIdMovimentacao(int idMovimentacao) {
        this.idMovimentacao = idMovimentacao;
    }

    /**
     * @return the dataMovimentacao
     */
    public Date getDataMovimentacao() {
        return dataMovimentacao;
    }

    /**
     * @param dataMovimentacao the dataMovimentacao to set
     */
    public void setDataMovimentacao(Date dataMovimentacao) {
        this.dataMovimentacao = dataMovimentacao;
    }

    /**
     * @return the destinoMovimentacao
     */
    public String getDestinoMovimentacao() {
        return destinoMovimentacao;
    }

    /**
     * @param destinoMovimentacao the destinoMovimentacao to set
     */
    public void setDestinoMovimentacao(String destinoMovimentacao) {
        this.destinoMovimentacao = destinoMovimentacao;
    }

    /**
     * @return the dataDevolucao
     */
    public Date getDataDevolucao() {
        return dataDevolucao;
    }

    /**
     * @param dataDevolucao the dataDevolucao to set
     */
    public void setDataDevolucao(Date dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    /**
     * @return the qtdMovimentacao
     */
    public int getQtdMovimentacao() {
        return qtdMovimentacao;
    }

    /**
     * @param qtdMovimentacao the qtdMovimentacao to set
     */
    public void setQtdMovimentacao(int qtdMovimentacao) {
        this.qtdMovimentacao = qtdMovimentacao;
    }

    /**
     * @return the descricaoMovimentacao
     */
    public String getDescricaoMovimentacao() {
        return descricaoMovimentacao;
    }

    /**
     * @param descricaoMovimentacao the descricaoMovimentacao to set
     */
    public void setDescricaoMovimentacao(String descricaoMovimentacao) {
        this.descricaoMovimentacao = descricaoMovimentacao;
    }

    /**
     * @return the FKproduto
     */
    public int getFKproduto() {
        return FKproduto;
    }

    /**
     * @param FKproduto the FKproduto to set
     */
    public void setFKproduto(int FKproduto) {
        this.FKproduto = FKproduto;
    }

    /**
     * @return the FKpessoa
     */
    public int getFKpessoa() {
        return FKpessoa;
    }

    /**
     * @param FKpessoa the FKpessoa to set
     */
    public void setFKpessoa(int FKpessoa) {
        this.FKpessoa = FKpessoa;
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

    /**
     * @return the tempProduto
     */
    public String getTempProduto() {
        return tempProduto;
    }

    /**
     * @param tempProduto the tempProduto to set
     */
    public void setTempProduto(String tempProduto) {
        this.tempProduto = tempProduto;
    }

    /**
     * @return the temPessoa
     */
    public String getTemPessoa() {
        return temPessoa;
    }

    /**
     * @param temPessoa the temPessoa to set
     */
    public void setTemPessoa(String temPessoa) {
        this.temPessoa = temPessoa;
    }

    /**
     * @return the situacao
     */
    public String getSituacao() {
        return situacao;
    }

    /**
     * @param situacao the situacao to set
     */
    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    /**
     * @return the dataMovimentacaoSTR
     */
    public String getDataMovimentacaoSTR() {
        return dataMovimentacaoSTR;
    }

    /**
     * @param dataMovimentacaoSTR the dataMovimentacaoSTR to set
     */
    public void setDataMovimentacaoSTR(String dataMovimentacaoSTR) {
        this.dataMovimentacaoSTR = dataMovimentacaoSTR;
    }

    /**
     * @return the dataDevolucaoSTR
     */
    public String getDataDevolucaoSTR() {
        return dataDevolucaoSTR;
    }

    /**
     * @param dataDevolucaoSTR the dataDevolucaoSTR to set
     */
    public void setDataDevolucaoSTR(String dataDevolucaoSTR) {
        this.dataDevolucaoSTR = dataDevolucaoSTR;
    }



}
