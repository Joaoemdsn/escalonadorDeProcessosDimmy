package model;

public class Processo {
    private int id;
    private String nome;
    private int prioridade;
    private int ciclosNecessarios;
    private String recursoNecessario;
    private Boolean precisaDesbloquear;

    public Processo (int id, String nome, int prioridade, int ciclosNecessarios, String recursoNecessario) {
        this.id = id
        this.nome = nome;
        this.prioridade = prioridade;
        this.ciclosNecessarios  = ciclosNecessarios;
        this.recursoNecessario = recursoNecessario;
        this.precisaDesbloquear = precisaDesbloquear;
    }

    public int getId() { return id; }
    public String getNome() { return nome; }
    public int getPrioridade()
    public int getCiclosNecessarios () { return ciclosNecessarios; }
    public String getRecursoNecessario () { return recursoNecessario; }
    public Boolena getPrecisaDesbloquear () { return precisaDesbloquear;}

    public void setCiclosNecessarios (int ciclos) { this.ciclosNecessarios = ciclos; }
    public void setPrecisaDesbloquear (boolean status) { this.precisaDesbloquear = status; }

    @Override
    public String toString (){
        return "P" + id + " (" + nome + ", Prio: " + prioridade + ", Ciclos: " + ciclosNecessarios + ")
        ";
    }
}
