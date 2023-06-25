import java.util.Locale;//usado para exibir valores do tipo float com pontos ao inves de virgulas
public class gastosEmpresarial {
    public static void main(String[] args) {
        float janeiro=15000f, fevereio=23000f, marco=17000f ;
        Locale.setDefault(Locale.US);//usado para exibir valores do tipo float com pontos ao inves de virgulas
        System.out.println("Total de Gastos no trimestre: "+(janeiro+fevereio+marco));//com quebra de linha 
        System.out.print("Media de gastos, por mês, no trimestre: "+(janeiro+fevereio+marco)/3); //sem quebra de linha
       
    }
}
