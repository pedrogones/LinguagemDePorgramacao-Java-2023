import java.time.Instant;
class L1C2 extends Thread{
    public int aa, bb, cc, dd, cont;
    public L1C2(int mA[][], int mB[][], int x, int y, int count){
       cont = count;
        //variavel count conta o numero de execucoes, respectivamente cada execução é uma posição diferente da matriz
       if(count==0){
        aa=mA[x][x];
        bb=mB[x][x];
        cc=mA[x][y];
        dd=mB[y][x];
       }else if(count == 1){
        aa=mA[x][x];
        bb=mB[x][y];
        cc=mA[x][y];
        dd=mB[y][y];
       }
       else if(count == 2){
        aa=mA[y][x];
        bb=mB[x][x];
        cc=mA[y][y];
        dd=mB[y][x];
       }else{
        aa=mA[y][x];
        bb=mB[x][y];
        cc=mA[y][y];
        dd=mB[y][y];
       }
    }
       public void run(){
        int soma;
        soma = aa*bb+cc*dd;
        System.out.print("THREAD "+cont+"["+soma+"]");
        System.out.println();
        }
}
public class MultipliComThread{
    public static void main(String[] args) {
        int[][] mA= new int[2][2];
        int[][] mB= new int[2][2];
         for (int i = 0; i <mA.length; i++) {
            for (int j = 0; j <mB.length; j++) {
                mA[i][j]=(int) (Math.random() * 30);
                mB[i][j]= (int) (Math.random() * 30); 
            }
        }
        int count = 0;
        L1C2 t1 = new L1C2(mA, mB, 0, 1, count);
        System.out.println("=");
        //instanciando os threds:
        /*for (int i = 0; i < mB.length; i++) {
            for (int j = 0; j < mB.length; j++) {
                System.out.print("ma=["+mA[i][j]+"]");
            }System.out.println();
        }
        for (int i = 0; i < mB.length; i++) {
            for (int j = 0; j < mB.length; j++) {
                System.out.print("mb=["+mB[i][j]+"]");
            }
            System.out.println();
        }
        */
        Long start = Instant.now().toEpochMilli();
        t1.start(); 
        try {
            t1.join();   
        } catch (Exception e) {
            // TODO: handle exception
        }count++;
        L1C2 t2 = new L1C2(mA, mB, 0, 1, count);
        t2.start();
        try {
            t2.join();   
        } catch (Exception e) {
            // TODO: handle exception
        }count++;
        L1C2 t3 = new L1C2(mA, mB, 0, 1, count);
        t3.start();
        try {
            t3.join();   
        } catch (Exception e) {
            // TODO: handle exception
        }count++;
        L1C2 t4 = new L1C2(mA, mB, 0, 1, count);
        t4.start();
        try {
            t4.join();   
        } catch (Exception e) {
            // TODO: handle exception
        }count++;
    long endTime = Instant.now().toEpochMilli();
    long timeElapsed = endTime - start;
    System.out.println("Execution time in milliseconds: " + timeElapsed);
    System.out.println();
      }
}
