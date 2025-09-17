package model;

//Alteração para uma lista circular visando a melhoria do algoritmo do escalonamento

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
            novoNo.proximo = head; // Transforma em uma circularidade, que o professor Dimmy achou melhor
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
            System.out.print("[Lista Vazia]");
            System.out.println();
            return;
        }
        No atual = head;
        do {
            System.out.println(atual.processo.toString());
            atual = atual.proximo;
            if (atual != head) {
                System.out.println(" -> ");
            }
        } while (atual != head);
        System.out.println();
    }
}