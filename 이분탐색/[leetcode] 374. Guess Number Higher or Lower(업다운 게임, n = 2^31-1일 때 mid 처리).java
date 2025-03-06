/**
 * Forward declaration of guess API.
 * @param  num   your guess
 * @return 	     -1 if num is higher than the picked number
 *			      1 if num is lower than the picked number
 *               otherwise return 0
 * int guess(int num);
 */
/*
1~n을 넣고 이분 탐색.
만약 guess == 몇인지 따져서 업다운 하기
n이 2^31-1이니까 mid할 때 (e-s)/2먼저 하고 다시 s를하는 게 나을듯
*/

public class Solution extends GuessGame {
    public int guessNumber(int n) {
        int s = 1;
        int e = n;

        while(s<=e){
            int mid = (e-s)/2 + s;
            if(guess(mid) == -1){
                e = mid-1;
            }else if(guess(mid) == 1){
                s = mid+1;
            }else{
                return mid;
            }
        }
        return -1;
    }
}