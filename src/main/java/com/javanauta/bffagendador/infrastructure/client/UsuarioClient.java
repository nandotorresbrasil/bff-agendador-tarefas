package com.javanauta.bffagendador.infrastructure.client;

import com.javanauta.bffagendador.business.dto.in.LoginRequestDTO;
import com.javanauta.bffagendador.business.dto.in.UsuarioDTORequest;
import com.javanauta.bffagendador.business.dto.out.EnderecoDTOResponse;
import com.javanauta.bffagendador.business.dto.out.TelefoneDTOResponse;
import com.javanauta.bffagendador.business.dto.out.UsuarioDTOResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "usuario", url = "${usuario.url}")
public interface UsuarioClient {

    @GetMapping
    UsuarioDTOResponse buscaUsuarioPorEmail(@RequestParam("email") String email,
                                            @RequestHeader("Authorization") String token);

    @PostMapping
    UsuarioDTOResponse salvaUsuario(@RequestBody UsuarioDTORequest usuarioDTO);

    @PostMapping("/login")
    String login(@RequestBody LoginRequestDTO usuarioDTO);

    @DeleteMapping("/{email}")
    void deletaUsuarioPorEmail(@PathVariable String email,
                               @RequestHeader("Authorization") String token);

    @PutMapping
    UsuarioDTOResponse atualizDadoUsuario(@RequestBody UsuarioDTOResponse dto,
                                          @RequestHeader("Authorization") String token);

    @Deprecated
    @PutMapping("/endereco")
    EnderecoDTOResponse atualizaEndereco(@RequestBody EnderecoDTOResponse dto,
                                         @RequestParam("id") Long id,
                                         @RequestHeader("Authorization") String token);

    @PutMapping("/telefone")
    TelefoneDTOResponse atualizaTelefone(@RequestBody TelefoneDTOResponse dto,
                                         @RequestParam("id") Long id,
                                         @RequestHeader("Authorization") String token);

    @PostMapping("/endereco")
    EnderecoDTOResponse cadastaEndereco(@RequestBody EnderecoDTOResponse dto,
                                        @RequestHeader("Authorization") String token);

    @PostMapping("/telefone")
    TelefoneDTOResponse cadastraTelefone(@RequestBody TelefoneDTOResponse dto,
                                         @RequestHeader("Authorization") String token);
}