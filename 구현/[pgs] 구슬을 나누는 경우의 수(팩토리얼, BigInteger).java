import java.util.*;
import java.math.*;

class Solution {
    public int solution(int balls, int share) {
        BigInteger n = BigInteger.valueOf(balls);
        BigInteger m = BigInteger.valueOf(share);

        BigInteger a = factorial(n);
        BigInteger b = factorial(BigInteger.valueOf(balls - share));
        BigInteger c = factorial(m);

        return a.divide(b.multiply(c)).intValue();
    }

    private static BigInteger factorial(BigInteger n){
        if(n.compareTo(new BigInteger("0")) == 0) return new BigInteger("1");
        return factorial(n.subtract(new BigInteger("1"))).multiply(n);
    }
}