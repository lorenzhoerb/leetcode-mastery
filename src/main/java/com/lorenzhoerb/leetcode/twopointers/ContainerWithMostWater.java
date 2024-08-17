package com.lorenzhoerb.leetcode.twopointers;

public class ContainerWithMostWater {
    public static void main(String[] args) {

    }

    public static int maxArea(int[] height) {
        int maxArea = 0;
        int lp = 0;
        int rp = height.length -1;


        while (lp < rp) {
            maxArea = Math.max(maxArea, Math.min(height[lp], height[rp]) * (rp -lp ));
            if(height[lp] < height[rp]) {
                lp++;
            } else {
                rp--;
            }
        }

        return maxArea;
    }
}
