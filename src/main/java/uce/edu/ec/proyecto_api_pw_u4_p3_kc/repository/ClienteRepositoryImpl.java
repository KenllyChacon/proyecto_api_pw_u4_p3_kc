package uce.edu.ec.proyecto_api_pw_u4_p3_kc.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;
import uce.edu.ec.proyecto_api_pw_u4_p3_kc.repository.model.Cliente;

import java.util.List;

@Repository
@Transactional
public class ClienteRepositoryImpl implements IClienteRepository{

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public void insertarCliente(Cliente cliente) {
        this.entityManager.persist(cliente);
    }

    @Override
    public Cliente buscarCliente(Integer id) {
        return this.entityManager.find(Cliente.class,id);
    }

    @Override
    public void actualizarCliente(Cliente cliente) {
        this.entityManager.merge(cliente);
    }

    @Override
    public void borrarCliente(Integer id) {
        Cliente clienteBorrar = this.buscarCliente(id);
        this.entityManager.remove(clienteBorrar);
    }

    @Override
    public Cliente buscarClientePorCedula(String cedula) {
        //Buscar uno en especifico
        TypedQuery<Cliente> miTypeQuery = this.entityManager.createQuery("select g from Cliente g where g.cedula =: cedula",Cliente.class);
        miTypeQuery.setParameter("cedula", cedula);
        return miTypeQuery.getSingleResult();
    }

    @Override
    public List<Cliente> buscarTodosClientes() {
        //Buscar Todos
        TypedQuery<Cliente> miTypeQuery = this.entityManager.createQuery("select e from Cliente e",Cliente.class);
        return miTypeQuery.getResultList();

    }

    @Override
    public void borrarClientePorCedula(String cedula) {
        TypedQuery<Cliente> miTypeQuery = this.entityManager.createQuery("select g from Cliente g where g.cedula =: cedula",Cliente.class);
        miTypeQuery.setParameter("cedula", cedula);
        this.entityManager.remove(miTypeQuery.getSingleResult());
    }

}
