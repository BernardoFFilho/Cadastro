package com.seuprojeto.cadastro.ui

import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.seuprojeto.cadastro.R
import com.seuprojeto.cadastro.model.Formulario

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

        // Inicializa os componentes da UI
        inicializarComponentes()

        // Configurar os botões
        btnSalvar.setOnClickListener { salvarFormulario() }
        btnLimpar.setOnClickListener { limparFormulario() }
    }

    private fun inicializarComponentes() {
        edtNome = findViewById(R.id.edtNome)
        edtTelefone = findViewById(R.id.edtTelefone)
        edtEmail = findViewById(R.id.edtEmail)
        chkReceberEmail = findViewById(R.id.chkReceberEmail)
        rgSexo = findViewById(R.id.rgSexo)
        edtCidade = findViewById(R.id.edtCidade)
        spUf = findViewById(R.id.spUf)
        btnLimpar = findViewById(R.id.btnLimpar)
        btnSalvar = findViewById(R.id.btnSalvar)
    }

    private fun salvarFormulario() {
        val nome = edtNome.text.toString()
        val telefone = edtTelefone.text.toString()
        val email = edtEmail.text.toString()
        val receberEmail = chkReceberEmail.isChecked
        val cidade = edtCidade.text.toString()
        val uf = spUf.selectedItem.toString()

        // Obtém o ID do botão selecionado no RadioGroup
        val idSexoSelecionado = rgSexo.checkedRadioButtonId
        val sexo = if (idSexoSelecionado != -1) {
            findViewById<RadioButton>(idSexoSelecionado).text.toString()
        } else {
            "Não informado"
        }

        // Criar o objeto do formulário
        val formulario = Formulario(nome, telefone, email, receberEmail, sexo, cidade, uf)

        // Exibir os dados no Toast
        Toast.makeText(this, formulario.toString(), Toast.LENGTH_LONG).show()
    }


    private fun limparFormulario() {
        edtNome.text.clear()
        edtTelefone.text.clear()
        edtEmail.text.clear()
        chkReceberEmail.isChecked = false
        rgSexo.clearCheck()
        edtCidade.text.clear()
        spUf.setSelection(0) // Voltar para o primeiro item do Spinner
    }
}
