package fbMianjing;

/**
 * Created by yangw on 2019/7/14.
 * 首先我们要先熟悉下Tic-Tac-Toe三连棋游戏规则，就是两人轮流在九格方盘上画'X'或者'O'，谁先把三个相同记号排成横线、直线、斜线，即游戏结束。

 那么我们从游戏规则中来找处所有不合理的状态。

 根据规则1和2，假设X的数目为countX, O的数目为countO，那么我们可以得到countX==countO，或者countX - countO == 1。

 根据游戏结束后则不能再画O和X，那么当countX==count时，如果存在三个X排成横线、直线、斜线，那么即是不合理的，因为X先画，当三个X排成横线、直线、斜线时， 此时游戏结束，不能再画O，所以O的数目应该比X的数目少1。

 当countX - countO == 1时，如果存在三个O排成横线、直线、斜线，那么是不合理的，因为当三个O排成横线、直线、斜线时，游戏结束，不能再画X，所以此时X的数目应该和O的数目相等。
 */
public class validTicTacToe {
    public boolean validTicTacToe(String[] board) {
        char[][] boardChar = new char[3][3];
        for (int i = 0; i < board.length; i++) {
            boardChar[i] = board[i].toCharArray();
        }
        int countX = 0;
        int countO = 0;
        for (int i = 0; i < boardChar.length; i++) {
            for (int j = 0; j < boardChar[i].length; j++) {
                if (boardChar[i][j] == 'X') {
                    countX++;
                } else if (boardChar[i][j] == 'O') {
                    countO++;
                }
            }
        }
        if (countO > countX || countX - countO > 1) {
            return false;
        }
        if (countX - countO == 1) {
            if(!helper(boardChar, 'O')) {
                return false;
            }
        } else if (countX == countO) {
            if(!helper(boardChar, 'X')) {
                return false;
            }
        }

        return true;
    }

    private boolean helper(char[][] boardChar, char ch) {
        for (int i = 0; i < 3; i++) {
            if (boardChar[i][0] == ch && boardChar[i][0] == boardChar[i][1] && boardChar[i][1] == boardChar[i][2]) {
                return false;
            }
            if (boardChar[0][i] == ch && boardChar[0][i] == boardChar[1][i] && boardChar[1][i] == boardChar[2][i]) {
                return false;
            }
        }
        if (boardChar[0][0] == ch && boardChar[0][0] == boardChar[1][1] && boardChar[1][1] == boardChar[2][2]) {
            return false;
        }
        if (boardChar[0][2] == ch && boardChar[0][2] == boardChar[1][1] && boardChar[1][1] == boardChar[2][0]) {
            return false;
        }
        return true;
    }
}
