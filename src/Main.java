public class Main {
    public static void main(String[] args) {

        try {
            Heroi heroi = new Heroi("Lucas", 100, 1, 10, 0, "Espada");
        } catch (IllegalArgumentException e) {
            System.out.println("Erro ao criar herói: " + e.getMessage());
        }


    }
}