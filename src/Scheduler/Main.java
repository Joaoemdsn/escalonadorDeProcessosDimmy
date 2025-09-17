package Scheduler;
import model.Processo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main (String[] args) {
        Scheduler scheduler = new Scheduler();

        try (BufferedReader br = new BufferedReader(new FileReader("processos.txt"))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                if (linha.trim().isEmpty() || linha.startsWith("#")) continue;
                String[] partes = linha.split(";");
                if (partes.length < 4) {
                    System.out.println("Linha ignorada (formato inválido): " + linha);
                    continue;
                }
                int id, prioridade, ciclos;
                try {
                    id = Integer.parseInt(partes[0]);
                    prioridade = Integer.parseInt(partes[2]);
                    ciclos = Integer.parseInt(partes[3]);
                } catch (NumberFormatException e) {
                    System.out.println("Linha ignorada (erro de número): " + linha);
                    continue;
                }
                String nome = partes[1];
                String recurso = partes.length > 4 ? partes[4] : "";

                Processo p = new Processo(id, nome, prioridade, ciclos, recurso);
                scheduler.adicionarProcesso(p);
            }
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo processos: " + e.getMessage());
            return;
        }

        // Executa ciclos até todos os processos acabarem
        while (!scheduler.todosProcessosFinalizados()) {
            scheduler.executarCicloDeCPU();
        }
    }
}