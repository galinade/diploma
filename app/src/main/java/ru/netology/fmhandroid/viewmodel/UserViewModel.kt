package ru.netology.fmhandroid.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import ru.netology.fmhandroid.dto.User
import ru.netology.fmhandroid.repository.userRepository.UserRepository
import javax.inject.Inject

@HiltViewModel
class UserViewModel @Inject constructor(
    private val userRepository: UserRepository
) : ViewModel() {
    val dataUser: Flow<List<User>>
        get() = userRepository.data

    init {
        viewModelScope.launch {
            userRepository.getAllUsers()
        }
    }
}