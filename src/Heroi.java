public class Heroi extends Personagem{

    protected int xp;
    protected int dano;
    protected String tipoAtaque;
    private Inventario inventario;


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
