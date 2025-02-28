package com.example.cadastro.ui

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.example.cadastro.R
import com.example.cadastro.model.Formulario

class MainActivity : AppCompatActivity() {

    private lateinit var edtNome: EditText
    private lateinit var edtTelefone: EditText
    private lateinit var edtEmail: EditText
    private lateinit var chkReceberEmail: CheckBox
    private lateinit var rgSexo: RadioGroup
    private lateinit var edtCidade: EditText
    private lateinit var spUf: Spinner
    private lateinit var btnLimpar: Button
    private lateinit var btnSalvar: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        inicializarComponentes()
        setListeners()
    }

    private fun inicializarComponentes() {
        edtNome = findViewById(R.id.etNome)
        edtTelefone = findViewById(R.id.etPhone)
        edtEmail = findViewById(R.id.etEmail)
        chkReceberEmail = findViewById(R.id.cbReceberEmail)
        rgSexo = findViewById(R.id.rgSexo)
        edtCidade = findViewById(R.id.etCidade)
        spUf = findViewById(R.id.spUf)
        btnLimpar = findViewById(R.id.btnLimpar)
        btnSalvar = findViewById(R.id.btnSalvar)

        val estados = resources.getStringArray(R.array.estadosBrasil)

        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, estados)

        spUf.adapter = adapter
    }



    private fun setListeners() {
        btnSalvar.setOnClickListener { salvarFormulario() }
        btnLimpar.setOnClickListener { limparFormulario() }
    }

    private fun salvarFormulario() {
        try {
            val sexoSelecionado = if (rgSexo.checkedRadioButtonId != -1) {
                findViewById<RadioButton>(rgSexo.checkedRadioButtonId).text.toString()
            } else {
                "Não informado"
            }

            val formulario = Formulario(
                nome = edtNome.text?.toString() ?: "",
                telefone = edtTelefone.text?.toString() ?: "",
                email = edtEmail.text?.toString() ?: "",
                receberEmail = chkReceberEmail.isChecked,
                sexo = sexoSelecionado,
                cidade = edtCidade.text?.toString() ?: "",
                uf = spUf.selectedItem?.toString() ?: ""
            )

            Toast.makeText(this, formulario.toString(), Toast.LENGTH_LONG).show()
        } catch (e: Exception) {
            Toast.makeText(this, "Erro ao salvar formulário: ${e.message}", Toast.LENGTH_LONG).show()
            e.printStackTrace()
        }
    }

    private fun limparFormulario() {
        listOf(edtNome, edtTelefone, edtEmail, edtCidade).forEach { it.text.clear() }
        chkReceberEmail.isChecked = false
        rgSexo.clearCheck()
        spUf.setSelection(0)
    }
}