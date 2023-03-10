/*************************************************************************
 *  Compilation:  javac FindDuplicate.java
 *  Execution:    java FindDuplicate
 *
 *  @author: Rey Riordan reyriordan@gmail.com rhr58
 *
 * FindDuplicate that reads n integer arguments from the command line 
 * into an integer array of length n, where each value is between is 1 and n, 
 * and displays true if there are any duplicate values, false otherwise.
 *
 *  % java FindDuplicate 10 8 5 4 1 3 6 7 9
 *  false
 *
 *  % java FindDuplicate 4 5 2 1 2
 *  true
 *************************************************************************/

public class FindDuplicate {

    public static void main(String[] args) {

		int[] arr = new int[args.length];
		for(int n = 0; n < args.length; n++){
			arr[n] = Integer.parseInt(args[n]);
		}
		boolean duplicates = false;
		for(int i = 0; i < arr.length; i++){
			for(int j = 0; j < arr.length; j++){
				if((arr[i] == arr[j]) && (i != j)){
					duplicates = true;
				}
			}
		}
		System.out.println(duplicates);
	}
}
