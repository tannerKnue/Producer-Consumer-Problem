//Tanner Knue
//Worker B which is a consumer for the first buffer and a producer for the second buffer
public class WorkerB extends Thread{

	private ConveyerBelt one;
	private ConveyerBelt two; 
	
	public WorkerB(ConveyerBelt one, ConveyerBelt two) {
		this.one = one; 
		this.two = two;
	}
	
	public void run(){
		
		int count = 1;
		Widget widget;
   
		while (count<25){
			
			ConveyerBelt.napping();
			//consume the widget from the first buffer
			widget = (Widget)one.remove();
			widget.setCount(2);
			System.out.println("Worker B is retrieving "+ widget.getName()+ " <handled by A> from the belt");
			System.out.println("Worker B is working on "+ widget.getName()+"<handled by A,B>");
			System.out.println("Worker B is placing "+ widget.getName()+"<handled by A,B> on the belt");
			//produce the widget to the second buffer
			two.enter(widget);
			count++;
		}
	}
}
