package com.example.guessit.screens

import android.os.CountDownTimer
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class GameViewModel : ViewModel() {
    companion object {
        // These represent different important times
        // This is when the game is over
        const val DONE = 0L
        // This is the number of milliseconds in a second
        const val ONE_SECOND = 1000L
        // This is the total time of the game
        const val COUNTDOWN_TIME = 60000L
    }
    private val timer:CountDownTimer
    private val _word = MutableLiveData<String>()
    val word : LiveData<String>
    get() = _word

    private val _score = MutableLiveData<Int>()
    val score : LiveData<Int>
    get() = _score

    // The list of words - the front of the list is the next word to guess
    private lateinit var wordList: MutableList<String>

    private val _eventGameFinish = MutableLiveData<Boolean>()
    val eventGameFinish : LiveData<Boolean>
    get() = _eventGameFinish


    private val _currentTime = MutableLiveData<Long>()
    val currentTime : LiveData<Long>
    get() = _currentTime


    init {
        _eventGameFinish.value = false
        _score.value = 0
        _word.value = ""
        resetList()
        nextWord()
        Log.i("GameModel","GameViewModel created")

        timer = object : CountDownTimer(COUNTDOWN_TIME, ONE_SECOND) {

            override fun onTick(millisUntilFinished: Long) {
                // TODO implement what should happen each tick of the timer
            }

            override fun onFinish() {
                // TODO implement what should happen when the timer finishes
            }
        }

        timer.start()
    }

    override fun onCleared() {
        super.onCleared()
        Log.i("GameModel","destroyed")
    }
    /**
     * Resets the list of words and randomizes the order
     */
    private fun resetList() {
        wordList = mutableListOf(
            "queen",
            "hospital",
            "basketball",
            "cat",
            "change",
            "snail",
            "soup",
            "calendar",
            "sad",
            "desk",
            "guitar",
            "home",
            "railway",
            "zebra",
            "jelly",
            "car",
            "crow",
            "trade",
            "bag",
            "roll",
            "bubble"
        )
        wordList.shuffle()
    }

    /**
     * Moves to the next word in the list
     */
     fun nextWord() {
        //Select and remove a word from the list
        if (wordList.isEmpty()) {
            resetList()
           // _eventGameFinish.value = true
            //gameFinished()
        }
            _word.value = wordList.removeAt(0)

    }
    /** Methods for buttons presses **/

     fun onSkip() {
        _score.value = (score.value)?.minus(1)
        nextWord()
    }

     fun onCorrect() {
        _score.value = (score.value)?.plus(1)
        nextWord()
    }
    fun onGameFinishCompleted(){
        _eventGameFinish.value = false
    }
}