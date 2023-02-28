package ru.bitc.webnet

sealed interface Route {
    val navigate: String

    object MainApp : Route {
        override val navigate: String
            get() = "MainApp"
    }

    object DetailedInterview : Route {
        override val navigate: String
            get() = "DetailedInterview/{$key}"

        val key: String = "interviewId"

        fun openDetailed(interviewId: String): String {
            return "DetailedInterview/$interviewId"
        }
    }

    sealed class BottomMenu(val navigate: String) {
        object FlowInterview : BottomMenu("interview")
        object Report : BottomMenu("report")
    }


}