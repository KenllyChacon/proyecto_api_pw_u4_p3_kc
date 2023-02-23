package uce.edu.ec.proyecto_api_pw_u4_p3_kc.service;

import uce.edu.ec.proyecto_api_pw_u4_p3_kc.repository.model.Cliente;

import java.util.List;

public interface IClienteService {

    void insertarCliente(Cliente cliente);
    Cliente buscarCliente(Integer id);
    void actualizarCliente(Cliente cliente);
    void borrarCliente(Integer id);

    Cliente buscarClientePorCedula(String cedula);
    List<Cliente> buscarTodosClientes();
    void borrarClientePorCedula(String cedula);

}
