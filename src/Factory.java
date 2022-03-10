//Tanner Knue
public class Factory{
	
	public static void main(String args[]) { 
		
		//create buffers
		ConveyerBelt one = new ConveyerBelt();
		ConveyerBelt two = new ConveyerBelt();
		ConveyerBelt three = new ConveyerBelt();

      		//create the producer and consumer threads
      		WorkerA aThread = new WorkerA(one);
      		WorkerB bThread = new WorkerB(one, two);
      		WorkerC cThread = new WorkerC(two, three);
      		WorkerD dThread = new WorkerD(three);
      		
      		//start threads
      		aThread.start();
      		bThread.start();   
      		cThread.start();
      		dThread.start(); 
      		
      		//end threads
      		try {
      			
      			aThread.join();
          		bThread.join();   
          		cThread.join();
          		dThread.join();
          		
      		}catch (InterruptedException ie) {}
	}
}