//260. Single Number 3 - https://leetcode.com/problems/single-number-iii/description/
//Time Complexity: O(2n)
//Space Complexity: O(1)

class Solution {
    public int[] singleNumber(int[] nums) {
        int bitmask1 = 0;
        for(int num: nums){
            bitmask1 = bitmask1 ^ num; //XOR of 2 unknown single numbers
        }
        //least significant bit
        //~bitmask1: 1's compliment, +1: 2's compliment
        int lsb = bitmask1 & (~bitmask1 + 1);

        int bitmask2 = 0;
        for(int num: nums){
            if((lsb & num) != 0){ //non single num will cancel out each other
                bitmask2 = bitmask2 ^ num;
            }
        }
        return new int[]{bitmask2, bitmask1 ^ bitmask2}; //eq1 ^ eq2 to find 1 single num
    }
}