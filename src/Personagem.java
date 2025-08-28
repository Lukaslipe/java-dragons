public abstract class Personagem {
    protected String nome;
    protected int vida;

    // Construtor
    public Personagem(String nome, int vida) {
        this.nome = nome;
        this.vida = vida;
    }

    // Verifica se o personagem ainda está vivo
    public boolean estaVivo() {
        return vida > 0;
    }

    // Recebe dano e reduz a vida
    public void receberDano(int dano) {
        vida -= dano;
        if (vida < 0) vida = 0;
    }

    // Recebe cura e aumenta a vida
    public void receberCura(int cura) {
        vida += cura;
    }

    // Métodos abstratos que subclasses devem implementar
    public abstract void atacar(Personagem alvo);

    // Getters simples
    public String getNome() {
        return nome;
    }

    public int getVida() {
        return vida;
    }
}