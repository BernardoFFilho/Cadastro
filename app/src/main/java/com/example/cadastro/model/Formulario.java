package com.seuprojeto.cadastro.model

data class Formulario(
        val nome: String,
        val telefone: String,
        val email: String,
        val receberEmail: Boolean,
        val sexo: String,
        val cidade: String,
        val uf: String
) {
    override fun toString(): String {
        return """
            Nome: $nome
            Telefone: $telefone
            E-mail: $email
            Receber e-mails: ${if (receberEmail) "Sim" else "Não"}
            Sexo: $sexo
            Cidade: $cidade
            UF: $uf
        """.trimIndent()
    }
}
