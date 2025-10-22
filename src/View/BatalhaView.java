package View;

import Model.Batalha;

public class BatalhaView {
    public void mostrarStatus(Batalha batalha) {
        System.out.println("\nSua vida: " + batalha.getHeroi().getVida());
        System.out.println("Vida do inimigo: " + batalha.getInimigo().getVida());
    }

    public void mostrarMenu() {
        System.out.println("1 - Atacar");
        System.out.println("2 - Defender");
        System.out.println("3 - Fugir");
    }

    public void mostrarMensagem(String msg) {
        System.out.println(msg);
    }
}
