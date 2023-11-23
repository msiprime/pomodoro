package com.msiprime.pomodoro.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.msiprime.pomodoro.domain.TimerUseCase
import com.msiprime.pomodoro.presentation.ui.TimerScreen
import com.msiprime.pomodoro.presentation.ui.theme.PomodoroTheme
import org.koin.android.ext.android.inject

class MainActivity : ComponentActivity() {

    private val timerUseCase: TimerUseCase by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PomodoroTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    TimerScreen(timerUseCase)
                }
            }
        }
    }
}


