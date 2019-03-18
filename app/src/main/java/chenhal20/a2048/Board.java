package chenhal20.a2048;

import java.util.ArrayList;

public class Board {
    public int[][] board;

    Board() {
        board = new int[4][4];
        int fill = 1;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = 0;
                fill++;
            }
        }

        /*board[3][1] = 0; board[3][0] = 2; board[3][2] = 0; board[3][3] = 0;
        board[2][1] = 2; board[2][0] = 2; board[2][2] = 0; board[2][3] = 2;
        board[1][1] = 0; board[1][0] = 0; board[1][2] = 0; board[1][3] = 2;
        board[0][1] = 2; board[0][0] = 2; board[0][2] = 2; board[0][3] = 2;

        *//*board[0][0] = 2; board[0][1] = 2; board[0][2] = 2; board[0][3] = 4;*/
        newTile();
        newTile();
    }

    public static void main(String[] args) {
        /*Board board = new Board();
        board.print();
        System.out.println();

        Scanner in = new Scanner(System.in);
        System.out.println("enter the first letter of the direction you want to move (u, d, l, r)");

        while (in.hasNextLine()) {
            String s = in.nextLine();
            if (s.equals("l")) {
                board.left();
            }
            if (s.equals("r")) {
                board.right();
            }
            if (s.equals("d")) {
                board.down();
            }
            if (s.equals("u")) {
                board.up();
            }
            board.print();
            System.out.println();
        }

        in.close();
        board.up();
        board.print();
        System.out.println();*/
    }


    public void left() {
        shiftLeft();
    }

    public void down() {
        rotate();
        shiftLeft();
        rotate();
        rotate();
        rotate();
    }

    public void right() {
        rotate();
        rotate();
        shiftLeft();
        rotate();
        rotate();
    }

    public void up() {
        rotate();
        rotate();
        rotate();
        shiftLeft();
        rotate();
    }

    public void rotate() {
        int[][] copy = new int[board.length][board.length];
        // if you do normal cloning, it changes the clone every time you change the
        // board
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                copy[i][j] = board[i][j];
            }
        }

        for (int j = 0; j < this.board.length; j++) {
            for (int k = 0; k < this.board[j].length; k++) {
                board[k][3 - j] = copy[j][k];
            }
        }

		/*System.out.println();
		print();
		System.out.println();*/
    }

    private void newTile() {
        int x = (int) (Math.random() * this.board.length);
        int y = (int) (Math.random() * this.board.length);
        if (isEmpty(board[x][y])) {
            board[x][y] = 2;
        } else
            newTile();
    }

    private boolean isEmpty(int cell) {
        return cell == 0;
    }

    private void shiftLeft() {
        int[][] copy = new int[board.length][board.length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                copy[i][j] = board[i][j];
            }
        }

        for (int k = 0; k < 2; k++) {
            for (int i = 0; i < board.length; i++) {
                for (int j = 1; j < board[i].length; j++) {
                    while (board[i][j] != 0 && board[i][j - 1] == 0) {
                        board[i][j - 1] += board[i][j];
                        board[i][j] = 0;
                    }
                }
            }
        }


        for (int i = 0; i < board.length; i++) {
            for (int j = 1; j < board[i].length; j++) {
                if (board[i][j] == board[i][j - 1]) {
                    board[i][j - 1] += board[i][j];
                    board[i][j] = 0;
                } else if (board[i][j - 1] == 0) {
                    board[i][j - 1] += board[i][j];
                    board[i][j] = 0;
                    j = Math.max(1, j-2);
                }
            }

        }

        //added this right here but i think youll need another view for it to be useful
        isOver();

        boolean isChanged = false;
        for (int i = 0; i < board.length; i++) {
            for (int j = 1; j < board[i].length; j++) {
                if (board[i][j] != copy[i][j]) {
                    isChanged = true;
                }
            }

        }
        if (isChanged) {
            newTile();
        }
    }

    // make this have the ability to actually end the game in main activity
    public boolean isOver() {
        boolean isFull = true;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j]==0) {
                    isFull = false;
                    break;
                }
            }
        }

        boolean canMove = false;
        for (int i = 0; i < board.length-1; i++) {
            for (int j = 0; j < board[i].length-1; j++) {
                if (board[i][j]==board[i+1][j] || board[i][j]==board[i][j+1]) {
                    canMove = true;
                    break;
                }
            }
        }
        return isFull && canMove;
    }

    public void print() {
        isOver();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j] + "\t");
            }
            System.out.println();
        }
    }
}

