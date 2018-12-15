public class NumberFill {
	int[][] ngrid;
	char[][] grid;
	
	int rmax,cmax,max;
	
	public int gradient(String[] pic){
		int rows = pic.length;
		int cols = pic[0].length();
		grid =new char[rows][cols];
		ngrid = new int[rows][cols];
		
		
		for(int r=0; r < rows; r++){
			for(int c = 0; c < cols; c++){
				grid[r][c] = pic[r].charAt(c);
				ngrid[r][c] = 0;
			}
		}
		for(int r=0; r < rows; r++){
			for(int c = 0; c < cols; c++){
				max = -1;
				flood(r,c);
				if (max != -1){
					floodFill(rmax,cmax,max-'0');
				}
			}
		}
		
		int total = 0;
		for(int r=0; r < rows; r++){
			for(int c = 0; c < cols; c++){
				total += ngrid[r][c];
			}
		}
		return total;
	}
	
	public void flood(int r, int c){
		if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length){
			return;
		}
		if (grid[r][c] == 'X' || grid[r][c] == '*') return;
		if (grid[r][c] == max){
			if (c < cmax){
				rmax = r;
				cmax = c;
			}
		}
		else if (grid[r][c] != '.' && grid[r][c] > max){
			rmax = r;
			cmax = c;
			max = grid[r][c];
		}
		grid[r][c] = '*';
		flood(r+1,c);
		flood(r-1,c);
		flood(r,c+1);
		flood(r,c-1);
	}
	
	public void floodFill(int r, int c, int val){
		if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length){
			return;
		}
		if (grid[r][c] == 'X') return;
		grid[r][c] = 'X';
		ngrid[r][c] = val;
		
		floodFill(r+1,c,val);
		floodFill(r-1,c,val);
		floodFill(r,c-1,val-1);
		floodFill(r,c+1,val+1);
	}
	
	public static void main(String[] args) {
		NumberFill n = new NumberFill();
		String[] s = {".....1.....2....3...", 
					  "XXXXXXXXXXXXXXXXXXX.", 
					  "..................X.", 
					  ".XXXXXXXXXXXXXXXX.X.", 
					  ".X....2.........X.X.", 
					  ".X.XXXXXXXXXXXX.X.X.", 
					  ".X.X....3.....X.X.X.", 
					  ".X.X.XXXXXXXX.X.X.X.", 
					  ".X.X.X...4..X.X.X.X.", 
					  ".X.X.X.XXXX.X.X.X.X4", 
					  ".X.X.X.X12X.X.X.X.X.", 
					  ".X.X8X.X....X.X.X.X.", 
					  ".X.X.X.XXXXXX.X.X.X.", 
					  ".X.X.X...2....X.X.X.", 
					  "6X.X.XXXXXXXXXX.X.X.", 
					  ".X.X.....3......X.X.", 
					  ".X.XXXXXXXXXXXXXX.X.", 
					  ".X................X.", 
					  ".XXXXXXXXXXXXXXXXXX.", 
					  ".........5.........9"};
		int x = n.gradient(s);
		for (int i = 0; i < n.ngrid.length; i++) {
			for (int j = 0; j < n.ngrid[0].length; j++)
				System.out.print(n.ngrid[i][j]+" ");
			System.out.print("\n");
		}
		System.out.println(x);
	}
}
