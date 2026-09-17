/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/
import java.util.*;
class Main{
    public static void main(String[] args) {
        Main obj = new Main();
        int n = 4;
        List<List<String>> result = obj.solveNQueens(n);
        for (List<String> board : result) {
            for (String row : board) {
            System.out.println(row);
            }
            System.out.println();
        }
    }
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        char[][] board = new char[n][n];
        for(int i = 0 ; i<n ; i++){
            for(int j = 0 ; j<n ; j++){
                board[i][j]='.';
            }
        }
        backtrack(board,0,n,result);
        return result;
    }
    public void backtrack(char[][] board , int row , int n , List<List<String>> result){
        if(row==n){
            result.add(construct(board));
            return;
        }
        for(int j = 0 ; j<n ; j++){
            if(issafe(board,row,j,n)){
                board[row][j]='Q';
                backtrack(board,row+1,n,result);
                board[row][j]='.';
            }
        }
    }
    public boolean issafe(char[][] board , int row,int col, int n ){
        for(int i = 0 ; i<row ; i++){
            if(board[i][col]=='Q'){
                return false;
            }
        }
        for(int i = row-1 , j=col-1;i>=0 && j>=0 ; i--,j--){
            if(board[i][j]=='Q'){
                return false;
            }
        }
        for(int i = row-1 , j=col+1;i>=0 && j<n ; i--,j++){
            if(board[i][j]=='Q'){
                return false;
            }
        }
        return true;
    }
    public List<String> construct(char[][] board){
        List<String> res = new ArrayList<>();
        for(int i = 0 ; i<board.length; i++){
            res.add(new String(board[i]));
        }
        return res;
    }
}