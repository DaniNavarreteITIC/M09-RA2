public class PrincipalDiferents {
    public static void main(String[] args) {
        Fil pepe = new Fil("Pepe", 2);
        Fil juan = new Fil("Juan", 2);
        
        pepe.setPriority(Thread.MIN_PRIORITY);
        juan.setPriority(Thread.MAX_PRIORITY);
        
        pepe.start();
        juan.start();
        
        System.out.println("Acaba thread main");
    }
}
