package com.example.appvote

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.RadioGroup
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() {
    val lstVote = mutableListOf<Int>(0,0,0)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btnVote = findViewById<Button>(R.id.btnVote)
        val grpVote = findViewById<RadioGroup>(R.id.grpVote)
        btnVote.setOnClickListener {
            (it as Button).text = "Votei"
            when(grpVote.checkedRadioButtonId){
                R.id.optKB -> lstVote[0]++
                R.id.optLula -> lstVote[1]++
                R.id.optR10 -> lstVote[2]++
                else ->{
                    Toast.makeText(this@MainActivity, "Selecione um dos candidatos para votar", Toast.LENGTH_SHORT).show()
                }
            }
            //Sem interromper a navegabilidade do app
            Toast.makeText(this@MainActivity, "Votos KB: ${lstVote[0]}  LULA: ${lstVote[1]}  LULA: ${lstVote[2]}", Toast.LENGTH_LONG).show()
        }
    }
    override fun onBackPressed() {
        //Interrupcao do sistema
       val dialog = AlertDialog.Builder(this).apply {
           setTitle("Aplicativo de Votação")
           setMessage("Tem certeza que deseja sair do aplicativo?")
           setPositiveButton(getString(android.R.string.ok), DialogInterface.OnClickListener { dialog, i ->
               super.onBackPressed()
           })
           setNegativeButton(getString(android.R.string.cancel), null)
           show()
       }
    }
}