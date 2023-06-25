
import java.util.Scanner;
public class condicinais {
    public static void main(String [] args) {int pontos;
        Scanner sc;
        try{
            System.out.println("qual sua potuação: ");
            sc=new Scanner(System.in);
            pontos=sc.nextInt();
            
            if(pontos>=700){
                System.out.print("Vc passou");
            }else if((pontos<700)&&(pontos>=600)){
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

