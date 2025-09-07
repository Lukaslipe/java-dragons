import java.util.Scanner;

public class Batalha {

    private static Scanner scanner = new Scanner(System.in);

    public static void lutar(Heroi heroi, Inimigo inimigo) {
        System.out.println("A batalha começou contra " + inimigo.getNome() + "!");

        while (heroi.getVida() > 0 && inimigo.getVida() > 0) {
            // Turno do herói
            System.out.println("\nSua vida: " + heroi.getVida());
            System.out.println("Vida do inimigo: " + inimigo.getVida());
            System.out.println("1 - Atacar");
            System.out.println("2 - Defender");
            System.out.println("3 - Fugir");

            int escolha = scanner.nextInt();

            switch (escolha) {
                case 1:
                    heroi.atacar(inimigo);
                    break;
                case 2:
                    System.out.println(heroi.getNome() + " se defende!");
                    // poderia reduzir dano no próximo turno
                    break;
                case 3:
                    System.out.println("Você fugiu da batalha!");
                    return;
                default:
                    System.out.println("Escolha inválida.");
            }

            // Verifica se o inimigo morreu
            if (inimigo.getVida() <= 0) {
                System.out.println("✅ Você derrotou " + inimigo.getNome() + "!");
                break;
            }

            // Turno do inimigo
            inimigo.atacar(heroi);

            // Verifica se o herói morreu
            if (heroi.getVida() <= 0) {
                System.out.println("Você foi derrotado...");
            }
        }
    }
}
