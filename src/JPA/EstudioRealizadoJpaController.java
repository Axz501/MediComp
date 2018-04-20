/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JPA;

import JPA.exceptions.NonexistentEntityException;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import Logica.Consulta;
import Logica.EstudioRealizado;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author Admin
 */
public class EstudioRealizadoJpaController implements Serializable {

    public EstudioRealizadoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(EstudioRealizado estudioRealizado) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Consulta consulta = estudioRealizado.getConsulta();
            if (consulta != null) {
                consulta = em.getReference(consulta.getClass(), consulta.getId());
                estudioRealizado.setConsulta(consulta);
            }
            em.persist(estudioRealizado);
            if (consulta != null) {
                consulta.getEstudios().add(estudioRealizado);
                consulta = em.merge(consulta);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(EstudioRealizado estudioRealizado) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            EstudioRealizado persistentEstudioRealizado = em.find(EstudioRealizado.class, estudioRealizado.getId());
            Consulta consultaOld = persistentEstudioRealizado.getConsulta();
            Consulta consultaNew = estudioRealizado.getConsulta();
            if (consultaNew != null) {
                consultaNew = em.getReference(consultaNew.getClass(), consultaNew.getId());
                estudioRealizado.setConsulta(consultaNew);
            }
            estudioRealizado = em.merge(estudioRealizado);
            if (consultaOld != null && !consultaOld.equals(consultaNew)) {
                consultaOld.getEstudios().remove(estudioRealizado);
                consultaOld = em.merge(consultaOld);
            }
            if (consultaNew != null && !consultaNew.equals(consultaOld)) {
                consultaNew.getEstudios().add(estudioRealizado);
                consultaNew = em.merge(consultaNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = estudioRealizado.getId();
                if (findEstudioRealizado(id) == null) {
                    throw new NonexistentEntityException("The estudioRealizado with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Long id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            EstudioRealizado estudioRealizado;
            try {
                estudioRealizado = em.getReference(EstudioRealizado.class, id);
                estudioRealizado.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The estudioRealizado with id " + id + " no longer exists.", enfe);
            }
            Consulta consulta = estudioRealizado.getConsulta();
            if (consulta != null) {
                consulta.getEstudios().remove(estudioRealizado);
                consulta = em.merge(consulta);
            }
            em.remove(estudioRealizado);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<EstudioRealizado> findEstudioRealizadoEntities() {
        return findEstudioRealizadoEntities(true, -1, -1);
    }

    public List<EstudioRealizado> findEstudioRealizadoEntities(int maxResults, int firstResult) {
        return findEstudioRealizadoEntities(false, maxResults, firstResult);
    }

    private List<EstudioRealizado> findEstudioRealizadoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(EstudioRealizado.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public EstudioRealizado findEstudioRealizado(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(EstudioRealizado.class, id);
        } finally {
            em.close();
        }
    }

    public int getEstudioRealizadoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<EstudioRealizado> rt = cq.from(EstudioRealizado.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
