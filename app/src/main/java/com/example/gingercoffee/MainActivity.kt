package com.example.gingercoffee

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val linkToAuth: TextView = findViewById(R.id.lingToReg)
        linkToAuth.setOnClickListener {
            startActivity(Intent(this, RegActivity::class.java))
        }
            val userLogin: EditText = findViewById(R.id.loginAuth)
            val userPass: EditText = findViewById(R.id.passAuth)
            val button: Button = findViewById(R.id.buttonAuth)
            button.setOnClickListener {
                val login = userLogin.text.toString().trim()
                val pass = userPass.text.toString().trim()
                if (login == "" || pass == "") {
                    Toast.makeText(this, "Не все поля заполнены", Toast.LENGTH_LONG).show()
                } else {
                    val db = DBHelper(this, null)
                    val isAuth = db.getUser(login, pass)
                    if (isAuth) {
                        Toast.makeText(this, "Пользователь $login авторизован", Toast.LENGTH_LONG).show()
                        userLogin.text.clear()
                        userPass.text.clear()
                        val intent = Intent(this, ItemsActivity::class.java)
                        startActivity(intent)
                    } else {
                        Toast.makeText(this, "Пользователь не найден", Toast.LENGTH_LONG).show()
                    }


                }
            }


        }
    }





