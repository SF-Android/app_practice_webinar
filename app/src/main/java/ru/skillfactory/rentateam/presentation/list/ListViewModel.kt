package ru.skillfactory.rentateam.presentation.list

import android.annotation.SuppressLint
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import ru.skillfactory.rentateam.domain.model.User
import ru.skillfactory.rentateam.domain.repository.UsersRepository
import javax.inject.Inject

@HiltViewModel
class ListViewModel
@Inject constructor(
    private val repository: UsersRepository
) : ViewModel() {

    private val users = MutableLiveData<List<User>>()

    init {
        loadUsers()
    }

    fun getUsers(): LiveData<List<User>> {
        return users
    }

    @SuppressLint("CheckResult")
    private fun loadUsers() {
        repository.getUsers()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {
                    users.value = it
                },
                { error ->
                    Log.e("", error.toString())
                }
            )
    }
}