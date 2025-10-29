package View;

import Model.Inventario;
import Model.Usavel;
import java.util.Map;
import java.util.Scanner;

public class InventarioView {
    private Scanner scanner = new Scanner(System.in);

    public int mostrarInventarioEEscolher(Inventario inventario) {
        Map<Usavel, Integer> itens = inventario.getItens();

        if (itens.isEmpty()) {
            System.out.println("Seu inventário está vazio!");
            return 0;
        }

        System.out.println("\n===== INVENTÁRIO =====");

        int i = 1;
        for (Map.Entry<Usavel, Integer> entry : itens.entrySet()) {
            System.out.println(i + " - " + entry.getKey().getClass().getSimpleName() + " x" + entry.getValue());
            i++;
        }

        System.out.println("0 - Voltar");
        System.out.println("======================");

        System.out.print("Escolha um item para usar: ");
        int escolha = scanner.nextInt();
        return escolha;
    }

    public void inventarioVazio() {
        System.out.println("Seu inventário está vazio!");
    }
}