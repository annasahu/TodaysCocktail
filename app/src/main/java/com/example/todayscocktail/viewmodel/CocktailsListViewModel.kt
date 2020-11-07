package com.example.todayscocktail.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.todayscocktail.network.Cocktail
import com.example.todayscocktail.repository.CocktailsListRepository

class CocktailsListViewModel(private val repository: CocktailsListRepository): ViewModel() {
    val  cocktailList: LiveData<List<Cocktail>>
        get() = repository.cocktailList
}