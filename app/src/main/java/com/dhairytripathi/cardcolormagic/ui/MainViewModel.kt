package com.dhairytripathi.cardcolormagic.ui

import android.app.Activity
import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import android.util.Log
import androidx.core.content.ContextCompat
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.dhairytripathi.cardcolormagic.R
import com.dhairytripathi.cardcolormagic.model.State

class MainViewModel(application: Application) : AndroidViewModel(application) {

    private var currentState = MutableLiveData<State>()
    private lateinit var cards: Array<String>
    private lateinit var sharedPref: SharedPreferences

    fun onInit() {
        sharedPref = getApplication<Application>().getSharedPreferences("State", Context.MODE_PRIVATE)
        getSavedState()
        cards = arrayOf(
            "Alpha",
            "Beta",
            "Cat",
            "Doremon",
            "Elephant",
            "Alpha",
            "Fantom",
            "Goal",
            "Helina",
            "India",
            "Jem",
            "Kite",
            "Local",
            "Machine",
            "Note"
        )
    }

    fun getState(): MutableLiveData<State> {
        return currentState
    }

    fun getCards(): Array<String> {
        return cards
    }

    fun switchState() {
        if (currentState.value == State.ON) {
            currentState.value = State.OFF
        } else {
            currentState.value = State.ON
        }
        saveState()
    }

    private fun getSavedState() {
        if (sharedPref.contains("State")) {
            if (sharedPref.getString("State", "ON") == "OFF") {
                currentState.value = State.OFF
            } else {
                currentState.value = State.ON
            }
        }
    }

    private fun saveState() {
        val editor = sharedPref.edit()
        editor.putString("State", currentState.value.toString())
        editor.apply()

    }
}