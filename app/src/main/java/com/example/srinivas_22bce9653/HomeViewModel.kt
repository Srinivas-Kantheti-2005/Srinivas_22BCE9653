package com.example.srinivas_22bce9653

import androidx.lifecycle.ViewModel

class HomeViewModel: ViewModel() {
    var count = 0

    fun IncrementCount() {
        count++
    }
}