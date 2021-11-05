package view;

public class Utilitarios {

    public static String PadraoBR(String Data) {
        String[] numeros = Data.split("-");       
        return numeros[2] + "/" + numeros[1] + "/" + numeros[0];
    }

    public static String retornarPadraoUS(String dataOcorrencia) {
        String numeros[] = dataOcorrencia.split("/");
        return numeros[2] + "-" + numeros[1] + "-" + numeros[0];
    }

}
