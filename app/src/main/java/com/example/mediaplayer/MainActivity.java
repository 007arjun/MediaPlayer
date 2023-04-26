package com.example.mediaplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    private Button START,STOP,PAUSE;
    private SeekBar seekBar;
    private MediaPlayer player;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        START = findViewById(R.id.button1);
        PAUSE = findViewById(R.id.button2);
        STOP = findViewById(R.id.button3);
        seekBar = findViewById(R.id.seekBar);
        player = MediaPlayer.create(this,R.raw.tom);
        START.setOnClickListener(new View.OnClickListener()
        {
            @Override
                    public void onClick(View v){
                player.start();
            }

        });
        PAUSE.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v){
                player.pause();
            }

        });
        STOP.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v){
                player.stop();
            }

        });
        seekBar.setMax(player.getDuration());
        new Timer().scheduleAtFixedRate(new TimerTask(){
            @Override
                    public void run() {
                seekBar.setProgress(player.getCurrentPosition());
            }
        },0,30000);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            player.seekTo(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {


            }

        });

    }

}