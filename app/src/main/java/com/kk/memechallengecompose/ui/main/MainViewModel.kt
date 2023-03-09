package com.kk.memechallengecompose.ui.main

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kk.memechallengecompose.core.utils.ResponseHandler
import com.kk.memechallengecompose.data.repository.RepositoryImp
import com.kk.memechallengecompose.domain.model.Meme
import com.kk.memechallengecompose.domain.repository.IRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository : RepositoryImp) : ViewModel() {

    private val _state = mutableStateOf<MainViewState?>(MainViewState.Idle)
    val state : State<MainViewState?> get() = _state

    private val _list = mutableStateListOf<Meme>()
    val list : SnapshotStateList<Meme> get() = _list

    init {
        getMemes()
    }

    private fun getMemes(){
        viewModelScope.launch(Dispatchers.IO){
            when(val result = repository.getMemes()){
                is ResponseHandler.Error -> {
                    _state.value = MainViewState.Error(result.message)
                }
                is ResponseHandler.Success -> {
                    _state.value = MainViewState.Success
                    _list.clear()
                    _list.addAll(result.data)
                }
            }
        }
    }
}