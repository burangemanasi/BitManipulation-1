//29. Divide 2 Integers - https://leetcode.com/problems/divide-two-integers/description/
//Time Complexity: O(log(n))
//Space Complexity: 0(1)

class Solution {
    public int divide(int dividend, int divisor) {
        //edge case
        //if we reach out of bound while -1
        if(dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE;

        int result = 0;
        long ldividend = Math.abs((long)dividend);
        long ldivisor = Math.abs((long)divisor);

        while(ldividend >= ldivisor){
            int numShifts = 1;
            while((ldivisor << numShifts) <= ldividend){
                numShifts++;
            }
            numShifts--; //we will have 1 extra shift > dividend, subtract that
            result += 1 << numShifts;
            ldividend = ldividend - (ldivisor << numShifts);
        }

        if(dividend>0 && divisor>0 || dividend<0 && divisor<0) return result;
        if(dividend<0 || divisor<0) return -result;
        return result;
    }
}