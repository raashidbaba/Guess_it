package com.example.guessit.score

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.guessit.R
import com.example.guessit.databinding.ScoreFragmentBinding

class ScoreFragment :Fragment(){
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<ScoreFragmentBinding>(inflater, R.layout.score_fragment,container,false)
        // Get args using by navArgs property delegate
        val scoreFragmentArgs by navArgs<ScoreFragmentArgs>()
        binding.scoreText.text = scoreFragmentArgs.score.toString()
        binding.playAgainButton.setOnClickListener { onPlayAgain() }
        return binding.root
    }
    private fun onPlayAgain() {
        findNavController().navigate(ScoreFragmentDirections.actionRestart())
    }
}