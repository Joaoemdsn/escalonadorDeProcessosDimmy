package Scheduler;
import model.Processo;
import scheduler.Scheduler;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main (String[] args) {
        Scheduler scheduler = new Scheduler();

        try (BufferedReader br = new BufferedReader(new FileReader(filename:"processos.txt"))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                if (linha.trim().isEmpty() || linha.starsWith(prefix:"#")) continue; // Código para ignorar linhas vazias ou comentários
                String[] partes = linha.split(regex:";");
                String nome = partes [1];
                int prioridade = Integer.parseInt(partes[2]);
                int ciclos = Integer.parseInt(partes[3]);
                String recurso = partes[4];

                Processo p = new Processo(id, nome, prioridade, ciclos, recurso);
                scheduler.adicionarProcesso(p);
            }
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo processos: " + e.getMessage());
            return;
        }

        //Execução de ciclos até todos os processos acabarem
        for (int i = 0; i < 20; i++) { // Ajuste dependendo do que for necessário para os processos.
            scheduler.executarCiclosDeCPU
        }
    }
}
