package com.msiprime.pomodoro.data

import com.msiprime.pomodoro.domain.TimerState
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow

class TimerRepositoryImpl : TimerRepository {
    private val timerStateFlow = MutableStateFlow(TimerState.IDLE)
    private val elapsedTimeFlow = MutableStateFlow(0L)

    override suspend fun getTimerState(): Flow<TimerState> = timerStateFlow
    override suspend fun getElapsedTime(): Flow<Long> = elapsedTimeFlow

    override suspend fun startTimer() {
        timerStateFlow.value = TimerState.RUNNING
        for (i in 1..10) {
            delay(1000)
            elapsedTimeFlow.value = i.toLong()
        }
        timerStateFlow.value = TimerState.FINISHED
    }

    override suspend fun pauseTimer() {
        timerStateFlow.value = TimerState.PAUSED
    }

    override suspend fun stopTimer() {
        timerStateFlow.value = TimerState.IDLE
        elapsedTimeFlow.value = 0L
    }
}
