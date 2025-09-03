public abstract class Personagem {
    protected String nome;
    protected int vida;
    protected int nivel;

    // Construtor
    public Personagem(String nome, int vida, int nivel) {
        this.nome   = nome;
        this.vida   = vida;
        this.nivel  = nivel;
    }

    // Verifica se o personagem ainda está vivo
    public abstract boolean estaVivo();

    // Getters simples
    public String getNome() {
        return nome;
    }

    public int getVida() {
        return vida;
    }

}