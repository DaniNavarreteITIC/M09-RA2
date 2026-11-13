public class PrincipalEstricte {
    public static void main(String[] args) {
        Fil juan = new Fil("Juan", 3);
        Fil pepe = new Fil("Pepe", 3);

        juan.start();
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        pepe.start();

        System.out.println("Termina thread main");
    }
}