/**QUESTION4: DYNAMIC-KEY ENCRYPTION/DECRYPTION IMPLEMENTATION
 * Assignment02
 * COMP 1020 SECTION A01
 * INSTRUCTOR    Amirhossein
 * ASSIGNMENT    Assignment02
 * @author       Danhang Liu, 7716234
 * @version      2015-06-17
 * Purpose:     encrypt a message and decrypt with encrypt/decrypt strings 
 *              with XOR operator and a static key
 */
import java.io.*;
public class LiuDanhangA2Q4{
  public static void main(String[] args)throws Exception{    
    String a ="hello world";
    System.out.println("Encrypt: "+a+"\n");
    int key = 5;
    String fin;
    int[] array = encrypt(a, key);
    for(int i =0; i<array.length; i++)
      System.out.println("binary encrypt: "+array[i]);
    fin = dec(array, key);
    System.out.println("\nDecrypt: "+fin); 

  }//main()
    /**method dec() dynamic key
    * @param k integer the seed 
    */
  public static int dynKey(int k){
    int kn = (43*k+7)%256;
    return kn;
  }
  /**method encrypt to encrypt a message
    * @param ta message to encryp
    * @param key integer key to encrypt
    * @return newArr an array storge encrypted number
    */
  public static int[] encrypt(String a, int key){
    int[] array = new int[a.length()];
    int k = dynKey(key);
    for(int i = 0; i<a.length();i++){
      char c = a.charAt(i);
      String hex = charToHex(c);
      int inte = hexToInt(hex);
      String bin = intToBin(inte);
      int binInt = Integer.parseInt(bin);//bunch of convert to encrypt
      array[i] = binInt;
    }
    
    int[] newArr = new int[a.length()];
    int b;
    for(int j=0; j<a.length();j++){     
      if(j!=0){   
        b = dynKey(key);
      for(int u = 0; u<j;u++){
        k =dynKey(b);
        b = k;
      }
      }
      else
        k = dynKey(key);
      newArr[j] = k ^ array[j];
      System.out.println("dynamic key(encrypt): "+k);
    }//using dynamic key
    return newArr;
  }
  /**method dec() decrypt message
    * @param arary array encrypted
    * @param key the key to dencrypt
    * @return binary dencrypted 
    */
    public static String dec(int[] array, int key){
      int[] newArr = new int[array.length];
      String[] finArr = new String[array.length];
      int k = dynKey(key);
      int d;
      for(int i=0; i<array.length;i++)
      {       
        if(i!=0){   
          d = dynKey(key);
          for(int u = 0; u<i;u++){
            k =dynKey(d);
            d = k;
          }
        }
        else
          k = dynKey(key);     
        newArr[i] = array[i]^k; 
        String arrInt = Integer.toString(newArr[i]);
        int b = binToInt(arrInt);
        char ch = intToChar(b);
        String chS = Character.toString(ch);//bunch of convert to decrypt
        finArr[i] = chS;
      }
      String fin="";
      for(int j=0; j<finArr.length;j++){
       fin = fin + finArr[j];
      }
      return fin;
    }

  /**method charToInt convert char to integer 
    * @param c character to convert
    * @return i interger has been converted
    */
  public static int charToInt(char c){
    return (int)c;
  }
  public static char intToChar(int i){
    return (char)i;
  }
  /**method intToBin convert integer to binary
    * @param i interger to convert
    * @return binbinary interger has been converted
    */
  public static String intToBin(int i){
   String bin = Integer.toBinaryString(i);
   return bin;
  }
  /**method binToInt convert binary to integer
    * @param binary binary to convert
    * @return result interger has been converted
    */
  public static Integer binToInt(String binary){
    int result = 0;
    int count = 0;
    char[] numbers = binary.toCharArray();
    for(int i=numbers.length-1;i>=0;i--){
      if(numbers[i]=='1')result+=(int)Math.pow(2, count);
      count++;
    }  
    return result;
} 
  /**method charToHex convert char to hex
    * @param c character to convert
    * @return hexC String has been converted
    */
  public static String charToHex(char c){
    String hexC = String.format("%04x", (int)c);
    return hexC;
  }
  /**method hexToInt convert hex to Int
    * @param hex String to convert
    * @return num integer has been converted
    */
  public static int hexToInt(String hex){
    int num = Integer.parseInt(hex,16);
    return num;
  }
  
}