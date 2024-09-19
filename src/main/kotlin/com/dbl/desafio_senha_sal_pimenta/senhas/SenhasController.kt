package com.dbl.desafio_senha_sal_pimenta.senhas

import com.dbl.desafio_senha_sal_pimenta.config.SenhaBanida
import jakarta.validation.Valid
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/v1/senhas")
class SenhasController(
    val logger: Logger = LoggerFactory.getLogger(SenhasController::class.java),
    val senhaBanida: SenhaBanida
) {

    @PostMapping("/valida-senha")
    fun validaPassword(@Valid @RequestBody senhaDTO: SenhaDTO): ResponseEntity<Void> {
        if (senhaDTO.senha in senhaBanida.senhasBanidas) {
            return ResponseEntity.badRequest().build()
        }
        return ResponseEntity.noContent().build()
    }
}
