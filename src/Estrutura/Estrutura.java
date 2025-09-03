package Estrutura; //

public class Estrutura {
    private int id;
    private String nome;
    private int prioridade; // 1-Alta, 2-Média, 3-Baixa
    private int ciclos_Necessarios; // Quantum de ciclos necessários para completar o processo
    private String recurso_Necessario; // pode ser nulo

    public Estrutura(int id, String nome, int prioridade, int ciclos_Necessarios, String recurso_Necessario) {

    this.id = id;
    this.nome = nome;
    this.prioridade = prioridade;
    this.ciclos_Necessarios = ciclos_Necessarios;
    this.recurso_Necessario = recurso_Necessario;

    }

    public int getId() {
        return id;
    }

    public void setId (int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome (String nome){
        this.nome = nome;
    }

    public int getPrioridade() {
        return prioridade;
    }

    public void setPrioridade (int prioridade) {
        this.prioridade = prioridade;
    }

    public int getCiclos_Necessarios() {
        return ciclos_Necessarios;
    }

    public void setCiclos_Necessarios (int ciclos_Necessarios) {
        this.ciclos_Necessarios = ciclos_Necessarios;
    }

    public String getRecurso_Necessario() {
        return recurso_Necessario;
    }

    public void setRecursos_Necessarios (String recurso_Necessario) {
        this.recurso_Necessario = recurso_Necessario;
    }
}