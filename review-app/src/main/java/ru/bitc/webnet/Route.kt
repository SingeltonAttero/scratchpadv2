package ru.bitc.webnet

sealed interface Route {
    sealed class BottomMenu(val route: String) {
        object FlowInterview : BottomMenu("interview")
        object Report : BottomMenu("report")
    }
}