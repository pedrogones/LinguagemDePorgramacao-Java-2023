import java.time.Instant;
public class MultiplicaMatriz{
    
    public static void main(String[] args) {
        Long start = Instant.now().toEpochMilli();
        int[][] mA=new int [2][2], mB=new int [2][2], mC=new int [2][2];
       for (int i = 0; i < mC.length; i++) {
           for (int j = 0; j < mC.length; j++) {
               mA[i][j]=  (int) (Math.random() * 30);
               mB[i][j]=  (int) (Math.random() * 30);;
           }
       }
       for (int i = 0; i < mC.length; i++) {
           for (int j = 0; j < mC.length; j++) {
               System.out.print("["+mA[i][j]+"]");
           }
           System.out.println();
       }
       System.out.println("X");
       for (int i = 0; i < mC.length; i++) {
           for (int j = 0; j < mC.length; j++) {
               System.out.print("["+mB[i][j]+"]");
           }
           System.out.println();
       }
       System.out.println("=");
       for (int i = 0; i < 2; i++) {
           for (int j = 0; j < 2; j++) {
               int soma=0;
               for (int k = 0; k < 2; k++) {
                   soma+=mA[i][k]*mB[k][j];
               }
               mC[i][j]=soma;
               System.out.print("["+soma+"]");
           }
           System.out.println();
       }
       long endTime = Instant.now().toEpochMilli();
       long timeElapsed = endTime - start;
       System.out.println("Execution time in milliseconds: " + timeElapsed);
    }
}