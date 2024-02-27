package com.example.gingercoffee

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ItemsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_items)
        val itemsList: RecyclerView = findViewById(R.id.itemsList)
        val items = arrayListOf<Item>()
        items.add(Item(0,"capuc","Капучино","Приятный кофейный напиток с слегка горячим молоком","мне нужно, чтобы он отображался",150))
        items.add(Item(1,"american","Американо","Приятный кофейный напиток с кипятком","Американо. Здесь может быть абсолютно любой текст",140))
        items.add(Item(2,"latte","Латте","Приятный кофейный напиток с горячим молоком","Латте. Здесь может быть абсолютно любой текст",160))
            itemsList.layoutManager = LinearLayoutManager(this)
            itemsList.adapter = ItemsAdapter(items,this)
    }
} 