import java.util.Random;

public class Motor extends Thread {

    private final int id;
    private int potenciaActual = 0;
    private int potenciaObjectiu = 0;
    private boolean activat = false;
    private boolean finalitzat = false;
    private final Random random = new Random();

    public Motor(int id) {
        this.id = id;
    }

    public synchronized void setPotencia(int p) {
        this.potenciaObjectiu = p;
        if (p > 0) {
            this.activat = true;
        } else if (!this.activat) {
            this.finalitzat = true;
        }
        notifyAll();
    }

    @Override
    public void run() {
        try {
            synchronized (this) {
                while (!activat && !finalitzat) {
                    wait();
                }
            }

            while (!finalitzat) {
                synchronized (this) {
                    while (potenciaActual == potenciaObjectiu && potenciaObjectiu != 0) {
                        wait();
                    }
                }

    
                int tempsResposta = 1000 + random.nextInt(1001);
                Thread.sleep(tempsResposta);

                synchronized (this) {
                    String estat;
                    if (potenciaActual < potenciaObjectiu) {
                        potenciaActual++;
                        estat = (potenciaActual == potenciaObjectiu) ? "FerRes" : "Incre.";
                    } else if (potenciaActual > potenciaObjectiu) {
                        potenciaActual--;
                        estat = (potenciaActual == potenciaObjectiu) ? "FerRes" : "Decre.";
                    } else {
                        estat = "FerRes";
                    }

                    System.out.printf("Motor %d: %s Objectiu: %d Actual: %d%n",
                            id, estat, potenciaObjectiu, potenciaActual);

                    if (potenciaObjectiu == 0 && potenciaActual == 0) {
                        finalitzat = true;
                    }
                }
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}