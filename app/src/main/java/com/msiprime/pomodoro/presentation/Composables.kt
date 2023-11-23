//package com.msiprime.pomodoro.presentation
//
//import androidx.compose.foundation.layout.Column
//import androidx.compose.foundation.layout.Spacer
//import androidx.compose.foundation.layout.fillMaxSize
//import androidx.compose.foundation.layout.height
//import androidx.compose.foundation.layout.padding
//import androidx.compose.material3.Button
//import androidx.compose.material3.Card
//import androidx.compose.material3.MaterialTheme
//import androidx.compose.material3.Text
//import androidx.compose.runtime.Composable
//import androidx.compose.runtime.mutableStateOf
//import androidx.compose.runtime.remember
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.tooling.preview.Preview
//import androidx.compose.ui.unit.dp
//import com.msiprime.pomodoro.presentation.ui.theme.PomodoroTheme
//
//
//@Composable
//fun Pomodoro() {
//    TimerScreen()
//}
//@Composable
//fun TimerScreen() {
//    val workTime = remember { mutableStateOf("15:25") }
//    val restTime = remember { mutableStateOf("04:12") }
//
//    Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {
//        TimerCard(time = workTime.value, label = "Work Mode", buttonLabel = "Pause")
//        Spacer(modifier = Modifier.height(16.dp))
//        TimerCard(time = restTime.value, label = "Rest", buttonLabel = "Resume")
//    }
//}
//
//@Composable
//fun TimerCard(time: String, label: String, buttonLabel: String) {
//    Card(modifier = Modifier.padding(16.dp)) {
//        Column(horizontalAlignment = Alignment.CenterHorizontally) {
//            Text(text = time, style = MaterialTheme.typography.headlineLarge)
//            Text(text = label, style = MaterialTheme.typography.titleSmall)
//            Button(onClick = { /* Handle button click */ }) {
//                Text(text = buttonLabel)
//            }
//        }
//    }
//}
//
//@Preview
//@Composable
//fun TimerCardPreview() {
//    PomodoroTheme {
//        TimerCard(time = "10:45", label = "ok", buttonLabel = "label")
//    }
//}
//
//@Preview(showSystemUi = true)
//@Composable
//fun TimerScreenPreview() {
//    PomodoroTheme {
//        TimerScreen()
//    }
//}