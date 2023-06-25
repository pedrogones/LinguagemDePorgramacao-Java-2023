import java.util.Scanner;
public class exercicio_campeonnatobr {
    public static void main(String [] args) {
        int lider, lanterna;
            Scanner sc;
            try{
                System.out.println("quantos pontos tem o time lider: ");
                sc=new Scanner(System.in);
                lider=sc.nextInt();

                System.out.println("Quantos pontos tem o lenterna: ");
                sc=new Scanner(System.in);
                lanterna=sc.nextInt();
                
               int pontosNescessarios=(lider-lanterna)/3;
                System.out.println("O time lanterna precisa de " +pontosNescessarios+ " vitorias para alcançar o time lider");
            } catch(NumberFormatException erro){
                System.out.println("Houve um erro na conversão, digite apenas caractere numericos "+erro.toString());

            }
    }
}
