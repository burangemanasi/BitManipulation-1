//136. Single Number - https://leetcode.com/problems/single-number/description/
//Time Complexity: O(n)
//Space Complexity: O(1)

class Solution {
    public int singleNumber(int[] nums) {
        int result = 0;
        for(int num: nums){
            result = result ^ num; //XOR - Bit Manipulation
        }
        return result;
    }
}