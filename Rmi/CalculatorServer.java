import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import javax.naming.Context;
import javax.naming.InitialContext;

public class CalculatorServer {
    public static void main(String[] args) {
    try {
    LocateRegistry.createRegistry(Registry.REGISTRY_PORT);
    CalculatorImpl calc = new CalculatorImpl();
    Context nameContext = new InitialContext();
    nameContext.rebind("rmi://127.0.0.1:1099/calculator", calc);}
    catch (Exception e) {
    e.printStackTrace();
    }
    }
    }