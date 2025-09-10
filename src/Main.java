public class Main {
    public static void main(String[] args) {
        Heroi heroi = null;
        Historia historia = new Historia();
        try {
            heroi = new Heroi("Lucas", 100, 1, 10, 0, "Espada");
        } catch (IllegalArgumentException e) {
            System.out.println("Erro ao criar herói: " + e.getMessage());
        }

        try {
            heroi = new Heroi("Lucas", 100, 1, 10, 10, "Espada");
        } catch (IllegalArgumentException e) {
            System.out.println("Erro ao criar herói: " + e.getMessage());
        }

        Inimigo inimigo = new Inimigo("Dragão", 100, 1, 10,  "Dragão");

        if (heroi != null) {
            historia.iniciar(heroi);
        } else {
            System.out.println("Não foi possível iniciar a batalha, herói inválido!");
        }
    }
}