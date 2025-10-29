package Model;

import Controller.InventarioController;

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
            case 1: // atacar
                heroi.atacar(inimigo);
                System.out.println("Você atacou " + inimigo.getNome() + " causando " + heroi.getDano() + " de dano!");
                break;
            case 2: // defender
                System.out.println("Você se prepara para se defender do próximo ataque!");
                heroi.setDefendendo(true);
                break;
            case 3: // fugir
                System.out.println("Você tentou fugir da batalha!");
                return false;
            default:
                System.out.println("Opção inválida!");
                break;
        }
        return true;
    }

    public void turnoInimigo() {
        if (inimigo.getVida() <= 0) return;

        int danoRecebido = inimigo.getDano();

        if (heroi.isDefendendo()) {
            danoRecebido /= 2;
            System.out.println("Você se defendeu e reduziu o dano recebido!");
            heroi.setDefendendo(false);
        }

        heroi.receberDano(danoRecebido);
        System.out.println(inimigo.getNome() + " atacou e causou " + danoRecebido + " de dano!");
    }

    public boolean terminou() {
        return heroi.getVida() <= 0 || inimigo.getVida() <= 0;
    }
}
