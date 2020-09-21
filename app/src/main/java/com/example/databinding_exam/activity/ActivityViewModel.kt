package com.example.databinding_exam.activity

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.databinding_exam.model.User

class ActivityViewModel : ViewModel() {
    val user: MutableLiveData<User> = MutableLiveData()

    fun setUser(user: User) {
        this.user.value = null
        this.user.value = user
    }
}