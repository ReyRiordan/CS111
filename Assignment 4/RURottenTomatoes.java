/*************************************************************************
 *  Compilation:  javac RURottenTomatoes.java
 *  Execution:    java RURottenTomatoes
 *
 *  @author: Rey Riordan reyriordan@gmail.com rhr58
 *
 * RURottenTomatoes creates a 2 dimensional array of movie ratings 
 * from the command line arguments and displays the index of the movie 
 * that has the highest sum of ratings.
 *
 *  java RURottenTomatoes 3 2 5 2 3 3 4 1
 *  0
 *************************************************************************/

public class RURottenTomatoes {

    public static void main(String[] args) {

		int numReviewers = Integer.parseInt(args[0]);
		int numMovies = Integer.parseInt(args[1]);
		int table[][] = new int[numReviewers][numMovies];
		int ratings[] = new int[args.length - 2];
		for(int n = 0; n < ratings.length; n++){
			ratings[n] = Integer.parseInt(args[n+2]);
		}
		int reviewer = 0;
		for(int x = 0; x < ratings.length; x += numMovies){
			for(int y = 0; y < numMovies; y++){
				table[reviewer][y] = ratings[x+y];
			}
			reviewer++;
		}
		int highestRatingIndex = 0;
		int highestRating = 0;
		int sum = 0;
		for(int i = 0; i < numMovies; i++){
			for(int j = 0; j < numReviewers; j++){
				sum += table[j][i];
			}
			if(sum > highestRating){
				highestRatingIndex = i;
				highestRating = sum;
			}
			sum = 0;
		}
		System.out.println(highestRatingIndex);
	}
}
