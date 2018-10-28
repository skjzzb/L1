package pack;

public class NQueens {

	public static int N=4;
	public static void main(String[] args) 
	{
		NQueens q=new NQueens();
		int board[][]=new int[N][N];
		for(int i=0;i<N;i++)
		{
			for(int j=0;j<N;j++)
				board[i][j]=0;
		}
		q.solveNQueens(board,0);
		for(int i=0;i<N;i++)
		{
			for(int j=0;j<N;j++)
				System.out.print(board[i][j]+" ");
			System.out.println();
		}
	}
	protected static boolean isSafe(int arr[][],int row,int col)
	{
		for(int i=0;i<col;i++)
		{
			if(arr[row][i]==1)
				return false;
		}
		for(int i=row-1,j=col-1;i>=0 &&j>=0;i--,j--)
		{
			if(arr[i][j]==1)
				return false;
		}
		for(int i=row+1,j=col-1;i<N &&j>=0;i++,j--)
		{
			if(arr[i][j]==1)
				return false;
		}
		 return true;
		
	}
	boolean solveNQueens(int [][] board,int col)
	{
		if(col>=N)
		return true;
		for(int i=0;i<N;i++)
		{
			if(isSafe(board, i, col))
			{
				board[i][col]=1;
				if(solveNQueens(board,col+1))
					return true;
				board[i][col]=0;
			}
		}
		return false;
	}
	
}
