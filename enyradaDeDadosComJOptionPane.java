import javax.swing.JOptionPane;
public class enyradaDeDadosComJOptionPane {
    public static void main(String[] args) {

        String aux;
        int dia;
        try{
            aux=JOptionPane.showInputDialog("Digite um numero de 1-7 ");
            dia=Integer.parseInt(aux);
            switch (dia){
                case 1: {
                    JOptionPane.showMessageDialog(null, dia+ "é Domingo!");
                    break;
                } 
               case 2: {
                JOptionPane.showMessageDialog(null, dia+" é Segunda!");
                    break;
                }
                case 3: {
                    JOptionPane.showMessageDialog(null, dia + " é Terça!");
                    break;
                }
                case 4: {
                    JOptionPane.showMessageDialog(null, dia + " é Quarta!");
                    break;
                }
                case 5: {
                    JOptionPane.showMessageDialog(null, dia + " é Quinta!");
                    break;
                }
                case 6: {
                    JOptionPane.showMessageDialog(null, dia + " é Sexta!");
                    break;
                }
                case 7: {
                    JOptionPane.showMessageDialog(null, dia + " é Sabado!");
                    break;
                }
                default: {
                    JOptionPane.showMessageDialog(null, "entrada invalida");
                }
            }
        } catch(NumberFormatException erro){
            JOptionPane.showMessageDialog(null, "Houve um erro na conversão, digite apenas caractere numericos "+erro.toString());

        }
        System.exit(0);
    }
}
