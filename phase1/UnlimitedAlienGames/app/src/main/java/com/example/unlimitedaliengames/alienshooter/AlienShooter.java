package com.example.unlimitedaliengames.alienshooter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.unlimitedaliengames.R;

import java.util.ArrayList;
import java.util.List;

public class AlienShooter extends AppCompatActivity implements AlienShooterView,
        View.OnClickListener {
    private AlienShooterPresenter presenter;
    private static final int numOfAliens = 9;
    //timer
    private Timer timer;
    private TextView timer_text;
    private Button timer_button;

    private List<View> aliens;
    private TextView instructionTitle;
    private TextView instructions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alien_shooter);
        instructions = findViewById(R.id.instructions);
        instructionTitle = findViewById(R.id.instructionTitle);
        aliens = new ArrayList<>();
        generateAliens();
        generateOnClickListener();
        timer_text = findViewById(R.id.alienTimer);
        timer = new Timer(this);
        timer_button = findViewById(R.id.timer_button);
        timer_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!timer.getIsActive()) {
                    startTimer();
                    setVisibility();
                    presenter.randomizeAliens(aliens);
                }
            }
        });

        presenter = new AlienShooterPresenter(this, new AlienShooterManager(), timer);
    }

    private void generateAliens() {
        for (int i = 1; i <= numOfAliens; i++) {
            String temp = "imageButton" + i;
            int tempID = getResources().getIdentifier(temp, "id", getPackageName());
            aliens.add(findViewById(tempID));
        }
    }

    private void generateOnClickListener() {
        for (int i = 0; i < numOfAliens; i++) {
            aliens.get(i).setOnClickListener(this);
        }
    }

    private void setVisibility(){
        instructionTitle.setVisibility(View.INVISIBLE);
        instructions.setVisibility(View.INVISIBLE);
        for (View alien: aliens){
            alien.setVisibility(View.VISIBLE);
        }
    }
    private void startTimer() {
        String temp = "Game in Progress";
        timer_button.setText(temp);
        timer.setActive(true);
        timer.start();
    }

    @Override
    public void resetTimer() {
        String temp = "Retry Game";
        timer_button.setText(temp);
        timer.setActive(false);
    }

    @Override
    public void updateTimer(String text) {
        timer_text.setText(text);
    }

    /**
     * Called when a view has been clicked.
     *
     * @param v The view that was clicked.
     */
    @Override
    public void onClick(View v) {
        if (timer.getIsActive()) {
            presenter.clickedAlien(aliens);
        }
    }
}
