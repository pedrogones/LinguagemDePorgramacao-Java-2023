public class Lista {
    private int tamAtual;
    public int tamMaximo;
    public int lista[];

    public Lista(){
       tamAtual=5;
       tamMaximo=10;
       lista= new int[tamMaximo];
    }
    public void exibeList(){
        for (int i = 0; i < lista.length; i++) {
            System.out.println(lista[i]);
        }
    }
    public boolean verificaListaVazia(){
        if(tamAtual==0) 
        return true;
    else
        return false; 
    }
    public boolean cheia(){
        if(tamAtual==tamMaximo) return true;
        else return false;
    }
    public int inserirElemento(int e, int pos) {
        if(cheia()||pos>tamAtual||pos<=0){
            return -1;
        }
        for (int i=tamAtual; i<=pos; i--) {
            lista[i]=lista[i-1];
        }
        lista[pos-1]=e;
        tamAtual++;
        return lista[pos-1];
    }
    public void retirarElemento(int pos) {
        int dado;
        if(pos>tamAtual||pos<1){
            return ;
        }
        dado=lista[pos-1];
        for (int i = pos-1; i <tamAtual-1; i++) {
            lista[i]=lista[i+1];
        }
        tamAtual--;
    }
    public int elementInPos(int pos){
        if(pos<=0||verificaListaVazia()){
            return -1;
        }
        int element=-1;
        for (int i = 0; i < lista.length; i++) {
            if(pos==i+1){
               element = lista[i];
            }
        }
        return element;
    }
    public static void main(String[] args) {
        //criando a lista
      Lista lista = new Lista();
      //verificando se está chiea ou/e vazia
      System.out.println(lista.cheia());//ela está cheia mas nao ta vazia
      System.out.println(lista.verificaListaVazia());//els está cheia mas nao ta vazia
      System.out.println();
      //inserindo elementos na nossa lista
      lista.inserirElemento(13,  1);
      lista.inserirElemento(11,  2);
      lista.inserirElemento(132,  3);
      lista.inserirElemento(155,  4);
      System.out.println();  
      lista.exibeList();//metodo para exibir a lista
      System.out.println(); 
     //retorna o elemento contido na posição passada como parametro
      System.out.println(lista.elementInPos(1));  
      System.out.println();
      lista.retirarElemento(2);   
      lista.exibeList();
      System.out.println();
      lista.inserirElemento(345, 5);
      lista.exibeList();
    } 
}
