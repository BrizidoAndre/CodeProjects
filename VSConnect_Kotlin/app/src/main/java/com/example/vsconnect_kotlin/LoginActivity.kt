package com.example.vsconnect_kotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import com.example.vsconnect_kotlin.databinding.ActivityLoginBinding
import com.example.vsconnect_kotlin.models.Login

class LoginActivity : AppCompatActivity() {

    //É uma propriedade privada como o nome vinfing do tipo Activity Login Binding
    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        //atribui a variável binding um objeto que contém referências (propriedades) aos elementos definidos no layout
        binding = ActivityLoginBinding.inflate(layoutInflater)

        binding.btnEntrar.setOnClickListener{
            //variável mainIntent com a intenção de sair da Login Activity e ir para MainActivity
            val mainIntent = Intent(this@LoginActivity, MainActivity::class.java)

            //executa a intenção armazenada na variável mainIntent
            startActivity(mainIntent)

            //finaliza a LoginActivity
            finish()
        }

        setContentView(binding.root)
    }

    private fun autenticarUsuario(){
        val root: View = binding.root

        val idEmail = root.findViewById<EditText>(R.id.campo_email)
        val idSenha = root.findViewById<EditText>(R.id.campo_senha)

        val emailDigitado = idEmail.text.toString()
        val senhaDigitado = idSenha.text.toString()

        val usuario = Login(emailDigitado, senhaDigitado)
    }


}