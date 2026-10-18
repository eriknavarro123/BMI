package org.insbaixcamp.lladosbmicalculator

import android.content.res.ColorStateList
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.button.MaterialButton
import com.google.android.material.slider.Slider

class MainActivity : AppCompatActivity() {

    private var alcada: Int = 180
    private var pes: Int = 80

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val bars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(bars.left, bars.top, bars.right, bars.bottom)
            insets
        }

        // 1) Connectar les vistes amb el XML
        val etNom: EditText = findViewById(R.id.et_nom)
        val tvAlcada: TextView = findViewById(R.id.tv_alcada)
        val slAlcada: Slider = findViewById(R.id.sl_alcada)
        val tvPes: TextView = findViewById(R.id.tv_pes)
        val btMinus: MaterialButton = findViewById(R.id.bt_minus)
        val btPlus: MaterialButton = findViewById(R.id.bt_plus)
        val btCalculate: MaterialButton = findViewById(R.id.bt_calculate)
        val cvResultat: View = findViewById(R.id.cv_resultat)
        val tvResultNom: TextView = findViewById(R.id.tv_result_nom)
        val tvResultImc: TextView = findViewById(R.id.tv_result_imc)
        val tvCategoria: TextView = findViewById(R.id.tv_categoria)

        // 2) La targeta de resultat comença amagada
        cvResultat.visibility = View.GONE

        // 3) Alçada: actualitzar el número quan es mou el lliscador
        slAlcada.addOnChangeListener { _, value, _ ->
            alcada = value.toInt()
            tvAlcada.text = alcada.toString()
        }

        // 4) Pes: botons + i - amb límits
        btPlus.setOnClickListener {
            if (pes < 300) pes++
            tvPes.text = pes.toString()
        }
        btMinus.setOnClickListener {
            if (pes > 20) pes--
            tvPes.text = pes.toString()
        }

        // 5) Calcular
        btCalculate.setOnClickListener {
            val nom = etNom.text.toString().trim()

            // Validació del nom
            if (nom.isEmpty()) {
                etNom.error = "Escriu el teu nom"
                cvResultat.visibility = View.GONE
                return@setOnClickListener
            }

            val alcadaM = alcada / 100.0
            val imc = pes / (alcadaM * alcadaM)

            // Classificar amb when: text, color del text i color del fons (optimitzat per mode clar)
            val categoria: String
            val colorText: Int
            val colorFons: Int
            when {
                imc < 18.5 -> {
                    categoria = "Baix pes"
                    colorText = Color.parseColor("#1A73E8")
                    colorFons = Color.parseColor("#E8F0FE")
                }
                imc < 25.0 -> {
                    categoria = "Pes saludable"
                    colorText = Color.parseColor("#137333")
                    colorFons = Color.parseColor("#E6F4EA")
                }
                imc < 30.0 -> {
                    categoria = "Sobrepès"
                    colorText = Color.parseColor("#B06000")
                    colorFons = Color.parseColor("#FEF7E0")
                }
                else -> {
                    categoria = "Obesitat"
                    colorText = Color.parseColor("#C5221F")
                    colorFons = Color.parseColor("#FCE8E6")
                }
            }

            tvResultNom.text = "IMC de $nom"
            tvResultImc.text = "%.1f".format(imc)
            tvCategoria.text = "● $categoria"
            tvCategoria.setTextColor(colorText)
            tvCategoria.backgroundTintList = ColorStateList.valueOf(colorFons)
            cvResultat.visibility = View.VISIBLE
        }
    }
}
