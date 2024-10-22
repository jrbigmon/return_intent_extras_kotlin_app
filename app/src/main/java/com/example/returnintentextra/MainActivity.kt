package com.example.returnintentextra

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.example.returnintentextra.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var result: ActivityResultLauncher<Intent>

    private var name = "";
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonChangeName.setOnClickListener({
            val i = Intent(this, MainActivity2::class.java)
            i.putExtra("name", name)
            result.launch(i)
        })

        result = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            if (it.data?.getStringExtra("name") != null && it.resultCode == 1) {
                name = it.data?.getStringExtra("name").toString()
                binding.textViewHello.setText("Olá ${name}")
            } else if (it.resultCode == 2) {
                Toast.makeText(applicationContext, "Operação cancelada", Toast.LENGTH_SHORT)
                    .show()
            } else {
                Toast.makeText(applicationContext, "Error ao atualizar o nome", Toast.LENGTH_SHORT)
                    .show()
            }
        }

    }
}