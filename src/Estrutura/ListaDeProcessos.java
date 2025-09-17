package Estrutura;

public class ListaDeProcessos {
    private No head;
    private No tail;

    public ListaDeProcessos() {
        this.head = null;
        this.tail = null;
    }

    public boolean estaVazia() {
        return head == null;
    }

    public void adicionarFim(Processo processo) {
        No novoNo = new No(processo);
        if (estaVazia()) {
            head = novoNo;
            tail = novoNo;
        } else {
            tail.proximo = novoNo;
            tail = novoNo;
        }
    }

    public Processo removerInicio() {
        if (estaVazia()) {
            return null;
        }
        Processo processoRemovido = head.processo;
        head = head.proximo;
        if (head == null) {
            tail = null;
        }
        return processoRemovido;
    }

    public void imprimirLista() {
        if (estaVazia()) {
            System.out.print("[Lista Vazia]");
            System.out.println();
            return;
        }
        No atual = head;
        while (atual != null) {
            System.out.print(atual.processo.toString());
            if (atual.proximo != null) {
                System.out.print(" -> ");
            }
            atual = atual.proximo;
        }
        System.out.println();
    }
}