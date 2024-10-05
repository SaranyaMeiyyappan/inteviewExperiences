import java.util.LinkedList;
import java.util.Queue;

/**
 * Loop the n*m array and the value is '1' do a BFS
 * BFS - maintain another n*m array called visited
 *     for the currentRow*currentColumn, if the value is '1' update the visited Array
 *     find all the 8 surrounding neighbours and check its value
 */
public class FindNumberOfIslands {
    public static void main(String[] args) {
        char[][] grid =  {
                {'0', '1', '1', '1', '0', '0', '0'},
                {'0', '0', '1', '1', '0', '1', '0'}
        };
        FindNumberOfIslands obj = new FindNumberOfIslands();
        System.out.println(obj.getIslandsCount(grid));
    }

    private int getIslandsCount(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int count = 0;
        int[][] visited = new int[n][m];

        for(int row=0; row<n; row++){
            for(int col=0; col<m; col++){
                if(visited[row][col] == 0 && grid[row][col]=='1'){
                    count++;
                    bfs(visited, grid, row, col, count);
                }
            }
        }
        return count;
    }

    private void bfs(int[][] visited, char[][] grid, int row, int col, int count) {
        visited[row][col] = 1;
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(row, col));

        int n = grid.length;
        int m = grid[0].length;

        while(!queue.isEmpty()){
            int currentRow = queue.peek().first;
            int currentCol = queue.peek().second;
            queue.remove();

            for(int adjRow=-1; adjRow<=1; adjRow++){
                for(int adjCol=-1; adjCol<=1; adjCol++){
                    int neighbourRow = currentRow+adjRow;
                    int neighbourCol = currentCol+adjCol;

                    if(neighbourRow >=0 && neighbourRow < n &&
                        neighbourCol >=0 && neighbourCol < m &&
                        grid[neighbourRow][neighbourCol] == '1' && visited[neighbourRow][neighbourCol] == 0){
                        visited[neighbourRow][neighbourCol] = 1;
                        queue.add(new Pair(neighbourRow, neighbourCol));
                    }
                }
            }
        }
    }

}

class Pair{
    int first;
    int second;
    public Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }
}
