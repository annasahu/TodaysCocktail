package com.example.todayscocktail.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View.inflate
import android.widget.ImageView
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.todayscocktail.R
import com.example.todayscocktail.databinding.ActivityMainBinding
import com.example.todayscocktail.network.Cocktail
import com.example.todayscocktail.repository.CocktailsListRepository
import com.example.todayscocktail.viewmodel.CocktailsListViewModel
import com.example.todayscocktail.viewmodel.CocktailsListViewModelFactory

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        val recycleView = binding.itemsRecyclerView
        val adapter = CocktailsAdapter()
        recycleView.adapter = adapter

        val viewModelFactory = CocktailsListViewModelFactory(CocktailsListRepository())
        val viewModel = ViewModelProvider(this, viewModelFactory).get(CocktailsListViewModel::class.java)
        val list = viewModel.cocktailList

        val cocktailsItems = viewModel.cocktailList
        cocktailsItems.observe(this, Observer { adapter.dataList = it })
    }
}