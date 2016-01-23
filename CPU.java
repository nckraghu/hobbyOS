import java.util.Random;

public class CPU
{
   private int numCores;
   private Process currentProcess;
   Random random;

   public CPU()
   {
     numCores = 1;
     random = new Random(System.currentTimeMillis());
   }

   public boolean switchContext(Process process)
   {

     currentProcess = process;
     return true;
   }

   public boolean runProcess()
   {
      //currentProcess;
     int counter = 0;
     int max_count = random.nextInt(20);

     while (counter < max_count)
     {
       try
       {

         Thread.sleep(100);
       }
       catch(InterruptedException ie)
       {
         //Do nothing
       }

       boolean done = currentProcess.executeInstruction();

       if (done == true)
       {
         return true;
       }

       counter++;
     }

     return false;
   }

}
