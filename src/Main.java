public class Main {
    public static void main(String[] args) {

        Heroi lucas = new Heroi("Lucas", 100, 1, 10, 20, "Espada");

        System.out.println(lucas.getVida());

        Inimigo nino = new Inimigo("Nino", 200, 1, 30, "lobo");

        nino.atacar(lucas);

        System.out.println(lucas.getVida());

        System.out.println(nino.getVida());

        lucas.atacar(nino);

        System.out.println(nino.getVida());

        Curandeiro deus = new Curandeiro("GOD",1000,2000,10);

        deus.curar(lucas);

        System.out.println(lucas.getVida());

    }
}