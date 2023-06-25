public class PriorityThread  extends Thread {
    private String message;
    public PriorityThread( String s){
        message = s;
    }
    public void run() {
        System.out.println("Iniciando...");
        for (int i = 0; i <5; i++) {
            for (int j = 0; j<5; j++) {
                for (int j2 = 0; j2 <5; j2++) {
                    System.out.println("Terminando... "+ message +" Nº "+j2);
                }
            }
        }
    }
    public static void main(String[] args) {
        PriorityThread t = new PriorityThread("processo pedro krl");
        PriorityThread t2 = new PriorityThread("processo Pedro Gomes");
        t.setPriority(10);//maior prioridade em tempo pra executar
        t2.setPriority(1);//menor prioridade em tempo pra executar
        t.start();
        t2.start();

    }
}
