class MyThread extends Thread {
    private int message=0;
    public MyThread(int m, int n) {message = m + n;}
    public void run() {
    for(int r=0; r<10; r++)
    System.out.println(message);
    }
    }
    public class ThreadDemo {
    public static void main(String[] args) {
    MyThread t1,t2;
    t1=new MyThread(4, 7);
    t2=new MyThread(4, 8);
    t1.start();
    t2.start();
    }
    }