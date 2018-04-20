/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JPA;

import JPA.exceptions.NonexistentEntityException;
import Logica.NombredeEstudio;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author Admin
 */
public class NombredeEstudioJpaController implements Serializable {

    public NombredeEstudioJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(NombredeEstudio nombredeEstudio) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(nombredeEstudio);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(NombredeEstudio nombredeEstudio) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            nombredeEstudio = em.merge(nombredeEstudio);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = nombredeEstudio.getId();
                if (findNombredeEstudio(id) == null) {
                    throw new NonexistentEntityException("The nombredeEstudio with id " + id + " no longer exists.");
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
            NombredeEstudio nombredeEstudio;
            try {
                nombredeEstudio = em.getReference(NombredeEstudio.class, id);
                nombredeEstudio.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The nombredeEstudio with id " + id + " no longer exists.", enfe);
            }
            em.remove(nombredeEstudio);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<NombredeEstudio> findNombredeEstudioEntities() {
        return findNombredeEstudioEntities(true, -1, -1);
    }

    public List<NombredeEstudio> findNombredeEstudioEntities(int maxResults, int firstResult) {
        return findNombredeEstudioEntities(false, maxResults, firstResult);
    }

    private List<NombredeEstudio> findNombredeEstudioEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(NombredeEstudio.class));
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

    public NombredeEstudio findNombredeEstudio(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(NombredeEstudio.class, id);
        } finally {
            em.close();
        }
    }

    public int getNombredeEstudioCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<NombredeEstudio> rt = cq.from(NombredeEstudio.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
