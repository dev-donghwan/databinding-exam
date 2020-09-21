package com.example.databinding_exam.model

import androidx.databinding.ObservableInt

class User(val name: String, age: Int) {
    val age: ObservableInt = ObservableInt(0)

    init {
        this.age.set(age)
    }
}