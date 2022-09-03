package com.example.flowscompose2

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    val coundownFlow = flow<Int> {
        val startingValue = 10
        var currentValue = startingValue
        emit(startingValue)
        while (currentValue > 0) {
            delay(1000L)
            currentValue--
            emit(currentValue)
        }
    }

    init {
        collectFlow()
    }

    private fun collectFlow() {
        viewModelScope.launch {
            coundownFlow
                .filter {
                    it % 2 == 0
                }
                .map { it * 10 }
                .collect { time ->
                delay(1500L)
                println("Current time is $time")
            }
        }
    }
}