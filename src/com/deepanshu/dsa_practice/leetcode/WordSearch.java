package com.deepanshu.dsa_practice.leetcode;

public class WordSearch {

    public static void main(String[] args) {
        char[][] board = {
                {'A', 'B', 'C', 'E' },
                {'S', 'F', 'C', 'S' },
                {'A', 'D', 'E', 'E' }
        };
        String word = "ABCCED";
        System.out.println(exist(board, word));
    }

//    public static boolean exist(char[][] board, String word) {
//        int m = board.length;
//        int n = board[0].length;
//        for (int i = 0; i < m; i++) {
//            for (int j = 0; j < n; j++) {
//                if (check_dfs(board, word, i, j, m, n, 0)) {
//                    return true;
//                }
//            }
//        }
//        return false;
//    }
//
//    public static boolean check_dfs(
//            char[][] board,
//            String word,
//            int i,
//            int j,
//            int m,
//            int n,
//            int cur
//    ) {
//        if (cur >= word.length()) return true;
//        if ( i < 0 ||
//                j < 0 ||
//                i >= m ||
//                j >= n ||
//                board[i][j] != word.charAt(cur)
//        ) return false;
//
//        boolean exist = false;
//
//        if (board[i][j] == word.charAt(cur)) {
//            board[i][j] += 200;
//
//            exist = check_dfs(board, word, i + 1, j, m, n, cur + 1) ||
//                    check_dfs(board, word, i, j + 1, m, n, cur + 1) ||
//                    check_dfs(board, word, i - 1, j, m, n, cur + 1) ||
//                    check_dfs(board, word, i, j - 1, m, n, cur + 1);
//
//            board[i][j] -= 200;
//        }
//        return exist;
//    }

    static boolean[][] visited;
    public static boolean exist(char[][] board, String word) {
        visited = new boolean[board.length][board[0].length];

        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[i].length; j++){
                if((word.charAt(0) == board[i][j]) && search(board, word, i, j, 0)){
                    return true;
                }
            }
        }

        return false;
    }

    private static boolean search(char[][]board, String word, int i, int j, int index){
        if(index == word.length()){
            return true;
        }

        if(i >= board.length || i < 0 || j >= board[i].length || j < 0 || board[i][j] != word.charAt(index) || visited[i][j]){
            return false;
        }

        visited[i][j] = true;
        if(search(board, word, i-1, j, index+1) ||
                search(board, word, i+1, j, index+1) ||
                search(board, word, i, j-1, index+1) ||
                search(board, word, i, j+1, index+1)){
            return true;
        }

        visited[i][j] = false;
        return false;
    }


}
