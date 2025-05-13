package com.example.dinnerdecider

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.dinnerdecider.databinding.ActivityMainBinding
import java.util.Random

class MainActivity : AppCompatActivity() {

    var foodList = arrayListOf("Chinese", "Hamburger", "Pizza", "McDonalds", "Barrows Pizza")

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)

        binding.decideBtn.setOnClickListener {
                val random = Random()
                val randomFood = random.nextInt(foodList.count())
            binding.selectedFoodTxt.text = foodList[randomFood]
        }

        binding.addFoodBtn.setOnClickListener {
            val newFood = binding.addFoodTxt.text.toString()
            foodList.add(newFood)
            binding.addFoodTxt.text.clear()
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}