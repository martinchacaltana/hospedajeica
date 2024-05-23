package com.example.demo.dao;

import com.example.demo.repositorio.DocumentoIdentidad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



import java.util.List;

@Service
public class DocumentoIdentidadImple implements DocumentoIdentidadDao{

    @Autowired
    private DocumentoIdentidad repository;


    @Override
    public List<com.example.demo.entidades.DocumentoIdentidad> obtenertodos() {
        return repository.findAll();
    }

    @Override
    public void eliminar(long Id) {
        repository.deleteById(Id);
    }

    @Override
    public com.example.demo.entidades.DocumentoIdentidad obtenerPodid(long id) {
        return repository.findById(id).get();
    }

    @Override
    public com.example.demo.entidades.DocumentoIdentidad actualizarDocumento(com.example.demo.entidades.DocumentoIdentidad documentoIdentidad) {
        return repository.save(documentoIdentidad);
    }

    @Override
    public com.example.demo.entidades.DocumentoIdentidad agregarDocumento(com.example.demo.entidades.DocumentoIdentidad documentoIdentidad) {
        return repository.save(documentoIdentidad);
    }
}
