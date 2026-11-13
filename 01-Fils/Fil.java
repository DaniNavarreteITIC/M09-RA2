public class Fil extends Thread {
    private int comportament;

    public Fil(String name, int comportament) {
        super(name);
        this.comportament = comportament;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 9; i++) {
            System.out.println(getName() + " " + i);

            if (comportament == 1 || comportament == 2) {
                for (int j = 0; j < 1000; j++) {
                    Math.pow(i, j);
                }
            } else if (comportament == 3) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }

        if (comportament == 3) {
            System.out.println("Termina el fil " + getName());
        } else {
            System.out.println("Acaba el fil " + getName());
        }
    }
}