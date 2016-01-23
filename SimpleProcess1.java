public class SimpleProcess1 extends Process
{
  int count;
  int maxTimes;
  String processName;

  public SimpleProcess1(String pname, int numTimes)
  {
    count = 0;
    this.maxTimes = numTimes;
    this.processName = pname;
  }

  public boolean executeInstruction()
  {
    count++;
    System.out.println(processName + " executing "+ count + " of "+maxTimes);

    return (count == maxTimes);
  }


}
