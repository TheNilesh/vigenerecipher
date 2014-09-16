/* Project: Implement Vigenere Caeser Shift Algorithm
	Started: 08-03-2014
*/

public class caeser {
  public static void main(String[] args) {
        
        boolean enc=args[0].equals("-e");
        String data=args[2];
        String skey=args[1];
        
        char cipher[]=new char[data.length()];
        int keyLen=skey.length();
	int key[]=new int[keyLen];
        for(int i=0;i<keyLen;i++)
            key[i]=Integer.parseInt(String.valueOf(skey.charAt(i)));
        
        for(int i=0;i<data.length();i++)
            cipher[i]=cryptChar(data.charAt(i), key[i%keyLen],enc);
        data=String.valueOf(cipher);
        
    System.out.println(data);
 //       for(int i=48;i<123;i++)
 //           System.out.println(i+ "= "+ (char)i);
    }
static char cryptChar(char inChar,int keyCode,boolean enc)
{
    char outChar;
    int temp;
    temp=enc?inChar+keyCode:inChar-keyCode;
     //Valid english Char
        if(inChar>='A' && inChar<='Z')
            outChar=(char) (temp>'Z'?temp-26:(temp<'A'?temp+26:temp));
        else if(inChar>='0' && inChar<='9')
            outChar=(char) (temp>'9'?temp-10:(temp<'0'?temp+10:temp));
        else if(inChar>='a' && inChar<='z')
            outChar=(char) (temp>'z'?temp-26:(temp<'a'?temp+26:temp));
        else
            return inChar; //Do not process Non English Character
    return outChar;
}

}//class
