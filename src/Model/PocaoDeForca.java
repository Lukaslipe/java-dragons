package Model;

public class PocaoDeForca extends Item implements Usavel {

    private int forca;

    public PocaoDeForca(String nome, String descricao, int forca) {
        super(nome, descricao);
        this.forca = forca;
    }

    @Override
    public void usar(Heroi heroi) {
        heroi.receberForca(forca);
        System.out.println("Você usou uma Poção de Força e aumentou " + forca + " pontos de força!");
        System.out.println("Dano atual do herói: " + heroi.getDano());
    }
}
