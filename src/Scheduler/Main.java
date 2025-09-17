package Scheduler;
import model.Processo;
<<<<<<< HEAD
import Scheduler.Scheduler;
=======
>>>>>>> 3a5e070ba656666a544e66e4a4f847cf86888f75

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
                scheduler.adicionarProcessos(p);
            }
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo processos: " + e.getMessage());
            return;
        }

<<<<<<< HEAD
        while (!scheduler.todosProcessosFinalizados()){
=======
        //Execução de ciclos até todos os processos acabarem
        for (int i = 0; i < 20; i++) { // Ajuste dependendo do que for necessário para os processos.
>>>>>>> 3a5e070ba656666a544e66e4a4f847cf86888f75
            scheduler.executarCiclosDeCPU();
        }
    }
}
