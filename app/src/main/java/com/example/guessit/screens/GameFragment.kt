package com.example.guessit.screens

import android.os.Bundle
import android.text.format.DateUtils
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import com.example.guessit.R
import com.example.guessit.databinding.GameFragmentBinding

class GameFragment : Fragment() {

    private lateinit var viewModel: GameViewModel
    private lateinit var binding: GameFragmentBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
         binding = DataBindingUtil.inflate(inflater, R.layout.game_fragment,container,false)
        Log.i("GameFragment","ViewModelProviders")
        viewModel = ViewModelProviders.of(this).get(GameViewModel::class.java)


        binding.correctButton.setOnClickListener {
            viewModel.onCorrect()
            viewModel.nextWord()
            //  updateScoreText()
            // updateWordText()
        }
        binding.skipButton.setOnClickListener {
            viewModel.onSkip()
            viewModel.nextWord()
            //  updateScoreText()
            //  updateWordText()
        }
        //   updateScoreText()
        viewModel.word.observe(viewLifecycleOwner, Observer { newWord ->
            binding.wordText.text = newWord
        })
        viewModel.score.observe(viewLifecycleOwner, Observer { newScore ->
            binding.scoreText.text = newScore.toString()
        })

        viewModel.currentTime.observe(viewLifecycleOwner, Observer { newTime->
            binding.timerText.text = DateUtils.formatElapsedTime(newTime)
        })
        viewModel.eventGameFinish.observe(viewLifecycleOwner, Observer { hasFinished->
            if (hasFinished){
                gameFinished()
                viewModel.onGameFinishCompleted()
            }
        })
        // updateWordText()
        return binding.root
    }

    /**
     * Called when the game is finished
     */
    private fun gameFinished() {
       // val action = GameFragmentDirections.actionGameToScore()
      //  action.setScore(viewModel.score.value ?: 0)
        Toast.makeText(this.activity,"game finished",Toast.LENGTH_SHORT).show()
        val currentScore = viewModel.score.value ?:0
       // val action = GameFragmentDirections.actionGameToScore(currentScore)
      //  findNavController().navigate(action)
    }


    /* */
    /** Methods for updating the UI **//*

    private fun updateWordText() {
        binding.wordText.text = viewModel.word

    }
*/
}
