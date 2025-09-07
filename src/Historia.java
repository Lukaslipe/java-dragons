public class Historia {

    public void iniciar(Heroi heroi) {
        System.out.println("Você acorda em uma aldeia em chamas.");
        System.out.println("Um goblin aparece correndo em sua direção!");

        Inimigo goblin = new Inimigo("Goblin", 30, 5, 10, "Monstro");
        Batalha.lutar(heroi, goblin);

        capituloDois(heroi);
    }

    private void capituloDois(Heroi heroi) {
        System.out.println("Após derrotar o goblin, você encontra uma poção.");
        PocaoDeCura pocaoCura = new PocaoDeCura("Poção de cura", "Essa poçao te cura :)", 20);
        heroi.getInventario().adicionarItem(pocaoCura);

        System.out.println("Você segue viagem até a floresta sombria...");
    }
}
