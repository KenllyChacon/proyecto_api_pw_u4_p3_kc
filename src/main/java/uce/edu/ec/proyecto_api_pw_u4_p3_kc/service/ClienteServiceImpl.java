package uce.edu.ec.proyecto_api_pw_u4_p3_kc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uce.edu.ec.proyecto_api_pw_u4_p3_kc.repository.IClienteRepository;
import uce.edu.ec.proyecto_api_pw_u4_p3_kc.repository.model.Cliente;

import java.util.List;

@Service
public class ClienteServiceImpl implements IClienteService{

    @Autowired
    private IClienteRepository clienteRepository;


    @Override
    public void insertarCliente(Cliente cliente) {
        this.clienteRepository.insertarCliente(cliente);
    }

    @Override
    public Cliente buscarCliente(Integer id) {
        return this.clienteRepository.buscarCliente(id);
    }

    @Override
    public void actualizarCliente(Cliente cliente) {
        this.clienteRepository.actualizarCliente(cliente);
    }

    @Override
    public void borrarCliente(Integer id) {
        this.clienteRepository.borrarCliente(id);
    }

    @Override
    public Cliente buscarClientePorCedula(String cedula) {
        return this.clienteRepository.buscarClientePorCedula(cedula);
    }

    @Override
    public List<Cliente> buscarTodosClientes() {
        return this.clienteRepository.buscarTodosClientes();
    }

    @Override
    public void borrarClientePorCedula(String cedula) {
        this.clienteRepository.borrarClientePorCedula(cedula);
    }
}
