import java.io.*;

public class Ch1_ZeroMatrix {
	
	public void nullifyRow(int[][] arr, int row) {
		for(int i=0; i<arr[0].length;i++) {
			arr[row][i] = 0;
		}
	}
	
	public void nullifyCol(int[][] arr, int col) {
		for(int i=0; i<arr.length;i++) {
			arr[i][col] = 0;
		}
	}
	
	public void setZeroes(int[][] arr) {
		
		boolean isColzero = false;
		boolean isRowZero = false;
		
		for(int i=0; i< arr[0].length;i++) {
			if(arr[0][i] == 0) {
				isRowZero = true;
				break;
			}
		}
		
		for(int i=0; i<arr.length;i++) {
			if(arr[i][0] == 0) {
				isColzero = true;
				break;
			}
		}
		
		for(int i=0; i<arr.length;i++) {
			for(int j=0; j<arr[0].length;j++) {
				if(arr[i][j] == 0) {
					arr[0][j] = 0;
					arr[i][0] = 0;
				}
			}
		}
		
		for(int i=1; i< arr.length;i++) {
			if(arr[i][0] == 0)
				nullifyRow(arr,i);
		}
		
		for(int i=1; i<arr[0].length;i++) {
			if(arr[0][i] == 0)
				nullifyCol(arr,i);
		}
		
		if(isColzero)
			nullifyCol(arr,0);
		if(isRowZero)
			nullifyRow(arr,0);
		
		for(int i=0; i< arr.length;i++) {
			for(int j=0; j<arr[0].length;j++) {
				System.out.print(arr[i][j]);
			}
			System.out.println();
		}
	}
	
	
	public static void main(String[] args) {
		int[][] arr = {{1,2,3},{4,5,6},{7,0,8},{9,3,1}};
		Ch1_ZeroMatrix m = new Ch1_ZeroMatrix();
		m.setZeroes(arr);
	}
}
