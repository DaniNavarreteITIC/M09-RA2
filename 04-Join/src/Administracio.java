public class Administracio {
    private int num_poblacio_activa = 50;
    private Treballador[] poblacioActiva;

    public Administracio() {
        poblacioActiva = new Treballador[num_poblacio_activa];
        for (int i = 0; i < num_poblacio_activa; i++) {
            poblacioActiva[i] = new Treballador("Ciutadà-" + i, 25000.0f, 20, 65);
        }
    }

    public void iniciarSimulacio() {
        for(int i = 0; i < num_poblacio_activa; i++) {
            poblacioActiva[i].start();
        }
        for (int i = 0; i < num_poblacio_activa; i++) {
            try {
                poblacioActiva[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        for (int i = 0; i < num_poblacio_activa; i++) {
            System.out.printf("%s -> edat: %d / total: %.2f%n", poblacioActiva[i].getName(), poblacioActiva[i].getEdat(), poblacioActiva[i].getCobrat());
        }
    }

    public static void main(String[] args) {
        Administracio admin = new Administracio();
        admin.iniciarSimulacio();
    }

    
}
