package com.example.listapersonagens.view.fragment

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.DialogFragment

class NotificationDialogFragment : DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let {
            val builder = AlertDialog.Builder(it)
            builder.setMessage("Mensagem padrão")
                .setPositiveButton(
                    "Mensagem padrão"
                ) { dialog, id ->
                    // START THE GAME!
                }
                .setNegativeButton(
                    "Mensagem padrão"
                ) { dialog, id ->
                    // User cancelled the dialog
                }
            // Create the AlertDialog object and return it
            builder.create()
        } ?: throw IllegalStateException("Activity cannot be null")
    }
}

//    Um pequeno exemplo de como poderíamos utilizar o builder como design pattern criacional
//    para criar caixas de diálogo no projeto.