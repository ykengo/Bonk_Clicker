package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public int level = 1;
    MediaPlayer click;
    MediaPlayer level_click;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
       getSupportActionBar() .hide();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        click = MediaPlayer.create(this, R.raw.bonk); //звуки для перехода нс след уровень
        level_click = MediaPlayer.create(this, R.raw.brokencrystal );
    }

    public void buttonAction(View view) {
        TextView text = findViewById(R.id.TextView);
        String text2 = text.getText().toString();
        int number = Integer.parseInt(text2);
        number = number + 1;
        text.setText(String.valueOf(number));
        click.seekTo(300);
        click.start( );

        ImageView bonk_image = findViewById(R.id.imageView4);
        Animation bonk_animation = AnimationUtils.loadAnimation(this, R.anim.animat);
        bonk_image.startAnimation(bonk_animation);

        if(number > (50 * level * level) ){



            Button nextLvlButton = findViewById(R.id.button2);
            nextLvlButton.setVisibility(View.VISIBLE);
        }
    }

    public void nextLevelAction(View view) //Создание счетчика уровней
    {
        ImageView bonk_level = findViewById(R.id.imageView4);
        Animation level_up = AnimationUtils.loadAnimation(this, R.anim.alpha);
        bonk_level.startAnimation(level_up);
        TextView text = findViewById(R.id.TextView);
        level_click.start();
        level_click.seekTo(500 );
        text.setText(String.valueOf(0));
        level=level + 1;
        Button nextLvlButton = findViewById(R.id.button2);
        nextLvlButton.setVisibility(View.GONE);
        text = findViewById(R.id.textView3 );
        text.setText("Уровень " + String.valueOf(level));
    }
}
