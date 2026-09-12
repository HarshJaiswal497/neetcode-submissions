class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int nsl[] = new int[n];
        int nsr[] = new int[n];
        Stack<Integer> stk = new Stack<>();
        for(int i=0; i<n; i++){
            while(!stk.isEmpty() && heights[stk.peek()] >= heights[i]){
                stk.pop();
            }
            if(stk.isEmpty()){
                nsl[i] = -1;
            }else{
                nsl[i] = stk.peek();
            }
            stk.push(i);
        }
        // System.out.println(Arrays.toString(nsl));
        stk.clear();

        for(int i=n-1; i>=0; i--){
            while(!stk.isEmpty() && heights[stk.peek()] >= heights[i]){
                stk.pop();
            }
            if(stk.isEmpty()){
                nsr[i] = n;
            }else{
                nsr[i] = stk.peek();
            }
            stk.push(i);
        }
        // System.out.println(Arrays.toString(nsr));
        int maxArea = 0;
        for(int i=0; i<n; i++){
            maxArea = Math.max(maxArea, (nsr[i]-nsl[i]-1)*heights[i]);
        }
        return maxArea;
    }
}
