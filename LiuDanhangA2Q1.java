/**QUESTION 1: DO-IT-YOURSELF RANDOM NUMBERS
 * Assignment02
 * COMP 1020 SECTION A01
 * INSTRUCTOR    Amirhossein
 * ASSIGNMENT    Assignment02
 * @author       Danhang Liu, 7716234
 * @version      2015-06-17
 * Purpose:    Create ten random number by using pseudo-random numbers in given range
 */ 
public class LiuDanhangA2Q1{
  public static void main(String[] args){
    a1q1Obj object = new a1q1Obj();
    System.out.println("Welcome to the Not-So-Secure (NNS) pseudo-random number generator.");
    System.out.println("Numbers cost $0.25 apiece\n");
    System.out.println("Generating 10 random numbers in the range [40, 100]"); 
    System.out.println(object.printRandomSample(10,40,100));
    
    System.out.println("\nProgrammed by Danhang Liu");
    System.out.println("End of processing");   
  }
}
class a1q1Obj{
  private static long seed = 1;
  private static final long a = 1103515245L;
  private static final long c = 12345L;
  private static final long m = 2147483648L;
  /**method getRandomPositiveInt() creat pseudo-random numbers
    * @return gen pseudo-random numbers
    */
  public int getRandomPositiveInt(){
    long gen = (a*seed+c)%m;//equation to creat pseudo-random numbers
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
        if(i == numbers-1)//check if the last number
          commas = " ";   
        else
          commas =", ";
        result = result + str + commas;
      }   
    return result;
  }  
}
