public class MyRunnable implements Runnable {
    private String message;
    public MyRunnable(String mString){
        message = mString;
    }
    public void run(){
        for (int i = 0; i < 10; i++) {
            System.out.println(message);    
        }
        
    }
}
