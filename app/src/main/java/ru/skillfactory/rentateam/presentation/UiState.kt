package ru.skillfactory.rentateam.presentation

sealed class UiState<out T> {
    data class Success<out T>(val value: T) : UiState<T>()
    data class Failure(
        val exception: Throwable?
    ) : UiState<Nothing>()

    object Loading : UiState<Nothing>()
}
