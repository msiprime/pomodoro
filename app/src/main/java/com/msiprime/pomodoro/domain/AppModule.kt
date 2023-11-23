package com.msiprime.pomodoro.domain


import com.msiprime.pomodoro.data.TimerRepository
import com.msiprime.pomodoro.data.TimerRepositoryImpl
import com.msiprime.pomodoro.domain.TimerUseCase
import com.msiprime.pomodoro.domain.TimerUseCaseImpl
import org.koin.dsl.module

val appModule = module {
    single<TimerRepository> { TimerRepositoryImpl() }
    single<TimerUseCase> { TimerUseCaseImpl(get()) }
}
