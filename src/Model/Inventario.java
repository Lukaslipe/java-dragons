package Model;

import java.util.HashMap;
import java.util.Map;

public class Inventario {
    private Map<Usavel, Integer> itens = new HashMap<>();

    public void adicionarItem(Usavel item) {
        itens.put(item, itens.getOrDefault(item, 0) + 1);
    }

    public Map<Usavel, Integer> getItens() {
        return itens;
    }
}
