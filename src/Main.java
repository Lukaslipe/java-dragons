import Controller.HistoriaController;
import Model.Heroi;
import View.HistoriaView;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // --- VIEW & CONTROLLER ---
        HistoriaView historiaView = new HistoriaView();
        HistoriaController historiaController = new HistoriaController(historiaView);

        // --- CRIAÇÃO DO HERÓI ---
        System.out.println("Bem-vindo ao RPG!");
        System.out.print("Digite o nome do seu herói: ");
        String nomeHeroi = scanner.nextLine();

        String tipoAtaque = "";
        while (true) {
            System.out.println("Escolha a arma principal do seu herói:");
            System.out.println("1 - Espada");
            System.out.println("2 - Arco e Flecha");
            System.out.print("Digite 1 ou 2: ");
            String escolha = scanner.nextLine();

            if ("1".equals(escolha)) {
                tipoAtaque = "Espada";
                break;
            } else if ("2".equals(escolha)) {
                tipoAtaque = "Arco e Flecha";
                break;
            } else {
                System.out.println("Opção inválida! Digite 1 ou 2.");
            }
        }

        Heroi heroi = null;
        try {
            // Valores padrão
            int vida = 100;
            int nivel = 1;
            int xp = 0;
            int dano = 10;

            heroi = new Heroi(nomeHeroi, vida, nivel, xp, dano, tipoAtaque);
            System.out.println("Herói criado com sucesso! Prepare-se para a aventura, " + nomeHeroi + "!");
        } catch (IllegalArgumentException e) {
            System.out.println("Erro ao criar herói: " + e.getMessage());
        }

        // --- INÍCIO DO JOGO ---
        if (heroi != null) {
            historiaController.iniciar(heroi);
        } else {
            System.out.println("Não foi possível iniciar o jogo: herói inválido!");
        }
        scanner.close();
    }
}