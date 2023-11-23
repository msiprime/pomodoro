package com.msiprime.pomodoro.domain

import com.msiprime.pomodoro.data.TimerRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import kotlinx.coroutines.flow.flow

class TimerUseCaseImpl(private val timerRepository: TimerRepository) : TimerUseCase {

    private val coroutineScope = CoroutineScope(Dispatchers.Main) // or Dispatchers.IO, depending on your use case

    override val timerState: Flow<TimerState> = flow {
        timerRepository.getTimerState().collect { emit(it) }
    }

    override val elapsedTime: Flow<Long> = flow {
        timerRepository.getElapsedTime().collect { emit(it) }
    }

    override fun startTimer() {
        coroutineScope.launch {
            timerRepository.startTimer()
        }
    }

    override fun pauseTimer() {
        coroutineScope.launch {
            timerRepository.pauseTimer()
        }
    }

    override fun stopTimer() {
        coroutineScope.launch {
            timerRepository.stopTimer()
        }
    }
}
