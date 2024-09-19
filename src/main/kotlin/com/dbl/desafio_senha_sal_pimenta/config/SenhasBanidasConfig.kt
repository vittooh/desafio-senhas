package com.dbl.desafio_senha_sal_pimenta.config

import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import java.io.BufferedReader
import java.io.InputStreamReader
import java.nio.charset.StandardCharsets
import java.util.stream.Collectors


@Configuration
class SenhasBanidasConfig(
    @Value("classpath:senhas-nao-usar.txt") val resource: org.springframework.core.io.Resource
) {

    @Bean
    fun geraListaSenhasBanidas(): SenhaBanida {
        BufferedReader(InputStreamReader(resource.inputStream, StandardCharsets.UTF_8)).use { reader ->
            return SenhaBanida(
                reader.lines().collect(Collectors.toList())
            )
        }
    }
}
