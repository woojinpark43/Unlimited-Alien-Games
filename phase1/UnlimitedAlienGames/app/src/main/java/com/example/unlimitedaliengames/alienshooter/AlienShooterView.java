package com.example.unlimitedaliengames.alienshooter;

import android.view.View;

interface AlienShooterView {
    void resetTimer();

    void updateTimer(String text);

    void updatePoints(int p);

}
