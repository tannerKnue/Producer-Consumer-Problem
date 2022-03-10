//Tanner Knue
//Worker C which is a consumer for the second buffer and a producer for the third buffer
public class WorkerC extends Thread{

	private ConveyerBelt two;
	private ConveyerBelt three; 
	
	public WorkerC(ConveyerBelt two, ConveyerBelt three) {
		this.two = two;
		this.three = three; 
	}
	
	public void run(){
		
		Widget widget;
		int count = 1;
   
		while (count<25){
			
			ConveyerBelt.napping();
			//consume the widget from the second buffer
			widget = (Widget)two.remove();
			widget.setCount(3);
			System.out.println("Worker C is retrieving "+ widget.getName()+ " <handled by A,B> from the belt");
			System.out.println("Worker C is working on "+ widget.getName()+"<handled by A,B,C>");
			System.out.println("Worker C is placing "+ widget.getName()+"<handled by A,B,C> on the belt");
			//produce the widget to the third buffer
			three.enter(widget);
			count++;
		}
	}
}
