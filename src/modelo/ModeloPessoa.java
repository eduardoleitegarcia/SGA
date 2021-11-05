package modelo;

public class ModeloPessoa {

    private int idPessoa;
    private String nomePessoa;
    private String LoginAdmin;
    private String SenhaAdmin;
    private String Categoria;
    private String nomePessoaTEMP;

    /**
     * @return the idPessoa
     */
    public int getIdPessoa() {
        return idPessoa;
    }

    /**
     * @param idPessoa the idPessoa to set
     */
    public void setIdPessoa(int idPessoa) {
        this.idPessoa = idPessoa;
    }

    /**
     * @return the nomePessoa
     */
    public String getNomePessoa() {
        return nomePessoa;
    }

    /**
     * @param nomePessoa the nomePessoa to set
     */
    public void setNomePessoa(String nomePessoa) {
        this.nomePessoa = nomePessoa;
    }

    /**
     * @return the Categoria
     */
    public String getCategoria() {
        return Categoria;
    }

    /**
     * @param Categoria the Categoria to set
     */
    public void setCategoria(String Categoria) {
        this.Categoria = Categoria;
    }


    @Override
    public String toString() {
        return getNomePessoa(); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * @return the LoginAdmin
     */
    public String getLoginAdmin() {
        return LoginAdmin;
    }

    /**
     * @param LoginAdmin the LoginAdmin to set
     */
    public void setLoginAdmin(String LoginAdmin) {
        this.LoginAdmin = LoginAdmin;
    }

    /**
     * @return the SenhaAdmin
     */
    public String getSenhaAdmin() {
        return SenhaAdmin;
    }

    /**
     * @param SenhaAdmin the SenhaAdmin to set
     */
    public void setSenhaAdmin(String SenhaAdmin) {
        this.SenhaAdmin = SenhaAdmin;
    }

    /**
     * @return the nomePessoaTEMP
     */
    public String getNomePessoaTEMP() {
        return nomePessoaTEMP;
    }

    /**
     * @param nomePessoaTEMP the nomePessoaTEMP to set
     */
    public void setNomePessoaTEMP(String nomePessoaTEMP) {
        this.nomePessoaTEMP = nomePessoaTEMP;
    }

}
