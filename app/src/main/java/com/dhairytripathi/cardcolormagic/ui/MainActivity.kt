package com.dhairytripathi.cardcolormagic.ui

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.GridLayoutManager
import com.dhairytripathi.cardcolormagic.R
import com.dhairytripathi.cardcolormagic.adapter.CardColorAdapter
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.item_card.*

private const val TAG = "MAIN_ACTIVITY"

class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel.onInit()
        initListener()
        initViews()
    }

    private fun initViews() {
        tv_app_title.text = this.getText(R.string.app_name)
        rv_cards.apply {
            layoutManager = GridLayoutManager(context, 3)
            setHasFixedSize(true)
        }
    }
     
    private fun initListener() {
        var cardColorAdapter: CardColorAdapter
        fab_color_change_button.setOnClickListener { _ ->
            viewModel.switchState()
        }

        viewModel.getState().observe(this) {
            cardColorAdapter = CardColorAdapter(viewModel.getCards(), it, this)
            rv_cards.adapter = cardColorAdapter
        }
    }


}