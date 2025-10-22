package Model;

public class Batalha {
    private Heroi heroi;
    private Inimigo inimigo;

    public Batalha(Heroi heroi, Inimigo inimigo) {
        this.heroi = heroi;
        this.inimigo = inimigo;
    }

    public Heroi getHeroi() {
        return heroi;
    }

    public Inimigo getInimigo() {
        return inimigo;
    }

    public boolean turnoHeroi(int acao) {
        switch (acao) {
            case 1:
                heroi.atacar(inimigo);
                break;
            case 2:
                // lógica de defesa futura
                break;
            case 3:
                return false; // fugiu
        }
        return true;
    }

    public void turnoInimigo() {
        if (inimigo.getVida() > 0) {
            inimigo.atacar(heroi);
        }
    }

    public boolean terminou() {
        return heroi.getVida() <= 0 || inimigo.getVida() <= 0;
    }
}
