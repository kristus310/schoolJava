public class Main {
    
    public static void main(String[] args) {

        System.out.println("----------MALÁ NÁSOBILKA----------");
        maláNásobilka();

        System.out.println("\n\n\n");
        
        System.out.println("----------VELKÁ NÁSOBILKA----------");
        velkáNásobilka();
        
    }
    
    public static void maláNásobilka() {
        for(int i = 1; i <= 10; i++) {
            for(int j = 1; j <= 10; j++) {
                System.out.println(i+" * "+j+" = " + i * j);
            }
        }
    }
    
    public static void velkáNásobilka() {
        for(int i = 11; i <= 20; i++) {
            for(int j = 11; j <= 20; j++) {
                System.out.println(i+" * "+j+" = " + i * j);
            }
        }
    }
    
}