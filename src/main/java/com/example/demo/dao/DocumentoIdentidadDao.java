package com.example.demo.dao;

import com.example.demo.entidades.DocumentoIdentidad;

import java.util.List;

public interface DocumentoIdentidadDao {
    List<DocumentoIdentidad> obtenertodos();
    public void eliminar (long Id);
    public DocumentoIdentidad obtenerPodid (long id);
    public DocumentoIdentidad actualizarDocumento (DocumentoIdentidad documentoIdentidad);
    public DocumentoIdentidad agregarDocumento (DocumentoIdentidad documentoIdentidad);
}
