package com.msiprime.pomodoro.presentation.ui


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.MaterialTheme
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.msiprime.pomodoro.domain.TimerState
import com.msiprime.pomodoro.domain.TimerUseCase
import com.msiprime.pomodoro.presentation.common.TimerButton
import kotlinx.coroutines.launch

@Composable
fun TimerScreen(timerUseCase: TimerUseCase) {
    var elapsedTime by remember { mutableStateOf(0L) }
    var timerState by remember { mutableStateOf(TimerState.IDLE) }

    val coroutineScope = rememberCoroutineScope()

    LaunchedEffect(timerState) {
        timerUseCase.timerState.collect {
            timerState = it
        }
    }

    LaunchedEffect(elapsedTime) {
        timerUseCase.elapsedTime.collect {
            elapsedTime = it
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Pomodoro Timer",
            style = MaterialTheme.typography.h4
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Elapsed Time: $elapsedTime seconds",
            style = MaterialTheme.typography.body1
        )

        Spacer(modifier = Modifier.height(16.dp))

        TimerButton(
            timerState = timerState,
            onStartClick = { coroutineScope.launch { timerUseCase.startTimer() } },
            onPauseClick = { coroutineScope.launch { timerUseCase.pauseTimer() } },
            onStopClick = { coroutineScope.launch { timerUseCase.stopTimer() } }
        )
    }
}
