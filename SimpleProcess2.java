public class SimpleProcess2 extends Process

{

  int count;
  int maxTimes;
  String processName;

 public SimpleProcess2(String pname, int numTimes)
 {
   count = 0;
   this.maxTimes = numTimes;
   this.processName = pname;
 }

 public boolean executeInstruction()
 {
   count++;
   System.out.println(processName);

   return (count == maxTimes);
 }

}
