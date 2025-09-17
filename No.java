package Estrutura;

public class No {
    Processo processo;
    No proximo;

    public No(Processo processo) {
        this.processo = processo;
        this.proximo = null;
    }
}
