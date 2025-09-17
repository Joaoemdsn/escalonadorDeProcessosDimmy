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

    public void adicionarProcesso(Processo p){
        switch (p.getPrioridade()) {
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

    public void executarCicloDeCPU(){
        System.out.println("\n--- iCEV OS ---");

        // 1. Desbloqueia o processo mais antigo, se houver
        Processo desbloqueado = lista_bloqueados.removerInicio();
        if (desbloqueado != null) {
            System.out.println("Desbloqueando: " + desbloqueado.getNome());
            adicionarProcesso(desbloqueado);
        }

        Processo processoExecutado = null;

        // 2. Prevenção de inanição
        if (contador_ciclos_alta_prioridade >= 5) {
            if (!lista_media_prioridade.estaVazia()) {
                processoExecutado = lista_media_prioridade.removerInicio();
                contador_ciclos_alta_prioridade = 0;
            } else if (!lista_baixa_prioridade.estaVazia()) {
                processoExecutado = lista_baixa_prioridade.removerInicio();
                contador_ciclos_alta_prioridade = 0;
            }
        }

        // 3. Execução padrão
        if (processoExecutado == null) {
            if (!lista_alta_prioridade.estaVazia()) {
                processoExecutado = lista_alta_prioridade.removerInicio();
                contador_ciclos_alta_prioridade++;
            } else if (!lista_media_prioridade.estaVazia()) {
                processoExecutado = lista_media_prioridade.removerInicio();
                contador_ciclos_alta_prioridade = 0;
            } else if (!lista_baixa_prioridade.estaVazia()) {
                processoExecutado = lista_baixa_prioridade.removerInicio();
                contador_ciclos_alta_prioridade = 0;
            }
        }

        // 4. Gerenciamento de recursos (bloqueio)
        if (processoExecutado != null && processoExecutado.getRecursoNecessario().equalsIgnoreCase("DISCO") && !processoExecutado.getPrecisaDesbloquear()) {
            processoExecutado.setPrecisaDesbloquear(true);
            lista_bloqueados.adicionarFim(processoExecutado);
            System.out.println("Processo bloqueado por recurso: " + processoExecutado.getNome());
        } else if (processoExecutado != null) {
            // Simulação de execução
            processoExecutado.setCiclosNecessarios(processoExecutado.getCiclosNecessarios() - 1);
            System.out.println("Executando: " + processoExecutado.getNome() + " | Ciclos restantes: " + processoExecutado.getCiclosNecessarios());
            if (processoExecutado.getCiclosNecessarios() <= 0) {
                System.out.println("Processo finalizado: " + processoExecutado.getNome());
            } else {
                adicionarProcesso(processoExecutado);
            }
        }

        // 5. Exibe estado atual
        System.out.print("Alta prioridade: "); lista_alta_prioridade.imprimirLista();
        System.out.print("Média prioridade: "); lista_media_prioridade.imprimirLista();
        System.out.print("Baixa prioridade: "); lista_baixa_prioridade.imprimirLista();
        System.out.print("Bloqueados: "); lista_bloqueados.imprimirLista();
    }

    public boolean todosProcessosFinalizados() {
        return lista_alta_prioridade.estaVazia() &&
               lista_media_prioridade.estaVazia() &&
               lista_baixa_prioridade.estaVazia() &&
               lista_bloqueados.estaVazia();
    }
}