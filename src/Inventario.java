import java.util.ArrayList;
import java.util.List;

public class Inventario {
    private List<Usavel> itens = new ArrayList<>();

    public void adicionarItem(Usavel item) {
        itens.add(item);
    }

    public void usarItem(int indice, Heroi heroi) {
        if (indice >= 0 && indice < itens.size()) {
            Usavel item = itens.get(indice);
            item.usar(heroi);
            itens.remove(indice);
        }
    }

    public void listarItens() {
        for (int i = 0; i < itens.size(); i++) {
            System.out.println(i + " - " + itens.get(i).getClass().getSimpleName());
        }
    }
}
