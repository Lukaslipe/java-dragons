package Controller;

import Model.Heroi;
import Model.Inventario;
import Model.Usavel;
import View.InventarioView;

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
                continuar = false; // sair do inventário
            } else if (escolha > 0 && escolha <= inventario.getItens().size()) {
                Usavel item = inventario.getItens().get(escolha - 1);
                item.usar(heroi);
                inventario.getItens().remove(escolha - 1);
            } else {
                System.out.println("Opção inválida!"); // essa ainda poderia ir pra view
            }
        }
    }
}
