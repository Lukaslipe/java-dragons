package View;

import Model.Inventario;
import Model.Usavel;
import Model.Heroi;

import java.util.List;
import java.util.Scanner;

public class InventarioView {
    private Scanner scanner = new Scanner(System.in);
    public int mostrarInventarioEEscolher(Inventario inventario) {
        List<Usavel> itens = inventario.getItens();

        if (itens.isEmpty()) {
            System.out.println("Seu inventário está vazio!");
            return 0; // Voltar
        }

        System.out.println("\n===== INVENTÁRIO =====");
        for (int i = 0; i < itens.size(); i++) {
            System.out.println((i + 1) + " - " + itens.get(i).getClass().getSimpleName());
        }
        System.out.println("0 - Voltar");
        System.out.println("======================");

        System.out.print("Escolha um item para usar: ");
        int escolha = scanner.nextInt();
        return escolha;
    }

    // Mensagem quando o inventário está vazio
    public void inventarioVazio() {
        System.out.println("Seu inventário está vazio!");
    }
}
