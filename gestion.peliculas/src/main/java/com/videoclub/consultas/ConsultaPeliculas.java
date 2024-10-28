package com.videoclub.consultas;

import com.videoclub.model.Pelicula;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;


import java.util.List;

public class ConsultaPeliculas {
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("bdvideoclub");
    private EntityManager em;
    private TypedQuery<Pelicula> query;

    public List<Pelicula> buscarTodas() {
        em = emf.createEntityManager();
        query = em.createNamedQuery("Pelicula.buscarTodas", Pelicula.class);
        return query.getResultList();
    }

    public List<Pelicula> buscarPorDirector(String director) {
        em = emf.createEntityManager();
        query = em.createNamedQuery("Pelicula.buscarPorDirector", Pelicula.class);
        query.setParameter("director", director);
        return query.getResultList();
    }

    public List<Pelicula> buscarPorDirectorEmpiezaCon(String patron) {
        em = emf.createEntityManager();
        query = em.createNamedQuery("Pelicula.buscarPorDirectorEmpiezaCon", Pelicula.class);
        query.setParameter("patron", patron + "%");
        return query.getResultList();
    }

    public List<Pelicula> buscarPorDirectoras() {
        em = emf.createEntityManager();
        query = em.createNamedQuery("Pelicula.buscarPorDirectoras", Pelicula.class);
        return query.getResultList();
    }

    public List<String> mostrarDirectores() {
        em = emf.createEntityManager();
        TypedQuery<String> queryDirectores = em.createNamedQuery("Pelicula.mostrarDirectores", String.class);
        return queryDirectores.getResultList();
    }

    public List<Pelicula> buscarPorPrecio(double min, double max) {
        em = emf.createEntityManager();
        query = em.createNamedQuery("Pelicula.buscarPorPrecio", Pelicula.class);
        query.setParameter("min", min);
        query.setParameter("max", max);
        return query.getResultList();
    }

    
}
