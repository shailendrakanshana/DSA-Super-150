public class NQueensCount {
    public static int getQueens(boolean board[][],int row,int start){
        if(start==board.length){
            print(board);
            System.out.println("-----------------------------");
            return 1;
        }
        int res = 0;
        for(int col = 0;col<board.length;col++){
            if(Safe_Check(board,row,col)){
                board[row][col] = true;
                res = res + getQueens(board, row+1, start+1);
                board[row][col] = false;
            }
        }
        return res;
    }
    public static boolean Safe_Check(boolean board[][],int row,int col){
        for (int r=row;r>= 0;r--) {
			if (board[r][col]) return false;
		}
		for (int r=row,c=col;r>=0 && c>=0;r--,c--) {
			if (board[r][c]) return false;
		}
		for (int r=row,c=col;r >= 0 && c < board.length;r--,c++) {
			if (board[r][c]) return false;
		}
		return true;
    }
    public static void print(boolean board[][]){
        for(int i = 0;i<board.length;i++){
            for(int j = 0;j<board.length;j++){
                if(board[i][j]) System.out.print(1+" ");
                else System.out.print(0+" ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        boolean b[][] = new boolean[4][4];
        getQueens(b, 0, 0);
    }
}
