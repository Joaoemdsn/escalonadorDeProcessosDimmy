package Scheduler;
import model.Processo;
import Scheduler.Scheduler;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main (String[] args) {
        Scheduler scheduler = new Scheduler();

        try (BufferedReader br = new BufferedReader(new FileReader("C:\\TrabalhoDimmyP1\\escalonadorDeProcessosDimmy\\src\\processos.txt"))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                if (linha.trim().isEmpty() || linha.startsWith("#")) continue; // Código para ignorar linhas vazias ou comentários
                String[] partes = linha.split(";");
                int id = Integer.parseInt(partes[0]);
                String nome = partes [1];
                int prioridade = Integer.parseInt(partes[2]);
                int ciclos = Integer.parseInt(partes[3]);
                String recurso = partes.length > 4 ? partes[4] : "";

                Processo p = new Processo(id, nome, prioridade, ciclos, recurso);
                scheduler.adicionarProcesso(p);
            }
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo processos: " + e.getMessage());
            return;
        }

<<<<<<< HEAD
        while (!scheduler.todosProcessosFinalizados()){
            scheduler.executarCicloDeCPU();
=======
        while (!scheduler.todosProcessosFinalizados()) {
            scheduler.executarCiclosDeCPU();
>>>>>>> 14bbde8b67288f3bde9110a381d177bf736b960b
        }
    }
}
