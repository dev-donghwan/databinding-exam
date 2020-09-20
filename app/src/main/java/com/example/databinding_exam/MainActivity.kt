package com.example.databinding_exam

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.databinding.ObservableField
import com.example.databinding_exam.databinding.ActivityMainBinding
import com.example.databinding_exam.model.User

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //아래와 같이 두가지 방법이 사용가능하다.
        //binding = ActivityMainBinding.inflate(layoutInflater)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.activity = this@MainActivity
        binding.user = User("donghwan", ObservableField("0"))
    }

    fun onButtonClick(user: User, age: String) {
        user.age = ObservableField(age)
        showToast(age)
    }

    private fun showToast(msg: String) {
        Toast.makeText(this@MainActivity, msg, Toast.LENGTH_SHORT).show()
    }
}