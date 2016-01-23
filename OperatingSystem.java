import java.util.Scanner;
import java.util.Random;
import java.io.BufferedReader;
import java.io.InputStreamReader;


public class OperatingSystem
{
  private CPU cpu;
  private Scheduler processScheduler;
  private Scanner scanner;
  private int processCount;
  private String [] processArray;
  private Random random;

  public OperatingSystem()
  {

     cpu = new CPU();
     processScheduler = new Scheduler(cpu);
     scanner = new Scanner(System.in);
     processCount = 0;
     processArray = new String[]{"one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten"};
     random = new Random(System.currentTimeMillis());
  }

  public void addProcess(Process process)
  {
    processScheduler.addProcess(process);

  }

  public void executeAll()
  {
    while(true)
    {
      processScheduler.start();

      if (processCount < 10)
      {
        System.out.println("Start a new process? (Y/N)");
        String yesno = waitOnInput();

        if(yesno.equals("Y"))
        {
          System.out.println("Adding a new process");
          SimpleProcess1 sp = new SimpleProcess1(processArray[processCount++], 90+random.nextInt(60));
          processScheduler.addProcess(sp);
        }
      }
    }
  }

 public String waitOnInput()
 {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      //System.out.println("Please type something: ");
      try {
        // wait until we have data to complete a readLine()
        int count = 0;

        while (!br.ready())
        {
          Thread.sleep(200);
          count++;

          if (count > 15)
          {
            return "N";
          }
        }
        String input = br.readLine();
        return input;
        //System.out.println("Hey! Thanks for typing");
      } catch (Exception e) {
        System.out.println("ConsoleInputReadTask() cancelled");

      }

    return "N";

 }





  public static void main(String [] args)
  {
     OperatingSystem operatingSystem = new OperatingSystem();
/*
     SimpleProcess1 sp1 = new SimpleProcess1("one", 113);
     SimpleProcess1 sp2 = new SimpleProcess1("two", 107);
     SimpleProcess1 sp3 = new SimpleProcess1("three", 97);
     SimpleProcess1 sp4 = new SimpleProcess1("four", 91);


     operatingSystem.addProcess(sp1);
     operatingSystem.addProcess(sp2);
     operatingSystem.addProcess(sp3);
     operatingSystem.addProcess(sp4);
*/
     operatingSystem.executeAll();
  }
}
