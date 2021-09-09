package com.dhairytripathi.cardcolormagic.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.dhairytripathi.cardcolormagic.R
import com.dhairytripathi.cardcolormagic.model.State

class CardColorAdapter(private val cardTitles: Array<String>,
                       private var state: State,
                       private val context: Context)
    : RecyclerView.Adapter<CardColorAdapter.CardColorViewHolder>() {


    class CardColorViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvCardTitle: TextView
        val cvCard: CardView
        init {
            tvCardTitle = view.findViewById(R.id.tv_card_title)
            cvCard = view.findViewById(R.id.cv_card)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardColorViewHolder {
        val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_card, parent, false)
        return CardColorViewHolder(view)
    }

    override fun onBindViewHolder(holder: CardColorViewHolder, position: Int) {
        holder.tvCardTitle.text = cardTitles[position]
        // If state == State.On set odd position cards to green and even position cards to red
        holder.cvCard.setCardBackgroundColor(ContextCompat.getColor(context, R.color.off))
        if ( (state == State.ON  && position % 2 != 0) || (state == State.OFF && position %2 == 0)) {
            holder.cvCard.setCardBackgroundColor(ContextCompat.getColor(context, R.color.on))
        }
        
    }

    override fun getItemCount(): Int {
        return if (cardTitles.isEmpty()) { 0 } else { cardTitles.size }
    }
}