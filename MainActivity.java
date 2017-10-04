package com.example.vedaant.scarnesdice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;


public class MainActivity extends AppCompatActivity {

    private int player_score = 0;
    private int comp_score = 0;
    private int turn = 0; // 0:user
    private int temp_score = 0;

    Random r2 = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void roll(View view){
        TextView player_text_score = (TextView) findViewById(R.id.player_score);
        TextView comp_text_score = (TextView)findViewById(R.id.comp_score);
        ImageView img_dice = (ImageView)findViewById(R.id.img_dice);
        TextView user_chance = (TextView)findViewById(R.id.user_chance);
        TextView comp_chance = (TextView)findViewById(R.id.comp_chance);


        Random r = new Random();
        int dice = r.nextInt(6)+1;

        switch (dice) {
            case 1:
                img_dice.setImageResource(R.drawable.dice1);
                break;
            case 2:
                img_dice.setImageResource(R.drawable.dice2);
                break;
            case 3:
                img_dice.setImageResource(R.drawable.dice3);
                break;
            case 4:
                img_dice.setImageResource(R.drawable.dice4);
                break;
            case 5:
                img_dice.setImageResource(R.drawable.dice5);
                break;
            case 6:
                img_dice.setImageResource(R.drawable.dice6);


        }

        if(turn == 0)
        {
            //User Turn
            if(dice == 1) {
                temp_score = 0;
                hold(comp_text_score);
            }
            else
            {
                TextView running_score = (TextView) findViewById(R.id.running_score);
                temp_score += dice;
                running_score.setText(Integer.toString(temp_score));
            }
        }
        else
        {

            /*try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }*/

            int random_number = r2.nextInt(15);
            if(random_number == 5){
                hold(player_text_score);
            }
            else if(dice == 1)
            {
                temp_score = 0;
                hold(comp_text_score);
            }
            else
            {
                TextView running_score = (TextView) findViewById(R.id.running_score);
                temp_score += dice;
                running_score.setText(Integer.toString(temp_score));

                /*try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }*/

                roll(player_text_score);
            }
        }
    }

    public void hold(View view)
    {
        TextView winner = (TextView)findViewById(R.id.winner);
        TextView player_text_score = (TextView) findViewById(R.id.player_score);
        TextView comp_text_score = (TextView)findViewById(R.id.comp_score);
        TextView user_chance = (TextView)findViewById(R.id.user_chance);
        TextView comp_chance = (TextView)findViewById(R.id.comp_chance);
        Button btn_roll = (Button)findViewById(R.id.btn_roll);
        Button btn_hold = (Button)findViewById(R.id.btn_hold);



        if(player_score >=50)
        {
            winner.setText("You Win!!!");
            btn_roll.setClickable(false);
            btn_hold.setClickable(false);
            btn_hold.getBackground().setAlpha(50);
            btn_roll.getBackground().setAlpha(50);
        }
        if(comp_score>=50)
        {
            winner.setText("Computer Wins!!!");
            btn_roll.setClickable(false);
            btn_hold.setClickable(false);
            btn_hold.getBackground().setAlpha(50);
            btn_roll.getBackground().setAlpha(50);
        }
    //winner.setText("C")
        if(turn == 0)
        {
            //winner.setText("Computer's Turn!");            ]
            player_score += temp_score;
            player_text_score.setText(Integer.toString(player_score));
            temp_score = 0;
            turn = 1;
            roll(comp_text_score);
        }
        else
        {
            comp_score += temp_score;
            comp_text_score.setText(Integer.toString(comp_score));
            temp_score = 0;
            turn = 0;
            //winner.setText("User's Turn!");
        }
    }

    public void reset(View view)
    {
        player_score = 0;
        comp_score = 0;
        temp_score = 0;
        TextView player_text_score = (TextView) findViewById(R.id.player_score);
        TextView comp_text_score = (TextView)findViewById(R.id.comp_score);
        TextView current_score = (TextView)findViewById(R.id.running_score);
        TextView winner = (TextView)findViewById(R.id.winner );
        Button btn_roll = (Button)findViewById(R.id.btn_roll);
        Button btn_hold = (Button)findViewById(R.id.btn_hold);

        btn_roll.setClickable(true);
        btn_hold.setClickable(true);
        btn_hold.getBackground().setAlpha(240);
        btn_roll.getBackground().setAlpha(240);
        winner.setText("Hello");
        player_text_score.setText("0");
        comp_text_score.setText("0");
        current_score.setText("0");
    }
}
