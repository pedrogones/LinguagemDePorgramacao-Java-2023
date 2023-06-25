class MyThread extends Thread {
    private String message;
    public MyThread(String m) {
        message = m;
    }
        public void run() {
            for(int r=0; r<10; r++)
            System.out.println(message);
        }
    }
    public class FirstThread {
    public static void main(String[] args) {
    MyThread t1,t2;
    t1=new MyThread("primeiro thread");
    t2=new MyThread("segundo thread");
    t1.start();
    /*
    Dar prioridade ao t1
    try{
        t1.join();
    }catch (Exception e){
    }*/
    t2.start();
    }
    }