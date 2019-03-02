/**QUESTION 2: DO-IT-YOURSELF RANDOM NUMBERS READING FROM A FILE CONT..
 * Assignment02
 * COMP 1020 SECTION A01
 * INSTRUCTOR    Amirhossein
 * ASSIGNMENT    Assignment02
 * @author       Danhang Liu, 7716234
 * @version      2015-06-17
 * Purpose:      read the range and number fromd file and create random numbers
 */
import java.io.*;
public class LiuDanhangA2Q2{
  public static void main(String[] args){
    final String INPUT_FILE = "inputFile.txt";
    try{
    FileReader reader = new FileReader(INPUT_FILE);
    BufferedReader inFile = new BufferedReader(reader);
    
    int min, max, numbers;
    String nextLine;
    nextLine = inFile.readLine();

   int firstN = nextLine.indexOf(" ");
   //System.out.println(nextLine.indexOf(" "));
   while(nextLine != null){
     firstN = nextLine.indexOf(" ");
     if(nextLine.indexOf(":")!=0){
       System.out.println(nextLine);
       String newLine="";
       for(int i = firstN+1; i<nextLine.length();i++){
         newLine = newLine + nextLine.charAt(i);
       }
       System.out.println(newLine);
       
       String[] strings = newLine.split(" ");
       int[] array = new int[strings.length];
       for (int i=0; i<strings.length;i++) {
         int inf = Integer.parseInt(strings[i]);
         array[i]=inf;
         //System.out.println(inf);
       }
       min = array[0];
       max = array[1];
       numbers = array[2];
       runPrint(numbers, min, max);
     }
     nextLine = inFile.readLine();
   }
   inFile.close();
    }
    catch(Exception e)
    {
      System.out.println(e.getMessage());
    }

    System.out.println("\nProgrammed by Danhang Liu");
    System.out.println("End of processing");
    

  }
  /**method runPrint() print a message
    * @param numbers limit
    * @param min min range
    * @param max max range
    */
  public static void runPrint(int numbers, int min, int max){
    a1q1Obj object = new a1q1Obj();
    System.out.println("Welcome to the Not-So-Secure (NNS) pseudo-random number generator.");
    System.out.println("Numbers cost $0.25 apiece");
    System.out.printf("Generating %d random numbers in the range [%d, %d]\n",numbers,min,max); 
    System.out.println(object.printRandomSample(numbers,min,max)+"\n");    
  }
}
class a1q1Obj{
  private static long seed = 1;
  private static final long a = 1103515245L;
  private static final long c = 12345L;
  private static final long m = 2147483648L;
  private static long gen;
  /**method getRandomPositiveInt() creat pseudo-random numbers
    * @return gen pseudo-random numbers
    */
  public int getRandomPositiveInt(){
    long gen = (a*seed+c)%m;
    seed = gen;
    return (int)gen;
  }
  /**method originalgetRandomPositiveInt() will get the number in the given range
    * @param min min number for the range
    * @param max max number for the range
    * @return number in range
    */
  public int originalgetRandomPositiveInt(int min, int max){
    int number = getRandomPositiveInt();    
    return (int)number%(max - min + 1)+min;
  }
  /**method printRandomSample()
    * @param numbers limit number for the line
    * @param min min range
    * @param max max range
    * @param result random number in line
    */
  public String printRandomSample(int numbers, int min, int max){
    String result ="";
    int getNum = -1;
    for(int i = 0;i<numbers;i++){
      getNum = originalgetRandomPositiveInt(min, max);
      String str = Integer.toString(getNum);
      String commas ="";
        if(i == numbers-1)
          commas = " ";   
        else
          commas =", ";
        result = result + str + commas;
      }
    return result;
  }
}
