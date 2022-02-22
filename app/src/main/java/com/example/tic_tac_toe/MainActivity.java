package com.example.tic_tac_toe;

import androidx.appcompat.app.AppCompatActivity;
import androidx.gridlayout.widget.GridLayout;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    //0: dog  and   1:cat
    int End=0;
    int Flag=0;
    int[] current = {-1,-1,-1,-1,-1,-1,-1,-1,-1};
    int[][] winPositions={{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};
    int player=0;
    public void dropIn(View view){
        ImageView counter =(ImageView) view;
        if(Flag==0) {
            int tappedCounter = Integer.parseInt(counter.getTag().toString());
            if(current[tappedCounter]==-1) {

                current[tappedCounter] = player;
                counter.setTranslationY(-1500);
                if (player == 0) {
                    counter.setImageResource(R.drawable.d);
                    player = 1;
                } else {
                    counter.setImageResource(R.drawable.c);
                    player = 0;
                }
                counter.animate().translationYBy(1500).setDuration(300);
                for (int[] w : winPositions) {
                    if (current[w[0]] == current[w[1]] && current[w[0]] == current[w[2]] && current[w[0]] != -1) {
                        Flag = 1;
                        String winner = "";
                        if (player == 1) {
                            winner = " All Dogs Wag Their Tails";
                        }
                        if(player==0 ){
                            winner = "Cats Always Slay";
                        }
                        Toast.makeText(this, winner + ",It Won !", Toast.LENGTH_LONG).show();
                        Button play_again = (Button) findViewById(R.id.button1);
                        TextView winnerTextView = (TextView) findViewById(R.id.WinnertextView);
                        winnerTextView.setText(winner + ", It Won ");
                        play_again.setVisibility(View.VISIBLE);
                        winnerTextView.setVisibility(View.VISIBLE);
                        GridLayout gridLayout=(GridLayout) findViewById(R.id.grid1);
                        if(player==0) {
                            gridLayout.setBackgroundResource(R.drawable.c);
                        }
                        if(player==1){
                            gridLayout.setBackgroundResource(R.drawable.d);
                        }
                        End=1;


                    }
                }
                if(End==0) {
                    if (current[0] != -1 && current[1] != -1 && current[2] != -1 && current[3] != -1 && current[4] != -1 && current[5] != -1 && current[6] != -1 && current[7] != -1 && current[8] != -1) {
                        Toast.makeText(this, "It's a Draw ", Toast.LENGTH_LONG).show();
                        Button play_again = (Button) findViewById(R.id.button1);
                        TextView winnerTextView = (TextView) findViewById(R.id.WinnertextView);
                        winnerTextView.setText("It's a Draw ");
                        play_again.setVisibility(View.VISIBLE);
                        winnerTextView.setVisibility(View.VISIBLE);

                    }
                }

            }
        }

    }
    public void button1(View view){
        Button play_again= (Button)  findViewById(R.id.button1);
        TextView winnerTextView=(TextView) findViewById(R.id.WinnertextView);
        play_again.setVisibility(View.INVISIBLE);
        winnerTextView.setVisibility(View.INVISIBLE);
        Flag=0;
        current = new int[]{-1, -1, -1, -1, -1, -1, -1, -1, -1};
        player=0;
        GridLayout gridLayout=(GridLayout) findViewById(R.id.grid1);
        End=0;
        for(int i=0;i<gridLayout.getChildCount();i++){
            ImageView counter=(ImageView) gridLayout.getChildAt(i);
            counter.setImageDrawable(null);
        }
        gridLayout.setBackgroundResource(R.drawable.grid);


    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}