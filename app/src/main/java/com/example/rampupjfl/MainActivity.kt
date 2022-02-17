package com.example.rampupjfl

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.rampupjfl.adapter.ItemAdapter
import com.example.rampupjfl.data.DataSource
import com.example.rampupjfl.model.Item
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private val myDataSet = DataSource().generateDummyList(10)
    private val adapter = ItemAdapter(this, myDataSet)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // Initialize data.
        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        // Use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        recyclerView.setHasFixedSize(true)
        val fab: View = findViewById(R.id.fab)
        fab.setOnClickListener { view ->
            Snackbar.make(view, "Item add at position", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
            insertItem(fab)
        }
    }

    fun insertItem(view: View) {
        val index = Random.nextInt(8)
        val newIntem = Item(
            R.drawable.ic_android, "New item at position $index",
            "Line 2"
        )
        myDataSet.add(index, newIntem)
        adapter.notifyItemInserted(index)

    }

    fun removeItem(view: View) {
        val index = Random.nextInt(8)
        myDataSet.removeAt(index)
        adapter.notifyItemRemoved(index)
    }
}