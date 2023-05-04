package com.example.listapersonagens.view.activity

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import com.example.listapersonagens.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    
    private lateinit var binding: ActivityMainBinding
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
    }

    private val builder: AlertDialog.Builder = this.let {
        AlertDialog.Builder(it)
    }

    private fun createDialog(){
        builder.setMessage("Mensagem a ser exibida").setTitle("Título")
        val dialog: AlertDialog = builder.create()
        dialog.setMessage("Setando uma mensagem")
    }

//    Um pequeno exemplo de como poderíamos utilizar o builder como design pattern criacional
//    para criar caixas de diálogo no projeto.
}
