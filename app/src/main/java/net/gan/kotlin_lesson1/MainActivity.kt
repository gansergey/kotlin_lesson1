package net.gan.kotlin_lesson1

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import net.gan.kotlin_lesson1.databinding.ActivityMainBinding
import java.util.*


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var ktData: KtData

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener {

            if ((binding.etName.text.isNotEmpty() && binding.etLastName.text.isNotEmpty())) {
                showToast();
            } else {
                showToastError()
            }
        }
    }

    private fun showToast() {

        ktData = KtData(binding.etName.text.toString(), binding.etLastName.text.toString())

        Toast.makeText(
            this, "Ваше имя: " + ktData.name + "\n" + "Ваша фамилия: " + ktData.lastName,
            Toast.LENGTH_LONG
        ).show()

    }

    private fun showToastError() {
        Toast.makeText(this, "Заполните все поля", Toast.LENGTH_SHORT).show()
    }
}