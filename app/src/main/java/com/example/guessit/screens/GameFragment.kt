package com.example.guessit.screens

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.guessit.R
import com.example.guessit.databinding.GameFragmentBinding

class GameFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<GameFragmentBinding>(inflater, R.layout.game_fragment,container,false)
        return binding.root
    }
}