public class PocaoDeForca extends Item implements Usavel {

    private int forca;

    public PocaoDeForca(String nome, String descricao, int dano) {
        super(nome, descricao);
        this.forca = forca;
    }

    public void usar(Heroi heroi) {
        heroi.receberForca(forca);
        System.out.println("Você usou uma Poção de Força e aumentou " + forca + " pontos de força");
    }

}
