package com.example.returnintentextra

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.returnintentextra.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity() {

    private lateinit var binding: ActivityMain2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        val i = intent

        val name = i.extras?.getString("name")

        binding.editName.setText(name)

        binding.buttonApplyChangeName.setOnClickListener({
            i.putExtra("name", binding.editName.text.toString())
            setResult(1, i)
            finish()
        })

        binding.buttonCancelChangeName.setOnClickListener({
            setResult(2, i)
            finish()
        })
    }
}