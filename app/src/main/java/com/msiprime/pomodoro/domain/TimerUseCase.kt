package com.msiprime.pomodoro.domain
import kotlinx.coroutines.flow.Flow


interface TimerUseCase {
    val timerState: Flow<TimerState>
    val elapsedTime: Flow<Long>

    fun startTimer()
    fun pauseTimer()
    fun stopTimer()
}

