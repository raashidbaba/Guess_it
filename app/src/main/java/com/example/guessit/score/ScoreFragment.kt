package com.example.guessit.score

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.lifecycle.get
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.guessit.R
import com.example.guessit.databinding.ScoreFragmentBinding

class ScoreFragment :Fragment(){
    private lateinit var viewModel : ScoreViewModel
    private lateinit var viewModelFactory: ScoreViewModelFactory
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<ScoreFragmentBinding>(inflater, R.layout.score_fragment,container,false)
        // Get args using by navArgs property delegate
        val scoreFragmentArgs by navArgs<ScoreFragmentArgs>()
      /*  viewModelFactory = ScoreViewModelFactory(ScoreFragmentArgs.fromBundle(arguments).score)
       // viewModel = ViewModelProvider(this,viewModelFactory).get(ScoreViewModel::class.java)
        viewModel = ViewModelProviders.of(this, viewModelFactory)
            .get(ScoreViewModel::class.java)*/
        binding.scoreText.text = scoreFragmentArgs.score.toString()
        binding.playAgainButton.setOnClickListener { onPlayAgain() }
        return binding.root
    }
    private fun onPlayAgain() {
        findNavController().navigate(ScoreFragmentDirections.actionRestart())
    }
}