/*************************************************************************
 *  Compilation:  javac RecursiveAppend.java
 *  Execution:    java RecursiveAppend
 *
 *  @author: Rey Riordan rhr58 reyriordan@gmail.com
 *
 *************************************************************************/

public class RecursiveAppend {

    // Returns the original string appended to the original string n times 
    public static String appendNTimes (String original, int n) {
        if(n == 0){
            return original;
        } else{
            return original + appendNTimes(original, n-1);
        }
    }

    public static void main (String[] args) {
        System.out.println(appendNTimes("bonk", 0));
    }
}
