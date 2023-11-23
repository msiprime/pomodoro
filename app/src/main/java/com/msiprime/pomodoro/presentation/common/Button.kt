package com.msiprime.pomodoro.presentation.common

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.ThumbUp
import com.msiprime.pomodoro.domain.TimerState
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable

@Composable
fun TimerButton(
    timerState: TimerState,
    onStartClick: () -> Unit,
    onPauseClick: () -> Unit,
    onStopClick: () -> Unit
) {
    val (icon, onClick) = when (timerState) {
        TimerState.IDLE -> Icons.Default.PlayArrow to onStartClick
        TimerState.RUNNING -> Icons.Default.Clear to onPauseClick
        TimerState.PAUSED -> Icons.Default.PlayArrow to onStartClick
        TimerState.FINISHED -> Icons.Default.ThumbUp to onStopClick
    }

    Button(onClick = onClick) {
        Icon(imageVector = icon, contentDescription = null)
    }
}
