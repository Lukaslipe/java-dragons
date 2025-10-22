import Controller.HistoriaController;
import Model.Heroi;
import View.HistoriaView;

public class Main {
    public static void main(String[] args) {

        // --- MODELOS ---
        Heroi heroi = null;

        // --- VIEW & CONTROLLER ---
        HistoriaView historiaView = new HistoriaView();
        HistoriaController historiaController = new HistoriaController(historiaView);

        // --- CRIAÇÃO DO HERÓI ---
        try {
            heroi = new Heroi("Lucas", 100, 1, 10, 10, "Espada");
        } catch (IllegalArgumentException e) {
            System.out.println("Erro ao criar herói: " + e.getMessage());
        }

        // --- INÍCIO DO JOGO ---
        if (heroi != null) {
            historiaController.iniciar(heroi); // o controller cuida da lógica da história
        } else {
            System.out.println("❌ Não foi possível iniciar o jogo: herói inválido!");
        }
    }
}
