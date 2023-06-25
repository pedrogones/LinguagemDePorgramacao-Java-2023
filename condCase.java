import javax.swing.JOptionPane;
public class condCase {
    public static void main() {
        String aux;
        String disciplina;
        try{
           aux=JOptionPane.showInputDialog("qual sua potuação: ");
            disciplina=aux.toUpperCase();
            switch(disciplina){
                case("FISICA"):
                {
                    JOptionPane.showMessageDialog(null,"impossible" );
                }
                case("CALCULO"):
                {
                    JOptionPane.showMessageDialog(null,"MEDIANO" );
                }
                case("LP1"):
                {
                    JOptionPane.showMessageDialog(null,"EASY" );
                }
        }
     } catch(NumberFormatException erro){
            System.out.println("Houve um erro na conversão, digite apenas caractere numericos "+erro.toString());

        }

    }
}
