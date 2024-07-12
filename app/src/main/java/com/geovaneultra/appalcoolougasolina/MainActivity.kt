package com.geovaneultra.appalcoolougasolina

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class MainActivity : AppCompatActivity() {

    private lateinit var textInputEtanol: TextInputLayout
    private lateinit var editEtanol: TextInputEditText

    private lateinit var textInputGasolina: TextInputLayout
    private lateinit var editGasolina: TextInputEditText

    private lateinit var  buttonCalcular: Button
    private lateinit var  textResulto: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        inicializarComponentesInterface()
        buttonCalcular.setOnClickListener {
            calcularMelhorPreco()
        }
    }

    private fun calcularMelhorPreco() {
        val precoEtanol = editEtanol.text.toString()
        val precoGasolina = editGasolina.text.toString()

        val resultadoValidacao = validarCampos(precoEtanol, precoGasolina)
        if(resultadoValidacao){

            val precoEtanolDouble = precoEtanol.toDouble()
            val precoGasolinaDouble = precoGasolina.toDouble()
            val resultado = precoEtanolDouble / precoGasolinaDouble

            if(resultado >= 0.7){
                textResulto.text = "É melhor abastecer com Gasolina"
            }else{
                textResulto.text = "É melhor abastecer com Etanol"
            }

        }
    }

    private fun validarCampos(pEtanol: String, pGasolina: String): Boolean {

        textInputEtanol.error = null
        textInputGasolina.error = null

        if(pEtanol.isEmpty()){
            textInputEtanol.error = "Digite o valor do Etanol"
            return false
        }else if (pGasolina.isEmpty()){
            textInputGasolina.error = "Digite o valor da Gasolina"
            return false
        }

        return true
    }

    private fun inicializarComponentesInterface() {
        textInputEtanol = findViewById(R.id.text_input_etanol)
        editEtanol = findViewById(R.id.edit_etanol)

        textInputGasolina = findViewById(R.id.text_input_gasolina)
        editGasolina = findViewById(R.id.edit_gasolina)

        buttonCalcular = findViewById(R.id.button_calcular)
        textResulto = findViewById(R.id.text_resultado)
    }
}