package uce.edu.ec.proyecto_api_pw_u4_p3_kc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import uce.edu.ec.proyecto_api_pw_u4_p3_kc.repository.model.Cliente;
import uce.edu.ec.proyecto_api_pw_u4_p3_kc.service.IClienteService;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@CrossOrigin()
@RequestMapping("/clientes")
public class ClienteControllerRestFul {

    @Autowired
    private IClienteService iClienteService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public void insertarCliente(@RequestBody Cliente cliente) {
        this.iClienteService.insertarCliente(cliente);
    }

    @PutMapping(path ="/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public void actualizarCliente(@PathVariable("id") Integer id, @RequestBody Cliente cliente) {
        cliente.setId(id);
        this.iClienteService.actualizarCliente(cliente);
    }

    @DeleteMapping(path ="/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public void eliminarCliente(@PathVariable("id") Integer id) {
        this.iClienteService.borrarCliente(id);
    }

    @GetMapping(path = "/cedula", produces = MediaType.APPLICATION_JSON_VALUE)
    public Cliente buscarClientePorCedula(@RequestParam String cedula) {
        return this.iClienteService.buscarClientePorCedula(cedula);
    }

    @GetMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Cliente> buscarTodosClientes() {
        return this.iClienteService.buscarTodosClientes();
    }

    @DeleteMapping(path ="/cedula", produces = MediaType.APPLICATION_JSON_VALUE)
    public void borrarClientePorCedula(@RequestParam String cedula) {
        this.iClienteService.borrarClientePorCedula(cedula);
    }

}
