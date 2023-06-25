 
public class aula {
  // comentario
  /*comentario de bloco */
  /** comentario de documentação */ 
    public static void main(String[] args){
    char sexo = 'f';
    char conceito= '\u0042';
    int num=5;
    int num2=5;
System.out.println("sexo:" + sexo +"  conceito: " + conceito);//concatenações(+)
System.out.println(num+= ++num);
System.out.println(num2+= num2++);
System.out.println(num2++);
System.out.println(num2);
float imc, altura, peso;
altura=1.75f;
peso=75.3f;
imc=peso/(altura*altura);

System.out.printf("Seu imc é de : %.2f", imc);

int x=1;
int y=2;
System.out.println("");
if(x<y){
    System.out.println("menor");
}else if(x>=y){
    System.out.println("maior ou igual");
}else if(x>y){
    System.out.println("maior");
}else System.out.println("Menor ou igual");



} 
}