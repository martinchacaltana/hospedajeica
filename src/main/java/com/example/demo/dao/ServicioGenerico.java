package com.example.demo.dao;

import java.util.List;

public interface ServicioGenerico<E> {
    List<E> listar() throws Exception;
    E buscarporId(long id) throws Exception;
    E guardar(E entity) throws Exception;
    E actualizar(E entity, long id) throws Exception;
    boolean eliminarporId(long id) throws Exception;
}
