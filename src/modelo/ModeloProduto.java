package modelo;

import java.util.Date;

public class ModeloProduto {

    private int idProduto;
    private String nomeProduto;
    private int patrimonio;
    private String localizacaoProduto;
    private int qtdEstoque;
    private Date validadeProduto;
    private String descricaoProduto;

    /**
     * @return the idProduto
     */
    public int getIdProduto() {
        return idProduto;
    }

    /**
     * @param idProduto the idProduto to set
     */
    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    /**
     * @return the nomeProduto
     */
    public String getNomeProduto() {
        return nomeProduto;
    }

    /**
     * @param nomeProduto the nomeProduto to set
     */
    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    /**
     * @return the localizacaoProduto
     */
    public String getLocalizacaoProduto() {
        return localizacaoProduto;
    }

    /**
     * @param localizacaoProduto the localizacaoProduto to set
     */
    public void setLocalizacaoProduto(String localizacaoProduto) {
        this.localizacaoProduto = localizacaoProduto;
    }

    /**
     * @return the qtdEstoque
     */
    public int getQtdEstoque() {
        return qtdEstoque;
    }

    /**
     * @param qtdEstoque the qtdEstoque to set
     */
    public void setQtdEstoque(int qtdEstoque) {
        this.qtdEstoque = qtdEstoque;
    }

    /**
     * @return the validadeProduto
     */
    public Date getValidadeProduto() {
        return validadeProduto;
    }

    /**
     * @param validadeProduto the validadeProduto to set
     */
    public void setValidadeProduto(Date validadeProduto) {
        this.validadeProduto = validadeProduto;
    }

    /**
     * @return the descricaoProduto
     */
    public String getDescricaoProduto() {
        return descricaoProduto;
    }

    /**
     * @param descricaoProduto the descricaoProduto to set
     */
    public void setDescricaoProduto(String descricaoProduto) {
        this.descricaoProduto = descricaoProduto;
    }

    @Override
    public String toString() {
        return getNomeProduto(); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * @return the patrimonio
     */
    public int getPatrimonio() {
        return patrimonio;
    }

    /**
     * @param patrimonio the patrimonio to set
     */
    public void setPatrimonio(int patrimonio) {
        this.patrimonio = patrimonio;
    }

}
