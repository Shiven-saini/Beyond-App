package com.space.beyond

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.space.beyond.screens.testViewModel
import com.space.beyond.ui.theme.BeyondTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BeyondTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->



                  val testViewModel: testViewModel = hiltViewModel()
                  val x = testViewModel.apodLiveData.collectAsState()

                    LaunchedEffect(key1 = Unit) {
                        testViewModel.fetchApod("iMQrRLiJkRbcHKhI53G5HrzmNFSxul5fRYGiC1Yp")
                    }


                    Text(text = x.value.toString(),
                        modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

