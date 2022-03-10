//Tanner Knue
//Worker A which is a producer to the first buffer
public class WorkerA extends Thread{
	
	private  ConveyerBelt one;
	
	public WorkerA(ConveyerBelt one) {
		this.one = one;
	}
	
	public void run(){
	   
		int count = 1;
		Widget widget;
	     
		while (count<25){
			
			ConveyerBelt.napping();
			//produce the widget to the first buffer
			widget = new Widget(("widget" + count),0);
			System.out.println("Worker A is working on "+ widget.getName() + "<handled by A>");
			System.out.println("Worker A is placing "+ widget.getName() + " on the belt");
			one.enter(widget);
			count++; 
			
	   }
	}	   
}
