package com.javanauta.bffagendador.business;

import com.javanauta.bffagendador.business.dto.in.LoginRequestDTO;
import com.javanauta.bffagendador.business.dto.in.UsuarioDTORequest;
import com.javanauta.bffagendador.business.dto.out.EnderecoDTOResponse;
import com.javanauta.bffagendador.business.dto.out.TelefoneDTOResponse;
import com.javanauta.bffagendador.business.dto.out.UsuarioDTOResponse;
import com.javanauta.bffagendador.infrastructure.client.UsuarioClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioClient client;

    public UsuarioDTOResponse salvaUsuario(UsuarioDTORequest usuarioDTO) {
        return client.salvaUsuario(usuarioDTO);
    }

    public String loginUsuario(LoginRequestDTO loginDTO) {
        return client.login(loginDTO);
    }

    public UsuarioDTOResponse buscarUsuarioPorEmail(String email, String token) {
        return client.buscaUsuarioPorEmail(email, token);
    }

    public void deletaUsuarioPorEmail(String email, String token){
        client.deletaUsuarioPorEmail(email, token);
    }

    public UsuarioDTOResponse atualizaDadosUsuario(String token, UsuarioDTOResponse dto){
        return client.atualizDadoUsuario(dto, token);
    }

    @Deprecated
    public EnderecoDTOResponse atualizaEndereco(Long idEndereco, EnderecoDTOResponse enderecoDTO, String token){
        return client.atualizaEndereco(enderecoDTO, idEndereco, token);
    }

    public TelefoneDTOResponse HotelatualizaTelefone(Long idTelefone, TelefoneDTOResponse dto, String token){
        return client.atualizaTelefone(dto, idTelefone, token);
    }

    public EnderecoDTOResponse cadastraEndereco(String token, EnderecoDTOResponse dto){
        return client.cadastaEndereco(dto, token);
    }

    public TelefoneDTOResponse cadastraTelefone(String token, TelefoneDTOResponse dto){
        return client.cadastraTelefone(dto, token);
    }
}