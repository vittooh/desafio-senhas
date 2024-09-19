package com.dbl.desafio_senha_sal_pimenta.senhas

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/v1/senhas")
class SenhasController(
    val logger: Logger = LoggerFactory.getLogger(SenhasController::class.java),
    val senhaService: SenhaService
) {

    @PostMapping("/valida-senha")
    fun validaPassword(@RequestBody senhaDTO: SenhaDTO): ResponseEntity<Void> {
        return senhaService.validaSenha(senhaDTO.senha)
    }
}
