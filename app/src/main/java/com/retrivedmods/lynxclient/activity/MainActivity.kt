package com.retrivedmods.lynxclient.activity

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.ExperimentalFoundationApi
import com.retrivedmods.lynxclient.navigation.Navigation
import com.retrivedmods.lynxclient.ui.theme.MuCuteClientTheme


class MainActivity : ComponentActivity() {

    @OptIn(ExperimentalFoundationApi::class)
    @SuppressLint("BatteryLife")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MuCuteClientTheme {
                Navigation()
            }
        }
    }

}