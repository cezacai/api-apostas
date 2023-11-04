package com.cezacai.apiapostas.exception.controller;

import com.cezacai.apiapostas.exception.ApostaInvalidaException;
import com.cezacai.apiapostas.exception.ApostaNaoEncontradaException;
import com.cezacai.apiapostas.exception.AvisoAposta;
import com.cezacai.apiapostas.exception.ErroAposta;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice(basePackages = "com.cezacai.apiapostas.controller")
public class ExceptionHandlerController {

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(ApostaInvalidaException.class)
    public ResponseEntity<ErroAposta> apiError(ApostaInvalidaException ex){

        ErroAposta erroAposta = new ErroAposta(LocalDateTime.now(),
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                ex.getMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(erroAposta);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<AvisoAposta> apiAviso(MethodArgumentNotValidException ex){

        List<String> validacoes = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(x -> x.getDefaultMessage())
                .collect(Collectors.toList());

        AvisoAposta avisoAposta = new AvisoAposta(HttpStatus.BAD_REQUEST,validacoes);

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(avisoAposta);
    }

    @ExceptionHandler(ApostaNaoEncontradaException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<ErroAposta> apiNaoEncontrada(ApostaNaoEncontradaException ex){
        ErroAposta erroAposta = new ErroAposta(LocalDateTime.now(),
                HttpStatus.NOT_FOUND.value(),
                ex.getMessage());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erroAposta);
    }
}
