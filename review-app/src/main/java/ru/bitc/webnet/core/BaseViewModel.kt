package ru.bitc.webnet.core

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

/**
 *
 */
abstract class BaseViewModel : ViewModel() {

    fun launch(block: suspend () -> Unit) {
        viewModelScope.launch {
            block.invoke()
        }
    }

}

