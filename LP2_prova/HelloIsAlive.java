public class HelloIsAlive extends Thread {
    public void run(){
    System.out.println("Olá Mundo");
    }
    public static void main(String[] args) {
    System.out.println("Iniciando...");
    HelloIsAlive t = new HelloIsAlive();
    t.start();
    while(t.isAlive());
    System.out.println("Terminando...");
    }
}
