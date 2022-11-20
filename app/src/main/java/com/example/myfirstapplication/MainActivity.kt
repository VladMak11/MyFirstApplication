package com.example.myfirstapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        findViewById<Button>(R.id.btn_add).apply {
            setOnClickListener {
                // Неявно.
                val intent = Intent(this@MainActivity,DetailsActivity::class.java)
                this@MainActivity.startActivity(intent)
            }
        }
        val orgListAdapter = OrgListAdapter()
        findViewById<RecyclerView>(R.id.list).apply {
            adapter = orgListAdapter
            orgListAdapter.submitList(mutableListOf(User("dfdf","dfd","dfdf","hh","ggg"),
                                                    User("AAAAAA","dfd","dfdf","hh","ggg")))
            adapter?.notifyDataSetChanged()
        }

    }


}
