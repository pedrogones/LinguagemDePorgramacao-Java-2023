public class Demo{
    public static void main(String[] args) {
        MyRunnable t = new MyRunnable("Olá");
        MyRunnable t2 = new MyRunnable("Opa");
        Thread y = new Thread(t2);
        Thread r = new Thread(t);
        r.start();
        while(r.isAlive()); //whilw (isAlive()) é usado para certificar que o proximo processo aconteça quando a ultiima thread acabar
        
        y.start();
    }
}
