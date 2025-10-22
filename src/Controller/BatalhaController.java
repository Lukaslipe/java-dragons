package Controller;

import Model.Batalha;
import View.BatalhaView;

import java.util.Scanner;

public class BatalhaController {
    private Scanner scanner = new Scanner(System.in);
    private Batalha batalha;
    private BatalhaView view = new BatalhaView();

    public BatalhaController(Batalha batalha) {
        this.batalha = batalha;
    }

    public boolean iniciar() {
        view.mostrarMensagem("A batalha começou contra " + batalha.getInimigo().getNome() + "!");

        while (!batalha.terminou()) {
            view.mostrarStatus(batalha);
            view.mostrarMenu();

            int escolha = scanner.nextInt();
            if (!batalha.turnoHeroi(escolha)) {
                view.mostrarMensagem("Você fugiu da batalha!");
                return false;
            }

            if (batalha.getInimigo().getVida() <= 0) {
                view.mostrarMensagem("✅ Você derrotou " + batalha.getInimigo().getNome() + "!");
                return true;
            }

            batalha.turnoInimigo();

            if (batalha.getHeroi().getVida() <= 0) {
                view.mostrarMensagem("Você foi derrotado...");
                return false;
            }
        }
        return false;
    }
}
