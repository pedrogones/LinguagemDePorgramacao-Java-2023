public class Semap extends Thread {
	int id;
	public Semap(int id){this.id = id;}
	public void run(){
		switch(id){
			case 0: case 1: OperA(id); break;
			case 2: case 3: OperB(id); break;
		}
	}
	public synchronized void OperA(int i){
		System.out.print(i); System.out.print(i);
	}
	public synchronized void OperB(int i){
		System.out.print(i); System.out.print(i);
	}
	public static void main (String[] args){
		for(int i=0;i<4;i++)
			(new Semap(i)).start();
		}
	}