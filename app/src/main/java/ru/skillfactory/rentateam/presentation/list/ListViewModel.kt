package ru.skillfactory.rentateam.presentation.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import ru.skillfactory.rentateam.domain.model.User
import javax.inject.Inject

@HiltViewModel
class ListViewModel
@Inject constructor(

) : ViewModel(){

    private val users = MutableLiveData<List<User>>()

    fun getUsers(): LiveData<List<User>> {
        return users
    }
}