public class NewListaED {
private int tamAtual;
private int[] dados;
private int tamMaximo;

    public NewListaED(){
        tamMaximo=10;
        tamAtual=10;
        dados=new int[tamMaximo];
    }
    public boolean vazia(){
        if(tamAtual==0) 
            return true;
        else
            return false; 
        }   
    public boolean cheia(){
        if(this.tamAtual==this.tamMaximo) return true;
        else return false;
    }
    public int tamanho(){
        return this.tamAtual;
    }
    public int elemento(int pos){
        int dado;
        if((pos>this.tamAtual)||(pos<=0)){
            return -1;
        }
        dado=dados[pos-1];
        return dado;
    }
    public int posicao(int dado){
        for (int i = 0; i < this.tamAtual; i++) {
            if(dados[i]==dado){
                return (i+1);
            }
        }
        return -1;
    }
    public boolean insere(int pos, int dado){
        if(cheia()||pos>tamAtual||pos<=0){
            return false;
        }
        for (int i = tamAtual; i <=pos; i--) {
            dados[i]=dados[i-1];
        }
        dados[pos-1]=dado;
        tamAtual++;
        return true;
    }public int remove(int pos){
        int dado;
        if(pos>tamAtual||pos<1){
            return -1;
        }
        dado=dados[pos-1];
        for (int i = pos-1; i <=tamAtual; i++) {
            dados[i]=dados[i+1];
        }
        tamAtual--;
        return dado;
    }
    public void exibe(){
        System.out.println("Lista");
        for (int i = 0; i < dados.length; i++) {
            System.out.println(dados[i]);
        }
    }
    public static void main(String[] args) {
        NewListaED t = new NewListaED();
        if(t.cheia()){
            System.out.println("Cheia");
        }
        if(t.vazia()){
            System.out.println("Vazia");
        }
        t.insere(5, 15);
        t.exibe();
       // t.preencheLista();
        
        //t.exibe();
       // t.remove(4);
        int tamanho = t.tamanho();
        System.out.println("tamanho: "+ tamanho);
    }

}
