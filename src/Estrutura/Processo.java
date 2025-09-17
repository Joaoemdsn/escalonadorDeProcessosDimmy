package Estrutura;

public class Processo {
    private int id;
    private String nome;
    private int prioridade;
    private int ciclosNecessarios;
    private String recursoNecessario;
    private boolean precisaDesbloquear;

    public Processo(int id, String nome, int prioridade, int ciclosNecessarios, String recursoNecessario) {
        this.id = id;
        this.nome = nome;
        this.prioridade = prioridade;
        this.ciclosNecessarios = ciclosNecessarios;
        this.recursoNecessario = recursoNecessario;
        this.precisaDesbloquear = false;
    }

    public int getId() { return id; }
    public String getNome() { return nome; }
    public int getPrioridade() { return prioridade; }
    public int getCiclosNecessarios() { return ciclosNecessarios; }
    public String getRecursoNecessario() { return recursoNecessario; }
    public boolean getPrecisaDesbloquear() { return precisaDesbloquear; }

    public void setCiclosNecessarios(int ciclos) { this.ciclosNecessarios = ciclos; }
    public void setPrecisaDesbloquear(boolean status) { this.precisaDesbloquear = status; }

    @Override
    public String toString() {
        return "P" + id + " (" + nome + ", Prio: " + prioridade + ", Ciclos: " + ciclosNecessarios + ")";
    }
}