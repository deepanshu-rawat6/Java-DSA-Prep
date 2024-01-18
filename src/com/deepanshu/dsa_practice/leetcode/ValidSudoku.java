package com.deepanshu.dsa_practice.leetcode;

import java.util.HashSet;

public class ValidSudoku {
    public static void main(String[] args) {
        char[][] board = {
                {'8','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}
        };

        ValidSudoku obj = new ValidSudoku();
        System.out.println(obj.isValidSudoku(board));
    }

    public boolean isValidSudoku(char[][] board) {
//        for (char[] chars : board) {
//            HashSet<Character> set = new HashSet<>();
//            for (char ch : chars) {
//                if (set.contains(ch) && Character.isDigit(ch)) {
//                    System.out.println("From 1");
//                    return false;
//                }
//                set.add(ch);
//            }
//        }
//
//        for (int i = 0; i < board.length; i++) {
//            HashSet<Character> set = new HashSet<>();
//            for (int j = 0; j < board[i].length; j++) {
//                char ch = board[j][i];
//                if (set.contains(ch) && Character.isDigit(ch)) {
//                    System.out.println("From 2");
//                    return false;
//                }
//                set.add(ch);
//            }
//        }
//        return true;

        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    String check = "(" + board[i][j] + ")";
                    if (!set.add(check + i) || !set.add(j + check) || !set.add(i/3 + check + j /3)) {
                        return false;
                    }
                }
            }
        }

        return true;
    }
}
