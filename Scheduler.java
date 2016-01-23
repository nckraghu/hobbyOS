import java.util.Vector;

public class Scheduler
{

 Vector<Process> processPool;

 CPU cpu;

 public Scheduler(CPU cpu)
 {
   System.out.println("setting cpu");
   processPool = new Vector<Process>();
   this.cpu = cpu;
 }

 public void addProcess(Process process)
 {
     processPool.add(process);
     System.out.println("pool size : "+processPool.size());
 }

 public void start()
 {
   System.out.println("Starting process scheduler");
   int count = 0;
   System.out.println("pool size : "+processPool.size());
   while(processPool.size() > 0 && count < 3)
   {
     System.out.println("Scheduler looping");
     Process process = processPool.firstElement();
     processPool.remove(0);


     cpu.switchContext(process);
     boolean ret = cpu.runProcess();

     if (ret != true)
     {
         processPool.add(process);
     }

     count++;

   }
 }
}
