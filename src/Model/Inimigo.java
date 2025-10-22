package Model;

public class Inimigo extends Personagem {

    protected int dano;
    protected String tipo;

    public Inimigo(String nome, int vida, int nivel, int dano, String tipo) {
        super(nome, vida, nivel);
        this.dano = dano;
        this.tipo = tipo;
    }

    @Override
    public boolean estaVivo() {
        return vida > 0;
    }

    public void atacar(Heroi heroi) {
        heroi.receberDano(dano);
    }

    public void receberDano(int dano) {
        vida -= dano;
        if (vida < 0) vida = 0;
    }
}
