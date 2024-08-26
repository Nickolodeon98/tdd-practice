package algorithms.neetcode.max_water_container;

class Solution {
  public int maxArea(int[] heights) {
    // max of (horizontal X vertical)
    // second maximum of height X distance between 1st and 2nd maximum heights
    // where the average of width X height is the highest
    int maxAmount = 0;
    for (int i = 0; i < heights.length - 1; i++) {
      int ptr = i;
      int width = 1;

      while (width + ptr < heights.length) {
        if (heights[ptr + width] < heights[ptr]) {
          System.out.println("heights: " + heights[ptr + width] + " X width: " + width + " = " + heights[ptr + width] * width);
          maxAmount = Math.max(maxAmount, heights[ptr + width] * width);
        } else {
          System.out.println("heights: " + heights[ptr] + " X width: " + width + " = " + heights[ptr] * width);
          maxAmount = Math.max(maxAmount, heights[ptr] * width);
        }
        width++;
      }
    }

    return maxAmount;
  }
}
