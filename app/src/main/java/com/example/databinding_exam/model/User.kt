package com.example.databinding_exam.model

import androidx.databinding.ObservableField

class User(val name: String, age: String) {
    val age: ObservableField<String> = ObservableField()

    init {
        this.age.set(age)
    }
}