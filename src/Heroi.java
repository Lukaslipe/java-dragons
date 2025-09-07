public class Heroi extends Personagem{

    protected int xp;
    protected int dano;
    protected String tipoAtaque;

    public Heroi(String nome, int vida, int nivel, int xp, int dano, String tipoAtaque) {
        super(nome, vida, nivel);
        this.xp = xp;
        this.dano = dano;
        this.tipoAtaque = tipoAtaque;
    }

    @Override
    public boolean estaVivo() {
        return vida > 0;
    }

    public void atacar(Inimigo inimigo) {
        inimigo.receberDano(dano);
    }

    public void ganharXP(int xp){
        this.xp += xp;
    }

    public void subirNivel(){
        this.nivel += 1;
    }

    public void receberDano(int dano_recebido) {
        vida -= dano_recebido;
        if (vida < 0) vida = 0;
    }

    public void receberCura(int cura) {
        vida += cura;
    }

    public void receberForca(int forca) {
        dano += forca;
    }
}
