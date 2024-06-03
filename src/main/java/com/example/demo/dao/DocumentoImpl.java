package com.example.demo.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entidades.Documento;
import com.example.demo.repositorio.DocumentoRepositorio;

import jakarta.transaction.Transactional;

@Service
public class DocumentoImpl  implements ServicioGenerico<Documento>{

    @Autowired
    private DocumentoRepositorio documentoRepositorio;

    @Override
    @Transactional
    public List<Documento> listar() throws Exception {
        try {
            List<Documento> lista = this.documentoRepositorio.findAllByActivo();
            return lista;
        }catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Documento buscarporId(long id) throws Exception {
        try {
            Optional<Documento> obj = this.documentoRepositorio.findById(id);
            return obj.get();
        }catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Documento guardar(Documento entity) throws Exception {
        try {
            Documento documento = this.documentoRepositorio.save(entity);
            return documento;
        }catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Documento actualizar(Documento entity, long id) throws Exception {
        try {
            Optional<Documento> obj = this.documentoRepositorio.findById(id);
            if (obj.isPresent()) {
                Documento documento = obj.get();
                documento.setNombreDocumento(entity.getNombreDocumento());
                documento.setAbreviatura(entity.getAbreviatura());
                return this.documentoRepositorio.save(documento);
            }else{
                throw new Exception("Documento no encontrada con id: " + id);            }
        }catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public boolean eliminarporId(long id) throws Exception {
        try {
            Optional<Documento> obj = this.documentoRepositorio.findById(id);
            if(!obj.isEmpty()){
                Documento documento = obj.get();
                documento.setActivo(!documento.isActivo());
                this.documentoRepositorio.save(documento);
            }else{
                throw new Exception();
            }
            return true;
        }catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

}
