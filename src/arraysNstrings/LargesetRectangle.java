package arraysNstrings;


import java.util.Stack;

/**
 * LargestRectangle under the histogram
 * */
public class LargesetRectangle {
    public static void main(String[] args) {
        int[] arr = {2, 1, 5, 6, 2, 3};
        System.out.println("max Area using Iteration " + maxAreaIter(arr));

        System.out.println("maxArea another approach " + largestRectanglularAreaInHistogram(arr));
    }


    private static int maxAreaIter(int[] arr) {
        int maxArea = 0;
        int n=arr.length;
        for(int i=0;i<n;i++) {
            int currentHeight = arr[i];
            //look backword to see how far we could extend the current height(min)
            for(int j=i-1;j>=0;j--) {
                int currentWidth = (i-j+1);

                currentHeight = Math.min(currentHeight, arr[j]);
                 maxArea = Math.max(maxArea, currentHeight * currentWidth);
            }
        }
        return maxArea;
    }


    /**
     * https://www.youtube.com/watch?v=RVIh0snn4Qc
     *Algorithm:
     *
     * Maintain a stack
     * If stack is empty or value at top of stack is less than or equal to value at current
     * index, push this into stack.
     * Otherwise keep removing values from stack till value at index at top of stack is
     * less than value at current index.
     * While removing value from stack calculate area
     * if stack is empty it means that till this point value just removed has to be smallest element
     * so area = input[top] * i
     * if stack is not empty then this value at index top is less than or equal to everything from stack top + 1 till i. So area will area = input[top] * (i - stack.peek() - 1);
     * Finally maxArea is area if area is greater than maxArea.
     *
     * also instead of first while loop,
     * for (index = 0; index < n; index++) {
     *     while (!stack.isEmpty() && heights[index] < heights[stack.peek()]) {
     *         int top = stack.pop();
     *         int area = heights[top] * (stack.isEmpty() ? index : index - stack.peek() - 1);
     *         maxArea = Math.max(maxArea, area);
     *     }
     *     stack.push(index);
     * }
     *
     *         if (n == 1) {
     *             return heights[0];
     *         } //leetcode
     *
     * */
    public static int largestRectanglularAreaInHistogram(int[] hist) {
        final Stack<Integer> s = new Stack<>();

        int maxArea = 0;
        int tp;
        int areaWithTop;

        int index = 0;
        while (index < hist.length) {
            //we are adding index.
            if (s.empty() || hist[s.peek()] <= hist[index]) {
                s.push(index); index++;
            } else {
                tp = s.pop();
                int w = s.empty() ? index : index - s.peek() - 1; //s.empty()?i-1:i-1-s.peek(); // i-1 because after a push, i is inc by 1
                System.out.println("************\n" + hist[tp] + " " + w);
                areaWithTop = hist[tp] * w;

                if (maxArea < areaWithTop)
                    maxArea = areaWithTop;
            }
        }


        while (!s.empty()) {
            tp = s.pop();
            int w = s.empty() ? index : index - s.peek() - 1;
            areaWithTop = hist[tp] * w;

            if (maxArea < areaWithTop)
                maxArea = areaWithTop;
        }

        return maxArea;
    }
}
