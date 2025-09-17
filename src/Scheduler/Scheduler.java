package Scheduler;

import model.Processo;
import model.ListaDeProcessos;

public class Scheduler {
    private ListaDeProcessos lista_alta_prioridade;
    private ListaDeProcessos lista_media_prioridade;
    private ListaDeProcessos lista_baixa_prioridade;
    private ListaDeProcessos lista_bloqueados;
    private int contador_ciclos_alta_prioridade;


    public Scheduler(){
        this.lista_alta_prioridade = new ListaDeProcessos();
        this.lista_media_prioridade = new ListaDeProcessos();
        this.lista_baixa_prioridade = new ListaDeProcessos();
        this.lista_bloqueados = new ListaDeProcessos();
        this.contador_ciclos_alta_prioridade = 0;
    }

    public void adicionarProcessos (Processo p){
        switch (.getPrioridade()) {
            case 1:
                lista_alta_prioridade.adicionarFim(p);
                break;
            case 2:
                lista_media_prioridade.adicionarFim(p);
                break;
            case 3:
                lista_baixa_prioridade.adicionarFim(p);
                break;
        }
    }

    public void executarCiclosDeCPU(){
        System.out.println("\n--- INICIANDO NOVO CICLO DE CPU ---");

        Processo processoExecutando = null;
        
        if (!lista_bloqueados.estaVazia()) {
            Processo pDesbloqueado = lista_bloqueados.removerInicio();
            System.out.println("EVENTO: Processo " + pDesbloqueado.getNome() + " desbloqueado e retornado a sua lista de prioridade original.");
            switch (pDesbloqueado.getPrioridade()) {
                case 1:
                    lista_alta_prioridade.adicionarFim(pDesbloqueado);
                    break;
                case 2:
                    lista_media_prioridade.adicionarFim(pDesbloqueado);
                    break;
                case 3:
                    lista_baixa_prioridade.adicionarFim(pDesbloqueado);
                    break;
            }
        }

        if (contador_ciclos_alta_prioridade >= 5) {
            System.out.println("REGRA ANTI-INANIÇÃO: Executando um processo de prioridade menor.");
            if (!lista_media_prioridade.estaVazia()) {
                processoExecutando = lista_media_prioridade.removerInicio();
            } else if (!lista_baixa_prioridade.estaVazia()) {
                processoExecutando = lista_baixa_prioridade.removerInicio();
            }
            if (processoExecutando != null) {
                contador_ciclos_alta_prioridade = 0;
            }
        }

        if (processoExecutando == null) {
            if (!lista_alta_prioridade.estaVazia()) {
                processoExecutando = lista_alta_prioridade.removerInicio();
                contador_ciclos_alta_prioridade++;
            } else if (!lista_media_prioridade.estaVazia()) {
                processoExecutando = lista_media_prioridade.removerInicio();
            } else if (!lista_baixa_prioridade.estaVazia()) {
                processoExecutando = lista_baixa_prioridade.removerInicio();
            }
        }
        
}
