//Tanner Knue
//Worker D is a consumer for the third buffer
public class WorkerD extends Thread{
	
	private  ConveyerBelt three;
	
	public WorkerD(ConveyerBelt three){
      this.three = three;
	}
   
	public void run(){
		
		int count = 1;
		Widget widget;
	     
		while (count<=24){
			
			ConveyerBelt.napping();
			//consume the widget from the third buffer
			widget = (Widget)three.remove();
			System.out.println("Worker D is retrieving "+ widget.getName()+ " <handled by A,B,C> from the belt");
			System.out.println("Worker D is working on "+ widget.getName()+"<handled by A,B,C,D>");
			count++;
		}
	}
}