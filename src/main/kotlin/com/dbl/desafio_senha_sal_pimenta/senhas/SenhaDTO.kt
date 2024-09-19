package com.dbl.desafio_senha_sal_pimenta.senhas

import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Pattern
import jakarta.validation.constraints.Size

data class SenhaDTO(

    @field:NotNull(message = "Senha não pode estar vazia")
    @field:NotBlank
    @field:Size(min = 8, message = "Tamanho minimo de 8 caracters")
    @field:Pattern(
        regexp = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[@!#\$%])[A-Za-z\\d@!#\$%]{8,}\$",
        message = "Senha deve ter 8 caracteres, maiscula, minuscula digito especial"
    )
    val senha: String
)
