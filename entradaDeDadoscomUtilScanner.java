
//import java.io.*;
import java.util.Scanner;
public class entradaDeDadoscomUtilScanner {
        public static void main(String[] args) {
            int num;
            Scanner sc;
            try{
                System.out.println("qual sua potuação: ");
                sc=new Scanner(System.in);
                num=sc.nextInt();
                
                if(num>=700){
                    System.out.print("Vc passou");
                }else if((num<700)&&(num>=600)){
                    System.out.print("quase lá");
                }   
                else{
                    System.out.print("Nao foi dessa vez");
                }
            } catch(NumberFormatException erro){
                System.out.println("Houve um erro na conversão, digite apenas caractere numericos "+erro.toString());

            }
    }
}
