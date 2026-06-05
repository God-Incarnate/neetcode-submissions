class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int maxAr=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                int count=0;
                maxAr=Math.max(maxAr,arCount(grid,i,j,count));
            }
        }
        return maxAr;
    }
    private int arCount(int[][] grid,int i,int j,int count){
        if(i<0||j<0||i>=grid.length||j>=grid[0].length||grid[i][j]==0) return count;
        grid[i][j]=0;
        count++;
        count=arCount(grid,i+1,j,count);
        count=arCount(grid,i-1,j,count);
        count=arCount(grid,i,j+1,count);
        count=arCount(grid,i,j-1,count);
        return count;
        
    }
}