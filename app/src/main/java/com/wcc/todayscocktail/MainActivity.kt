package com.wcc.todayscocktail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.wcc.todayscocktail.repository.CocktailsListRepository
import com.wcc.todayscocktail.viewmodel.CocktailsListViewModel
import com.wcc.todayscocktail.viewmodel.CocktailsListViewModelFactory

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewModelFactory = CocktailsListViewModelFactory(CocktailsListRepository())
        val viewModel = ViewModelProvider(this, viewModelFactory).get(CocktailsListViewModel::class.java)
        val list = viewModel.cocktailList
        list.observe(this, Observer {cocktailList ->
            if(cocktailList.isNotEmpty()) {
                findViewById<TextView>(R.id.textView).text = cocktailList[0].name.toString()
            } else {
                findViewById<TextView>(R.id.textView).text = "deu erro!!!!!"
            }
        })

    }
}