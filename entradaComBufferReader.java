/* 

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
public class entradaComBufferReader {
    public static void main(String[] args) {
        String s;
        float produto, desconto, v_final;
        BufferedReader dado;
        try{
            System.out.println("Valor do produto: ");
             dado=new BufferedReader(new InputStreamReader(System.in));
             s=dado.readLine();
             produto=Float.parseFloat(s);

             System.out.println("Percentual de desconto do produto: ");
             dado=new BufferedReader(new InputStreamReader(System.in));
             s=dado.readLine();
             desconto=Float.parseFloat(s);
           
             v_final=produto*(desconto/100);

            System.out.println("Desconto: "+ v_final);
            System.out.println("Valor do produto com desconto: " +(produto-v_final));
        } catch(NumberFormatException erro){
            System.out.println("Houve um erro na conversão, digite apenas caractere numericos "+erro.toString());

        }
    }
}
*/