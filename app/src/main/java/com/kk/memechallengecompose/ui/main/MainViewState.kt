package com.kk.memechallengecompose.ui.main

sealed class MainViewState{
    object Idle : MainViewState()
    object Success : MainViewState()
    class Error(val message : String) : MainViewState()
}