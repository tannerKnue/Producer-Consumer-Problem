//Tanner Knue
public class ConveyerBelt  
{     
   public ConveyerBelt()
   {
      // buffer is initially empty
      count = 0;
      in = 0;
      out = 0;
      
      buffer = new Widget[BUFFER_SIZE];
   }

 // producer and consumer will call this to nap
   public static void napping() {
     int sleepTime = (int) (NAP_TIME * Math.random() );
     try { Thread.sleep(sleepTime*1000); }
     catch(InterruptedException e) { }
   }

   public synchronized void enter(Widget widget) {
      while (count == BUFFER_SIZE) {
         try {
            wait();
         }
         catch (InterruptedException e) { }
      }
      
      // add an item to the buffer
      ++count;
      buffer[in] = widget;
      in = (in + 1) % BUFFER_SIZE;

	if (count == BUFFER_SIZE) {
		if(widget.getCount() == 0)
			System.out.println("WARNING: worker A is waiting to put "+ widget.getName()+ "<handled by A> on conveyer");
		else if(widget.getCount() == 1)
			System.out.println("WARNING: worker B is waiting to put "+ widget.getName()+ "<handled by A,B> on conveyer");
		else if (widget.getCount() == 2)
			System.out.println("WARNING: worker C is waiting to put "+ widget.getName()+ "<handled by A,B,C> on conveyer");
	}
	else
		//System.out.println("Producer Entered " + widget + " Buffer Size = " +  count);
      
      notify();
   }
   
   // consumer calls this method
   public synchronized Widget remove() {
      Widget widget;
      
      while (count == 0) {
         try {
            wait();
         }
         catch (InterruptedException e) { }
      }
      
      // remove an item from the buffer
      --count;
      widget = buffer[out];
      out = (out + 1) % BUFFER_SIZE;
      
	if (count == 0)
		if(widget.getCount() == 0)
			System.out.println("WARNING: worker B is idle!");
		else if(widget.getCount() == 1)
			System.out.println("WARNING: worker C is idle!");
		else if (widget.getCount() == 2)
			System.out.println("WARNING: worker D is idle!");
	else
		//System.out.println("Consumer Consumed " + widget + " Buffer Size = " + count);

      notify();
      
      return widget;
   }
   
   public static final int    NAP_TIME = 5;
   private static final int   BUFFER_SIZE = 5;
    
   private int count; // number of items in the buffer
   private int in;   // points to the next free position in the buffer
   private int out;  // points to the next full position in the buffer
   private Widget[] buffer;
}
