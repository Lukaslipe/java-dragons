package Model;

public class Heroi extends Personagem {

    protected int xp;
    protected int dano;
    protected String tipoAtaque;
    private Inventario inventario;
    private int vidaMaxima;
    private boolean defendendo = false;

    public Heroi(String nome, int vida, int nivel, int xp, int dano, String tipoAtaque) {
        super(nome, vida, nivel);

        if (vida < 0) {
            throw new IllegalArgumentException("A vida do herói não pode ser negativa!");
        }
        if (xp < 0) {
            throw new IllegalArgumentException("O XP do herói não pode ser negativo!");
        }
        if (dano <= 0) {
            throw new IllegalArgumentException("O dano do herói deve ser maior que zero!");
        }
        if (tipoAtaque == null || tipoAtaque.isBlank()) {
            throw new IllegalArgumentException("O tipo de ataque não pode ser vazio!");
        }

        this.xp = xp;
        this.dano = dano;
        this.tipoAtaque = tipoAtaque;
        this.inventario = new Inventario();
        this.vidaMaxima = vida; // define o máximo inicial igual à vida inicial
    }

    @Override
    public boolean estaVivo() {
        return vida > 0;
    }

    public Inventario getInventario() {
        return inventario;
    }

    public void atacar(Inimigo inimigo) {
        inimigo.receberDano(dano);
    }

    public void ganharXP(int xp) {
        this.xp += xp;
    }

    public void subirNivel() {
        this.nivel += 1;
        this.vidaMaxima += 10;
        this.dano += 2;
        this.vida = vidaMaxima;
        System.out.println("Você subiu para o nível " + nivel + "! Vida restaurada e mais forte!");
    }

    public void receberDano(int danoRecebido) {
        vida -= danoRecebido;
        if (vida < 0) vida = 0;
    }

    public void receberCura(int cura) {
        vida += cura;
        if (vida > vidaMaxima) {
            vida = vidaMaxima;
        }
    }

    public void receberForca(int forca) {
        dano += forca;
    }

    public int getVidaMaxima() {
        return vidaMaxima;
    }

    public int getVida() {
        return vida;
    }

    public int getDano() {
        return dano;
    }

    public int getXp() {
        return xp;
    }

    public String getTipoAtaque() {
        return tipoAtaque;
    }

    public boolean isDefendendo() {
        return defendendo;
    }

    public void setDefendendo(boolean defendendo) {
        this.defendendo = defendendo;
    }
}
