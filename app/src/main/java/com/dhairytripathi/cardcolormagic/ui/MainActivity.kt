package com.dhairytripathi.cardcolormagic.ui

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.dhairytripathi.cardcolormagic.R
import com.dhairytripathi.cardcolormagic.adapter.CardColorAdapter
import kotlinx.android.synthetic.main.activity_main.*

private const val TAG = "MAIN_ACTIVITY"

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val viewModel: MainViewModel by viewModels()
        viewModel.onInit()
        var cardColorAdapter: CardColorAdapter;

        rv_cards.apply {
            layoutManager = GridLayoutManager(context, 3)
            setHasFixedSize(true)
        }

        fab_color_change_button.setOnClickListener { _ ->
            viewModel.switchState()
        }

        viewModel.getState().observe(this) {
            cardColorAdapter = CardColorAdapter(viewModel.getCards(), it, this)
            rv_cards.adapter = cardColorAdapter
        }
    }


}