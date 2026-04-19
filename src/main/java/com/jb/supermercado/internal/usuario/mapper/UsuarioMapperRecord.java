package com.jb.supermercado.internal.usuario.mapper;

import com.jb.supermercado.internal.usuario.dto.UsuarioRequestRecord;
import com.jb.supermercado.internal.usuario.dto.UsuarioResponseRecord;
import com.jb.supermercado.internal.usuario.entity.UsuarioEntity;

import java.util.ArrayList;
import java.util.List;

public class UsuarioMapperRecord {

    public static UsuarioEntity requestParaEntidade(UsuarioRequestRecord usuarioRequest) {
        UsuarioEntity usuarioEntity = new UsuarioEntity();
        usuarioEntity.setNome(usuarioRequest.nome());
        usuarioEntity.setEmail(usuarioRequest.email());
        usuarioEntity.setSenha(usuarioRequest.senha());
        return usuarioEntity;
    }

    public static UsuarioResponseRecord entidadeParaResponse(UsuarioEntity usuarioEntity) {
       return new UsuarioResponseRecord(
               usuarioEntity.getId(),
               usuarioEntity.getNome(),
               usuarioEntity.getEmail(),
                usuarioEntity.getStatus());
    }

    public static List<UsuarioResponseRecord> entidadeParaResponseRecordList(List<UsuarioEntity> usuarioEntityList) {
        List<UsuarioResponseRecord> usuarioResponseRecordArrayList = new ArrayList<>();
        for (UsuarioEntity usuarioEntity : usuarioEntityList) {
            usuarioResponseRecordArrayList.add(entidadeParaResponse(usuarioEntity));
        }
        return usuarioResponseRecordArrayList;
    }
}
