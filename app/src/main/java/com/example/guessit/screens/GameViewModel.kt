package com.example.guessit.screens

import android.util.Log
import androidx.lifecycle.ViewModel

class GameViewModel : ViewModel() {
    init {
        Log.i("GameModel","GameViewModel created")
    }

    override fun onCleared() {
        super.onCleared()
        Log.i("GameModel","destroyed")
    }
}