public class DadosThreads extends Thread {
    public void run(){
        Thread t = new Thread();
        t.currentThread();
        System.out.println("In global scop:\n"+t.getName()+": "+t.getId());
    }
    public static void main(String[] args) {
        Thread m = new Thread();
        m.currentThread();
        for (int i = 0; i <10 ; --i) {
            DadosThreads t = new DadosThreads();
            t.start();
            while(t.isAlive());
            System.out.println("In main:\n"+m.getName()+": "+m.getId());
    }
    }
}
