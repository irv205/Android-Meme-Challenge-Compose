package com.kk.memechallengecompose.ui.main

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import com.kk.memechallengecompose.domain.model.Meme
import com.kk.memechallengecompose.ui.theme.MemeChallengeComposeTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MemeChallengeComposeTheme {
                val vm : MainViewModel = viewModel()
                Main(vm)
            }
        }
    }
}

@Composable
fun Main(vm : MainViewModel){

    val state = remember { vm.state }
    val context = LocalContext.current

    when(state.value){
        is MainViewState.Error -> {
            Toast.makeText(context, state.value.toString(), Toast.LENGTH_LONG).show()
        }
        MainViewState.Idle -> {}
        MainViewState.Success -> {
            ElementList(list = vm.list)
        }
        else -> {
            Toast.makeText(context, "Exception", Toast.LENGTH_LONG).show()
        }
    }

}

@Composable
fun ElementList(list: List<Meme>) {

    Box(modifier = Modifier
        .fillMaxSize()
        .wrapContentSize(Alignment.Center)){

        LazyColumn {
            items(list) { item ->
                ItemCard(meme = item)
            }
        }
    }

}