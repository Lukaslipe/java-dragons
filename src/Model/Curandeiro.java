package Model;

public class Curandeiro extends Personagem {

    protected int cura;

    public Curandeiro(String nome, int vida, int nivel, int cura) {
        super(nome, vida, nivel);
        this.cura = cura;
    }

    @Override
    public boolean estaVivo() {
        return vida > 0;
    }

    public void curar(Heroi heroi) {
        heroi.receberCura(cura);
    }
}
