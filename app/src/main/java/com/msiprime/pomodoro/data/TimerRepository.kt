package com.msiprime.pomodoro.data

import com.msiprime.pomodoro.domain.TimerState
import kotlinx.coroutines.flow.Flow
interface TimerRepository {
    suspend fun getTimerState(): Flow<TimerState>
    suspend fun getElapsedTime(): Flow<Long>
    suspend fun startTimer()
    suspend fun pauseTimer()
    suspend fun stopTimer()
}




