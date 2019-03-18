package chenhal20.a2048;

import android.graphics.Color;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {
    // make an array of a clone via yegor
    Board board;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.activity_main).setOnTouchListener(new OnSwipeTouchListener(MainActivity.this) {
            public void onSwipeTop() {
                board.up();
                show();
            }
            public void onSwipeRight() {
                board.right();
                show();
            }
            public void onSwipeLeft() {
                board.left();
                show();
            }
            public void onSwipeBottom() {
                board.down();
                show();
            }

        });

        board = new Board();
        show();
    }


    public void left(View v) {
        board.left();
        show();
    }
    public void right(View v) {
        board.right();
        show();
    }
    public void up(View v) {
        board.up();
        show();
    }
    public void down(View v) {
        board.down();
        show();
    }

    public void show() {
        LinearLayout tblLayout =  findViewById(R.id.tableLayout);
        for (int i = 0; i < 4; i++) {
            LinearLayout row = (LinearLayout) tblLayout.getChildAt(i);
            for (int j = 0; j < 4; j++) {
                Button button = (Button) row.getChildAt(j);
                button.setClickable(false);
                button.setText(String.valueOf(board.board[i][j]));
                /*if (board.board[i][j]==0) {
                    button.setBackgroundColor(Color.parseColor("#EDE4DB"));
                }*/

                /*String[] colors = {"a", "b", "c"};
                Math.log(board.board[i][j])/Math.log(2) - 1*/
                if (board.board[i][j]==0) {
                    button.setBackgroundColor(Color.parseColor("#cdc1b5"));
                    button.setTextColor(Color.parseColor("#cdc1b5"));
                }
                if (board.board[i][j]==2) {
                    button.setBackgroundColor(Color.parseColor("#EDE4DB"));
                    button.setTextColor(Color.parseColor("#9F958B"));
                }
                if (board.board[i][j]==4) {
                    button.setBackgroundColor(Color.parseColor("#ECE0CA"));
                    button.setTextColor(Color.parseColor("#9F958B"));
                }
                if (board.board[i][j]==8) {
                    button.setBackgroundColor(Color.parseColor("#F2B278"));
                    button.setTextColor(Color.parseColor("#FFFFFF"));
                }
                if (board.board[i][j]==16) {
                    button.setBackgroundColor(Color.parseColor("#EF8C54"));
                    button.setTextColor(Color.parseColor("#FFFFFF"));
                }
                if (board.board[i][j]==32) {
                    button.setBackgroundColor(Color.parseColor("#F27D63"));
                    button.setTextColor(Color.parseColor("#FFFFFF"));
                }
                if (board.board[i][j]==64) {
                    button.setBackgroundColor(Color.parseColor("#F1552C"));
                    button.setTextColor(Color.parseColor("#FFFFFF"));
                }
                if (board.board[i][j]==128) {
                    button.setBackgroundColor(Color.parseColor("#F2DF65"));
                    button.setTextColor(Color.parseColor("#FFFFFF"));
                }
                if (board.board[i][j]==256) {
                    button.setBackgroundColor(Color.parseColor("#F4CE4F"));
                    button.setTextColor(Color.parseColor("#FFFFFF"));
                }
                if (board.board[i][j]==512) {
                    button.setBackgroundColor(Color.parseColor("#E9BE23"));
                    button.setTextColor(Color.parseColor("#FFFFFF"));
                }
                if (board.board[i][j]==1024) {
                    button.setBackgroundColor(Color.parseColor("#E6B614"));
                    button.setTextColor(Color.parseColor("#FFFFFF"));
                }
                if (board.board[i][j]==2048) {
                    button.setBackgroundColor(Color.parseColor("#E6C601"));
                    button.setTextColor(Color.parseColor("#FFFFFF"));
                }

            }
        }
    }
}