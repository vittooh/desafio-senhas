package com.dbl.desafio_senha_sal_pimenta.senhas

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service

@Service
class SenhaService(
    val logger: Logger = LoggerFactory.getLogger(SenhasController::class.java),
    val caracteresEspeciais: MutableList<Char> = mutableListOf('!', '@', '#', '$', '%')
) {
    fun validaSenha(senha: String): ResponseEntity<Void> {
        logger.info("Iniciando processo de validação de senha")
        if (senha.length < 8) {
            logger.error("a senha não tem 8 ou mais caracteres")
            return ResponseEntity(HttpStatus.BAD_REQUEST)
        }

        if (!validaParametrosSenha(senha)) {
            logger.error("A senha falhou na valição de parametros como, numero, maisculo,minusculo e digito")
            return ResponseEntity(HttpStatus.BAD_REQUEST)
        }

        logger.info("a senha ta joia")

        return ResponseEntity.noContent().build()
    }

    private fun validaParametrosSenha(senha: String): Boolean {
        var acheiCaracterEspecial = false
        var acheiNumero = false
        var acheiMaiuscula = false
        var acheiMinusculo = false
        for (c in senha.toCharArray()) {
            if (c in caracteresEspeciais) {
                acheiCaracterEspecial = true
            }

            if (c.isDigit()) {
                acheiNumero = true
            }

            if (c.isUpperCase()) {
                acheiMaiuscula = true
            }

            if (c.isLowerCase()) {
                acheiMinusculo = true
            }
        }
        logger.info("Resultado para validação foi")
        logger.info("$acheiCaracterEspecial | $acheiMaiuscula | $acheiMinusculo | $acheiNumero | ")
        return acheiCaracterEspecial && acheiMaiuscula && acheiMinusculo && acheiNumero
    }
}
