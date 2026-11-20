import java.util.Random;

public class DormAleatori extends Thread {

    private final long tempsConstruccio;
    private final Random random;

    public DormAleatori(String nom) {
        super(nom);
        this.tempsConstruccio = System.currentTimeMillis();
        this.random = new Random();
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            int intervalAleatori = random.nextInt(1000);
            long tempsTotal = System.currentTimeMillis() - tempsConstruccio;

            System.out.printf("%s (%d) a dormir %dms total %dms%n",
                    getName(), i, intervalAleatori, tempsTotal);

            try {
                Thread.sleep(intervalAleatori);
            } catch (InterruptedException e) {
                System.err.println(getName() + " interromput.");
                Thread.currentThread().interrupt();
                break;
            }
        }
    }

    public static void main(String[] args) {
        DormAleatori joan = new DormAleatori("Joan");
        DormAleatori pep = new DormAleatori("Pep");

        joan.start();
        pep.start();

        System.out.println("Fi de main");
    }
}