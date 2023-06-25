import java.util.Hashtable;
import javax.naming.Context;
import javax.naming.InitialContext;

public class CalculatorClient {
    public static void main(String[] args) {
    System.setProperty("java.security.policy","E:/Biblioteca/Documentos/AallRmi/Rmi/client.policy");try {
    Hashtable<String, String> env = new Hashtable<String, String>();
    env.put("java.naming.rmi.security.manager", "SecurityManager");
    Context nameContext = new InitialContext(env);
    Calculator calc = (Calculator)
    nameContext.lookup("rmi://127.0.0.1:1099/calculator");
    while (true) {
            System.out.println("123 + 456 = " + calc.add(123,456));
            System.out.println("123 x 456 = " + calc.mul(123,456));
        }      
    }
    catch (Exception e) {
    e.printStackTrace();
    }
    }
    }