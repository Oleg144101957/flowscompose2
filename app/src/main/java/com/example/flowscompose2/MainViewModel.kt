package com.example.flowscompose2

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.flow

class MainViewModel : ViewModel() {

    val coundownFlow = flow<Int>{
        val startingValue = 10
        var currentValue = startingValue
        emit(startingValue)
        while (currentValue>0){
            delay(1000L)
            currentValue--
            emit(currentValue)
        }
    }


}