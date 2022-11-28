package malik.tictactoe;
import android.app.Dialog;
import android.os.Bundle;
import android.util.Log;
import android.view.Window;
import android.widget.Button;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    int flag = 0, ax = 10, zero = 1, win = 0,  game = 1;
    int summ = 0, ctrflag = 0, resetChecker = 1, currentGameDoneChecker = 0;
    int score1 = 0, score2 = 0, drawChecker = 0;
    static int[][] tracker = new int[3][3];
    int[] sum = new int[8];
    static int[][] buttonPressed = new int[3][3];

    boolean player1ax;

    TextView p1;
    TextView p2;
    CharSequence player1 = "Player 1";
    CharSequence player2 = "Player 2";


    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        player1ax = false;

        p1 = (TextView) findViewById(R.id.playerone);
        p2 = (TextView) findViewById(R.id.playertwo);

        p1.setText(player1);
        p2.setText(player2);

        Toast.makeText(this, "" + player1 + "'s turn", Toast.LENGTH_SHORT).show();

    }


    public void kzz(View view) {//This are the ooClick method of imageviews


        if (win == 0 && buttonPressed[0][0] == 0) {//here we are checking weather we have pressed button
            if (flag % 2 == 0)//if flag=0,2,4,6 then player1's turn else player 2's turn
                tracker[0][0] = ax;
            else
                tracker[0][0] = zero;

            printBoard();//here we are printing x or o depending on p1 , p2
            winchecker();//we are calling after each image press to check weather p1 or p2 won
            flag++;//here we are incrementing the flag so that next turn will be stored in tracker array player1=ax player2=zero
            Log.e("B buttonpressed[0][0]++", String.valueOf(buttonPressed[0][0]));

            buttonPressed[0][0]++;//here we are incrementing the array buttonpressed[0][0]=0 to buttonpressed[0][0]=1
            //so that if next time user presess same button KzZ() method will not executed
            Log.e("A buttonpressed[0][0]++", String.valueOf(buttonPressed[0][0]));
        }
    }


    public void kzo(View view) {

        if (win == 0 && buttonPressed[0][1] == 0) {
            if (flag % 2 == 0) tracker[0][1] = ax;
            else tracker[0][1] = zero;

            printBoard();
            winchecker();
            Log.e("B buttonpressed[0][1]++", String.valueOf(buttonPressed[0][1]));

            buttonPressed[0][1]++;
            Log.e("A buttonpressed[0][1]++", String.valueOf(buttonPressed[0][1]));
            flag++;
        }
    }

    public void kzt(View view) {
        if (win == 0 && buttonPressed[0][2] == 0) {
            if (flag % 2 == 0) tracker[0][2] = ax;
            else tracker[0][2] = zero;

            printBoard();
            winchecker();
            Log.e("B buttonpressed[0][2]++", String.valueOf(buttonPressed[0][2]));

            buttonPressed[0][2]++;
            Log.e("A buttonpressed[0][2]++", String.valueOf(buttonPressed[0][2]));

            flag++;
        }
    }

    public void koz(View v) {
        if (win == 0 && buttonPressed[1][0] == 0) {
            if (flag % 2 == 0) tracker[1][0] = ax;
            else tracker[1][0] = zero;

            printBoard();
            winchecker();

            ++buttonPressed[1][0];
            flag++;
        }
    }

    public void koo(View v) {
        if (win == 0 && buttonPressed[1][1] == 0) {
            if (flag % 2 == 0) tracker[1][1] = ax;
            else tracker[1][1] = zero;
            printBoard();
            winchecker();
            ++buttonPressed[1][1];
            flag++;
        }
    }

    public void kot(View v) {
        if (win == 0 && buttonPressed[1][2] == 0) {
            if (flag % 2 == 0) tracker[1][2] = ax;
            else tracker[1][2] = zero;

            printBoard();
            winchecker();
            ++buttonPressed[1][2];
            flag++;
        }
    }

    public void ktz(View v) {
        if (win == 0 && buttonPressed[2][0] == 0) {
            if (flag % 2 == 0) tracker[2][0] = ax;
            else tracker[2][0] = zero;

            printBoard();
            winchecker();
            ++buttonPressed[2][0];
            flag++;
        }
    }

    public void kto(View v) {
        if (win == 0 && buttonPressed[2][1] == 0) {
            if (flag % 2 == 0) tracker[2][1] = ax;
            else tracker[2][1] = zero;
            printBoard();
            winchecker();
            ++buttonPressed[2][1];
            flag++;
        }
    }

    public void ktt(View v) {
        if (win == 0 && buttonPressed[2][2] == 0) {
            if (flag % 2 == 0) tracker[2][2] = ax;
            else tracker[2][2] = zero;

            printBoard();
            winchecker();
            ++buttonPressed[2][2];
            flag++;
        }
    }

    public void printBoard() {
        ImageView q1, q2, q3, q4, q5, q6, q7, q8, q9;

        q1 = (ImageView) findViewById(R.id.tzz);
        q2 = (ImageView) findViewById(R.id.tzo);
        q3 = (ImageView) findViewById(R.id.tzt);
        q4 = (ImageView) findViewById(R.id.toz);
        q5 = (ImageView) findViewById(R.id.too);
        q6 = (ImageView) findViewById(R.id.tot);
        q7 = (ImageView) findViewById(R.id.ttz);
        q8 = (ImageView) findViewById(R.id.tto);
        q9 = (ImageView) findViewById(R.id.ttt);


        if (tracker[0][0] == 1) q1.setImageResource(R.drawable.x); //if ax=1 means player1=x or if zero=1 means player2=x
        if (tracker[0][0] == 10) q1.setImageResource(R.drawable.oo);//if ax=10 means player1=O or if zero=10 means player2=O


        if (tracker[0][1] == 1) q2.setImageResource(R.drawable.x);
        if (tracker[0][1] == 10) q2.setImageResource(R.drawable.oo);


        if (tracker[0][2] == 1) q3.setImageResource(R.drawable.x);
        if (tracker[0][2] == 10) q3.setImageResource(R.drawable.oo);


        if (tracker[1][0] == 1) q4.setImageResource(R.drawable.x);
        if (tracker[1][0] == 10) q4.setImageResource(R.drawable.oo);

        if (tracker[1][1] == 1) q5.setImageResource(R.drawable.x);
        if (tracker[1][1] == 10) q5.setImageResource(R.drawable.oo);


        if (tracker[1][2] == 1) q6.setImageResource(R.drawable.x);
        if (tracker[1][2] == 10) q6.setImageResource(R.drawable.oo);

        if (tracker[2][0] == 1) q7.setImageResource(R.drawable.x);
        if (tracker[2][0] == 10) q7.setImageResource(R.drawable.oo);


        if (tracker[2][1] == 1) q8.setImageResource(R.drawable.x);
        if (tracker[2][1] == 10) q8.setImageResource(R.drawable.oo);

        if (tracker[2][2] == 1) q9.setImageResource(R.drawable.x);
        if (tracker[2][2] == 10) q9.setImageResource(R.drawable.oo);

        resetChecker++;
    }


    public void showDialog(String whoWon) {

        final Dialog dialog = new Dialog(MainActivity.this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_layout);
        TextView titleText = dialog.findViewById(R.id.title_text);
        dialog.setCancelable(false);
        dialog.show();

        titleText.setText(whoWon);

        Button resetButton = dialog.findViewById(R.id.reset_button);
        Button playAgainButton = dialog.findViewById(R.id.play_again_button);

        resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
                doreset();
            }
        });

        playAgainButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
                playmore();
            }
        });
    }

    public void winchecker() {
        ctrflag++;
        //here we will add the sum of rows,columns and diagonals
        sum[0] = tracker[0][0] + tracker[0][1] + tracker[0][2];
        sum[1] = tracker[1][0] + tracker[1][1] + tracker[1][2];
        sum[2] = tracker[2][0] + tracker[2][1] + tracker[2][2];
        sum[3] = tracker[0][0] + tracker[1][0] + tracker[2][0];
        sum[4] = tracker[0][1] + tracker[1][1] + tracker[2][1];
        sum[5] = tracker[0][2] + tracker[1][2] + tracker[2][2];
        sum[6] = tracker[0][0] + tracker[1][1] + tracker[2][2];
        sum[7] = tracker[0][2] + tracker[1][1] + tracker[2][0];


        currentGameDoneChecker++;
        resetChecker++;
        //if any of the row,column or diagonal is 3 or 30 the player1 or player2 won depending on ax , zero value  else draw

        for (int i = 0; i < 8; i++)
            if (sum[i] == 3 || sum[i] == 30) {
                win++;
                if ((sum[i] == 3) && (ax == 1)) {
                    score1++;
                    TextView q1 = (TextView) findViewById(R.id.p1score);
                    q1.setText("" + score1);
                    showDialog("" + player1 + " won!");

                }
                if ((sum[i] == 3) && (zero == 1)) {
                    score2++;
                    TextView q1 = (TextView) findViewById(R.id.p2score);
                    q1.setText("" + score2);
                    showDialog("" + player2 + " won!");

                }
                if ((sum[i] == 30) && (ax == 10)) {
                    score1++;
                    TextView q1 = (TextView) findViewById(R.id.p1score);
                    q1.setText("" + score1);
                    showDialog("" + player1 + " won!");

                }
                if ((sum[i] == 30) && (zero == 10)) {
                    score2++;
                    TextView q1 = (TextView) findViewById(R.id.p2score);
                    q1.setText("" + score2);
                    showDialog("" + player2 + " won!");

                }

            }

        if ((ctrflag == 9) && (win == 0)) {
            showDialog("This is a draw !");

            drawChecker++;
        }


    }  //end winchecker()

    private void playmore() {
        if ((drawChecker > 0) || (win > 0)) {
            game++;
            TextView qq = (TextView) findViewById(R.id.gamenumber);
            qq.setText("" + game);

            for (int i = 0; i < 8; i++)
                sum[i] = 0;

            drawChecker = 0;


            ImageView q1, q2, q3, q4, q5, q6, q7, q8, q9;
            q1 = (ImageView) findViewById(R.id.tzz);
            q2 = (ImageView) findViewById(R.id.tzo);
            q3 = (ImageView) findViewById(R.id.tzt);
            q4 = (ImageView) findViewById(R.id.toz);
            q5 = (ImageView) findViewById(R.id.too);
            q6 = (ImageView) findViewById(R.id.tot);
            q7 = (ImageView) findViewById(R.id.ttz);
            q8 = (ImageView) findViewById(R.id.tto);
            q9 = (ImageView) findViewById(R.id.ttt);
            q1.setImageDrawable(null);
            q2.setImageDrawable(null);
            q3.setImageDrawable(null);
            q4.setImageDrawable(null);
            q5.setImageDrawable(null);
            q6.setImageDrawable(null);
            q7.setImageDrawable(null);
            q8.setImageDrawable(null);
            q9.setImageDrawable(null);

            for (int i = 0; i < 3; i++)
                for (int j = 0; j < 3; j++)
                    buttonPressed[i][j] = 0;

            for (int i = 0; i < 3; i++)
                for (int j = 0; j < 3; j++)
                    tracker[i][j] = 0;


            if ((game + 1) % 2 == 0)
                Toast.makeText(this, "" + player1 + "'s turn", Toast.LENGTH_SHORT).show();
            else
                Toast.makeText(this, "" + player2 + "'s turn", Toast.LENGTH_SHORT).show();
            win = 0;
            summ = 0;
            ctrflag = 0;
            flag = (game + 1) % 2;
            currentGameDoneChecker = 0;

        }
    }


    public void doreset() {

        TextView qq = (TextView) findViewById(R.id.gamenumber);
        qq.setText("" + 1);


        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                tracker[i][j] = 0;

        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                buttonPressed[i][j] = 0;

        ImageView q1, q2, q3, q4, q5, q6, q7, q8, q9;

        q1 = (ImageView) findViewById(R.id.tzz);
        q2 = (ImageView) findViewById(R.id.tzo);
        q3 = (ImageView) findViewById(R.id.tzt);
        q4 = (ImageView) findViewById(R.id.toz);
        q5 = (ImageView) findViewById(R.id.too);
        q6 = (ImageView) findViewById(R.id.tot);
        q7 = (ImageView) findViewById(R.id.ttz);
        q8 = (ImageView) findViewById(R.id.tto);
        q9 = (ImageView) findViewById(R.id.ttt);
        q1.setImageDrawable(null);
        q2.setImageDrawable(null);
        q3.setImageDrawable(null);
        q4.setImageDrawable(null);
        q5.setImageDrawable(null);
        q6.setImageDrawable(null);
        q7.setImageDrawable(null);
        q8.setImageDrawable(null);
        q9.setImageDrawable(null);


        win = 0;
        drawChecker = 0;
        summ = 0;
        resetChecker = 0;
        ctrflag = 0;
        score1 = 0;
        score2 = 0;
        game = 1;
        flag = 0;
        currentGameDoneChecker = 0;
        TextView qqq = (TextView) findViewById(R.id.p1score);
        qqq.setText("" + score1);
        TextView qqqq = (TextView) findViewById(R.id.p2score);
        qqqq.setText("" + score2);

        Toast.makeText(this, "" + player1 + "'s turn", Toast.LENGTH_SHORT).show();


    }


//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.menu_main, menu);
//        return true;
//    }

    private void showExitDialog() {
        final Dialog dialog = new Dialog(MainActivity.this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_layout_exit);
        dialog.setCancelable(false);

        dialog.show();

        Button exit = dialog.findViewById(R.id.yes_button);
        final Button dismiss = dialog.findViewById(R.id.no_button);

        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                doreset();
                finish();
            }
        });

        dismiss.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
    }

    @Override
    public void onBackPressed() {
        showExitDialog();
    }

}


