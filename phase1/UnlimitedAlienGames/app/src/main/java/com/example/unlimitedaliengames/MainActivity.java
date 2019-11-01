package com.example.unlimitedaliengames;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.unlimitedaliengames.alienguesser.AlienGuesser;
import com.example.unlimitedaliengames.alienpainter.AlienPainter;
import com.example.unlimitedaliengames.alienshooter.AlienShooter;
import com.example.unlimitedaliengames.userdata.*;

public class MainActivity extends AppCompatActivity {

    private User currentUser;
    private UserManager userManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void goToAlienGuesser(View view) {
        // Do something in response to button
        startActivity(new Intent(this, AlienGuesser.class));
        finish();
    }

    public void goToAlienPainter(View view) {
        // Do something in response to button
        startActivity(new Intent(this, AlienPainter.class));
        finish();
    }

    public void goToAlienShooter(View view) {
        // Do something in response to button
        startActivity(new Intent(this, AlienShooter.class));
        finish();
    }

}
