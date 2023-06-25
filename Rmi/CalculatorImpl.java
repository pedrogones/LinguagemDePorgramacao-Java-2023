import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;


public class CalculatorImpl extends UnicastRemoteObject implements Calculator {
    protected CalculatorImpl() throws RemoteException {super();
}
public int add(int a, int b) throws RemoteException {return a+b;
}

public int div(int a, int b) throws RemoteException {return a/b;
}
public int sub(int a, int b) throws RemoteException {return a-b;
}

public int mul(int a, int b) throws RemoteException {return a*b;
}
} 