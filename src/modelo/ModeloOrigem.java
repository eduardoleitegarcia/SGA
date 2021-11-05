package modelo;

public class ModeloOrigem {

    private int idOrigem;
    private String nomeOrigem;

    /**
     * @return the nomeOrigem
     */
    public String getNomeOrigem() {
        return nomeOrigem;
    }

    /**
     * @param nomeOrigem the nomeOrigem to set
     */
    public void setNomeOrigem(String nomeOrigem) {
        this.nomeOrigem = nomeOrigem;
    }

    /**
     * @return the idOrigem
     */
    public int getIdOrigem() {
        return idOrigem;
    }

    /**
     * @param idOrigem the idOrigem to set
     */
    public void setIdOrigem(int idOrigem) {
        this.idOrigem = idOrigem;
    }

    @Override
    public String toString() {
        return getNomeOrigem(); //To change body of generated methods, choose Tools | Templates.
    }

}
