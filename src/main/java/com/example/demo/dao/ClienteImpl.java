package com.example.demo.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entidades.Cliente;
import com.example.demo.repositorio.ClienteRepositorio;

import jakarta.transaction.Transactional;

@Service
public class ClienteImpl implements ServicioGenerico<Cliente>{
    @Autowired 
    private ClienteRepositorio clienteRepositorio;

    @Override
    @Transactional
    public List<Cliente> listar() throws Exception {
        try {
            List<Cliente> lista = this.clienteRepositorio.findAllByActivo();
            return lista;
        }catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Cliente buscarporId(long id) throws Exception {
        try {
            Optional<Cliente> obj = this.clienteRepositorio.findById(id);
            return obj.get();
        }catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Cliente guardar(Cliente entity) throws Exception {
        try {
            Cliente cliente = this.clienteRepositorio.save(entity);
            return cliente;
        }catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Cliente actualizar(Cliente entity, long id) throws Exception {
        try {
            Optional<Cliente> obj = this.clienteRepositorio.findById(id);
            if (obj.isPresent()) {
                Cliente cliente = obj.get();
                cliente.setNombre(entity.getNombre());
                cliente.setDocumento(entity.getDocumento());
                cliente.setNumerodocumento(entity.getNumerodocumento());
                cliente.setCorreo(entity.getCorreo());
                cliente.setFechanacimiento(entity.getFechanacimiento());
                return this.clienteRepositorio.save(cliente);
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
            Optional<Cliente> obj = this.clienteRepositorio.findById(id);
            if(!obj.isEmpty()){
                Cliente cliente = obj.get();
                cliente.setActivo(!cliente.isActivo());
                this.clienteRepositorio.save(cliente);
            }else{
                throw new Exception();
            }
            return true;
        }catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

}
