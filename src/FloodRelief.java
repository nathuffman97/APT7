public class FloodRelief {
	int[][] myGrid;
	final int BAD_VAL = -1;
	
	public int minimumPumps(String[] heights) {
		int rows = heights.length;
		int cols = heights[0].length();
		myGrid = new int[rows][cols];
		for(int r=0; r < rows; r++) {
			for(int c=0; c < cols; c++) {
				myGrid[r][c] = heights[r].charAt(c);
			}
		}
		return pumpCount();
	}
	
	public int pumpCount() {
		int pumps = 0;
		while (true) {
			int[] mincoords = minLocation();
			int r = mincoords[0];
			int c = mincoords[1];
			if (locationOk(r,c)) {			
				flood(r,c,myGrid[r][c]);
				pumps += 1;				
			}
			else {
				break;
			}
		}
		return pumps;
	}
	
	public int[] minLocation() {
		int mr = 0;
		int mc = 0;
		int minval = 500;
		for(int r=0; r < myGrid.length; r++) {
			for(int c=0; c < myGrid[0].length; c++) {
				int val = myGrid[r][c];
				if (locationOk(r,c) && val < minval) {
					mr = r;
					mc = c;
					minval = myGrid[r][c];
				}
			}
		}
		return new int[] {mr,mc};
	}
	
	public void flood(int row, int col, int val) {
		if (! locationOk(row,col)) {
			return;
		}
		if (myGrid[row][col] < val) {
			return;
		}
		val = myGrid[row][col];
		myGrid[row][col] = BAD_VAL;
		flood(row-1,col,val);
		flood(row+1,col,val);
		flood(row,col+1,val);
		flood(row,col-1,val);
	}
	public boolean locationOk(int row, int col) {
		if (row < 0 || col < 0 || row >= myGrid.length || 
			col >= myGrid[0].length) {
			return false;
		}
		return myGrid[row][col] != BAD_VAL;
	}
}
