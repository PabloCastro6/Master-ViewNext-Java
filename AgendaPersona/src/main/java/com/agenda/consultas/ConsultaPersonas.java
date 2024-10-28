package com.agenda.consultas;

import com.agenda.model.Persona;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class ConsultaPersonas {
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("agenda"); //Automatiza la generacion de valores unicos del id

    public List<Persona> buscarTodas() {
        EntityManager em = emf.createEntityManager();
        TypedQuery<Persona> query = em.createNamedQuery("Persona.buscarTodas", Persona.class);
        List<Persona> personas = query.getResultList();
        em.close();
        return personas;
    }

    public Persona buscarPorId(int id) {
        EntityManager em = emf.createEntityManager();
        TypedQuery<Persona> query = em.createNamedQuery("Persona.buscarPorId", Persona.class);
        query.setParameter("id", id);
        List<Persona> resultados = query.getResultList();
        em.close();
        return resultados.isEmpty() ? null : resultados.get(0); // Devuelve null si no hay resultados;
    }

    public List<Persona> buscarPorApellido1(String apellido1) {
        EntityManager em = emf.createEntityManager();
        TypedQuery<Persona> query = em.createNamedQuery("Persona.buscarPorApellido1", Persona.class);
        query.setParameter("apellido1", apellido1);
        List<Persona> personas = query.getResultList();
        em.close();
        return personas;
    }

    public List<Persona> buscarPorApellido1yApellido2(String apellido1, String apellido2) {
        EntityManager em = emf.createEntityManager();
        TypedQuery<Persona> query = em.createNamedQuery("Persona.buscarPorApellido1yApellido2", Persona.class);
        query.setParameter("apellido1", apellido1);
        query.setParameter("apellido2", apellido2);
        List<Persona> personas = query.getResultList();
        em.close();
        return personas;
    }
}
