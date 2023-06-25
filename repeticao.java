
import java.util.Scanner;
public class repeticao {
    public static void main(String[] args) {
        float nota, nota2;
        float media;
        Scanner sc;
        try{
            do{
                System.out.println("Primeira nota: ");
                sc=new Scanner(System.in);       
                nota=sc.nextFloat();
                System.out.println("Segunda nota: ");
                nota2=sc.nextFloat();
                media=(nota+nota2)/2;
                System.out.println("Media: "+ media);
             }
             while(nota!=0&&nota2!=0);
            }
        catch(NumberFormatException erro){
            System.out.println("ERROR");
        }
    }
}
