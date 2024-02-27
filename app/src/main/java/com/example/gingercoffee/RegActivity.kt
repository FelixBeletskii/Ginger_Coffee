package com.example.gingercoffee

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class RegActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reg)
        val userLogin: EditText = findViewById(R.id.loginReg)
        val userEmail:EditText= findViewById(R.id.emailReg)
        val userPass: EditText = findViewById(R.id.passReg)
        val button: Button= findViewById(R.id.buttonReg)
        val link: TextView = findViewById(R.id.linkToAuth)
        link.setOnClickListener{
            startActivity(Intent(this,MainActivity::class.java))
        }
        button.setOnClickListener{
            val login = userLogin.text.toString().trim()
            val email = userEmail.text.toString().trim()
            val pass = userPass.text.toString().trim()
            if(login==""||email==""||pass=="") {
                Toast.makeText(this, "Не все поля заполнены", Toast.LENGTH_LONG).show()
            } else{

            val user = User(login,email,pass)
                val db = DBHelper(this,null)
                db.addUser(user)
                Toast.makeText(this, "Пользователь $login добавлен!", Toast.LENGTH_LONG).show()
                userLogin.text.clear()
                userEmail.text.clear()
                userPass.text.clear()
            }
        }
    }
}