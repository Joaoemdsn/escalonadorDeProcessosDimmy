package model;

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
            novoNo.proximo = head;
        } else {
            tail.proximo = novoNo;
            novoNo.proximo = head;
            tail = novoNo;
        }
    }

    public Processo removerInicio() {
        if (estaVazia()) {
            return null;
        }
        Processo processoRemovido = head.processo;
        if (head == tail) {
            head = null;
            tail = null;
        } else {
            head = head.proximo;
            tail.proximo = head;
        }
        return processoRemovido;
    }

    public void imprimirLista() {
        if (estaVazia()) {
            System.out.println("[Lista Vazia]");
            return;
        }
        No atual = head;
        StringBuilder sb = new StringBuilder();
        do {
            sb.append(atual.processo.toString());
            atual = atual.proximo;
            if (atual != head) {
                sb.append(" -> ");
            }
        } while (atual != head);
        System.out.println(sb.toString());
    }
}