package com.example.rampupjfl.data

import com.example.rampupjfl.R
import com.example.rampupjfl.model.Affirmation
import com.example.rampupjfl.model.Item

class DataSource {


    fun loadAffirmations(): List<Affirmation> {
        return listOf<Affirmation>(
            Affirmation(R.string.affirmation1),
            Affirmation(R.string.affirmation2),
            Affirmation(R.string.affirmation3),
            Affirmation(R.string.affirmation4),
            Affirmation(R.string.affirmation5),
            Affirmation(R.string.affirmation6),
            Affirmation(R.string.affirmation7),
            Affirmation(R.string.affirmation8),
            Affirmation(R.string.affirmation9),
            Affirmation(R.string.affirmation10)
        )
    }

    fun generateDummyList(size: Int): ArrayList<Item> {
        val list = ArrayList<Item>()

        for (i in 0 until size) {
            val drawble = when (i % 3) {
                0 -> R.drawable.ic_android
                1 -> R.drawable.ic_audio
                else -> R.drawable.ic_phone
            }
            val item = Item(drawble, "item $i", "Line 2")
            list += item
        }
        return list
    }
}