package com.example.examenglobal

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.examenglobal.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_main)
        setContentView(binding.root)
        val lista = mutableListOf("Amarillo","Verde","Rojo")

        binding.b5.visibility = View.GONE
        binding.tv1.visibility = View.GONE

        Toast.makeText(this,"Elige un orden",Toast.LENGTH_LONG).show()

        var eleccion=false
        var eleccion2=" "

        binding.b1.setOnClickListener {
            eleccion=true
            eleccion2="b1"
        }

        binding.b2.setOnClickListener {
            eleccion=true
            eleccion2="b2"


        }

        binding.b3.setOnClickListener {
            eleccion2="b3"
            eleccion=true

        }

        binding.b4.setOnClickListener {
            if (eleccion) {
                binding.tv1.visibility = View.VISIBLE
                binding.b5.visibility = View.VISIBLE
                binding.b1.visibility = View.GONE
                binding.b2.visibility = View.GONE
                binding.b3.visibility = View.GONE
                binding.b4.visibility = View.GONE
            }else{
                Toast.makeText(this,"No has elegido un orden" + "\n" + "Elige un de las 3 opciones",Toast.LENGTH_LONG).show()
            }

        }

        binding.b5.setOnClickListener {
            when(eleccion2){
                "b1" -> binding.tv1.text= ordenAlfabetico(lista)
                "b2" -> binding.tv1.text= ordenarPorTamano(lista)
                "b3" -> binding.tv1.text=ordenAleatorio(lista)
            }
        }
    }

    private fun ordenAlfabetico(lista: List<String>) : String{
        var order = lista.sortedBy{
            it
        }
        var salida = " "

        for(i in order){

            salida += " $i"
        }
        return salida
    }

    private fun ordenarPorTamano(lista: List<String>) : String{
        var taxman = lista.sortedBy {
            it.length
        }
        var salida = " "

        for(i in taxman){

            salida += " $i"
        }
        return salida
    }

    private fun ordenAleatorio(lista: List<String>): String {
        return lista.random()
    }
}
