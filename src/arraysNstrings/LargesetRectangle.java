package arraysNstrings;


import java.util.Stack;

/**
 * LargestRectangle under the histogram
 * */
public class LargesetRectangle {
    public static void main(String[] args) {
        int[] arr = {3, 2, 5, 6, 1, 4, 4};
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
     *
     *
     * */
    public static int largestRectanglularAreaInHistogram(int[] hist) {
        final Stack<Integer> s = new Stack<>();

        int maxArea = 0;
        int tp;
        int areaWithTop;

        int i = 0;
        while (i < hist.length) {
            //we are adding index.
            if (s.empty() || hist[s.peek()] <= hist[i]) {
                s.push(i); i++;
            } else {
                tp = s.pop();
                int w = s.empty() ? i : i - s.peek() - 1; //s.empty()?i-1:i-1-s.peek(); // i-1 because after push i is inc by 1
                areaWithTop = hist[tp] * w;

                if (maxArea < areaWithTop)
                    maxArea = areaWithTop;
            }
        }

        while (!s.empty()) {
            tp = s.pop();
            int w = s.empty() ? i : i - s.peek() - 1;
            areaWithTop = hist[tp] * w;

            if (maxArea < areaWithTop)
                maxArea = areaWithTop;
        }

        return maxArea;
    }
}
