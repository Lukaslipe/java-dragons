package Util;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Log {
    private static BufferedWriter writer;
    private static final DateTimeFormatter dataArquivo = DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss");
    private static final DateTimeFormatter dataMensagem = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    // Inicializa o logger criando um novo arquivo

    public static void iniciar() {
        try {
            String nomeArquivo = "src/logJogo_" + LocalDateTime.now().format(dataArquivo) + ".txt"; // 👈 salva na pasta Logs
            writer = new BufferedWriter(new FileWriter(nomeArquivo, false)); // false = novo arquivo
            registrar("=== Novo jogo iniciado ===");
        } catch (IOException e) {
            System.out.println("Erro ao criar arquivo de log: " + e.getMessage());
        }
    }

    // Registra uma mensagem com data/hora
    public static void registrar(String mensagem) {
        try {
            if (writer != null) {
                String linha = "[" + LocalDateTime.now().format(dataMensagem) + "] " + mensagem;
                writer.write(linha);
                writer.newLine();
                writer.flush();
            }
        } catch (IOException e) {
            System.out.println("Erro ao escrever no log: " + e.getMessage());
        }
    }

    // Fecha o arquivo de log
    public static void fechar() {
        try {
            if (writer != null) {
                registrar("=== Jogo encerrado ===");
                writer.close();
            }
        } catch (IOException e) {
            System.out.println("Erro ao fechar arquivo de log: " + e.getMessage());
        }
    }
}
