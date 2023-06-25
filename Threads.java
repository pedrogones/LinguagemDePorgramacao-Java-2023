public class Threads extends Thread {
    public int a=1, b=2, c=3;
    public Threads(){
    }
        public void run() {
            System.out.println(a=b+1);
            System.out.println(c=a+b);
            System.out.println(b=2*c);        
        }
    
    public static void main(String[] args) {
        Threads t = new Threads();
        Threads t2 = new Threads();
        Threads t3= new Threads();
        t.start();
        t2.start();
        t3.start();

    }
}
