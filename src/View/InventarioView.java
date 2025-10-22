package View;

import Model.Inventario;
import Model.Usavel;
import Model.Heroi;

import java.util.List;

public class InventarioView {
    public void mostrarInventario(Inventario inventario) {
        List<Usavel> itens = inventario.getItens();
        for (int i = 0; i < itens.size(); i++) {
            System.out.println(i + " - " + itens.get(i).getClass().getSimpleName());
        }
    }
}
