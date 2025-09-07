public class PocaoDeCura extends Item implements Usavel {

    private int cura;

    public PocaoDeCura(String nome, String descricao, int cura){
        super(nome, descricao);
        this.cura = cura;
    }

    public void usar(Heroi heroi) {
        heroi.receberCura(cura);
        System.out.println("Você usou uma Poção de Cura e recuperou " + cura + " de vida!");
    }

}
