package Controller;

import Model.Heroi;
import Model.Inventario;
import Model.Item;
import Model.Usavel;
import Util.Log;
import View.InventarioView;

import java.util.Map;

public class InventarioController {
    private Inventario inventario;
    private InventarioView view = new InventarioView();

    public InventarioController(Inventario inventario) {
        this.inventario = inventario;
    }

    public void abrirInventario(Heroi heroi) {
        boolean continuar = true;

        while (continuar) {
            int escolha = view.mostrarInventarioEEscolher(inventario);

            if (escolha == 0) {
                continuar = false;
            } else if (escolha > 0 && escolha <= inventario.getItens().size()) {
                // pega o item pelo índice retornado da view
                Usavel itemSelecionado = (Usavel) inventario.getItens().keySet().toArray()[escolha - 1];

                // usa o item
                itemSelecionado.usar(heroi);
                Log.registrar("O herói usou o item: " + ((Item) itemSelecionado).getNome());

                // diminui a quantidade ou remove se for a última
                Map<Usavel, Integer> mapaItens = inventario.getItens();
                int qtd = mapaItens.get(itemSelecionado);
                if (qtd > 1) {
                    mapaItens.put(itemSelecionado, qtd - 1);
                } else {
                    mapaItens.remove(itemSelecionado);
                }
            } else {
                System.out.println("Opção inválida!");
            }
        }
    }
}