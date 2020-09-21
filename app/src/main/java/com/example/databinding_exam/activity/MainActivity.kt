package com.example.databinding_exam.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.example.databinding_exam.R
import com.example.databinding_exam.databinding.ActivityMainBinding
import com.example.databinding_exam.model.User

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val vm: ActivityViewModel by lazy { ActivityViewModel() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //아래와 같이 두가지 방법이 사용가능하다.
        //binding = ActivityMainBinding.inflate(layoutInflater)
        initView()
    }

    fun buttonClick(user: User, age: Int) {
        user.age.set(age)
        vm.setUser(user)
    }

    private fun initView() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.activity = this@MainActivity
        binding.vm = vm
        binding.user = User("donghwan", 0)

        vm.setUser(binding.user as User)
        vm.user.observe(this@MainActivity, Observer { newUser ->
            if (newUser != null) showInformation(newUser)
        })
    }

    private fun showInformation(user: User) {
        showToast("${user.name}의 나이는 ${user.age.get()}")
    }

    private fun showToast(msg: String) {
        Toast.makeText(this@MainActivity, msg, Toast.LENGTH_SHORT).show()
    }
}