package br.com.fundatec.ubervet.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.fundatec.ubervet.R
import br.com.fundatec.ubervet.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }

    private fun configHomeButton() {

    }
}

