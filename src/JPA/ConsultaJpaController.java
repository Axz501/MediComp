/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JPA;

import JPA.exceptions.NonexistentEntityException;
import Logica.Consulta;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import Logica.EstudioRealizado;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author Admin
 */
public class ConsultaJpaController implements Serializable {

    public ConsultaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Consulta consulta) {
        if (consulta.getEstudios() == null) {
            consulta.setEstudios(new ArrayList<EstudioRealizado>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<EstudioRealizado> attachedEstudios = new ArrayList<EstudioRealizado>();
            for (EstudioRealizado estudiosEstudioRealizadoToAttach : consulta.getEstudios()) {
                estudiosEstudioRealizadoToAttach = em.getReference(estudiosEstudioRealizadoToAttach.getClass(), estudiosEstudioRealizadoToAttach.getId());
                attachedEstudios.add(estudiosEstudioRealizadoToAttach);
            }
            consulta.setEstudios(attachedEstudios);
            em.persist(consulta);
            for (EstudioRealizado estudiosEstudioRealizado : consulta.getEstudios()) {
                Consulta oldConsultaOfEstudiosEstudioRealizado = estudiosEstudioRealizado.getConsulta();
                estudiosEstudioRealizado.setConsulta(consulta);
                estudiosEstudioRealizado = em.merge(estudiosEstudioRealizado);
                if (oldConsultaOfEstudiosEstudioRealizado != null) {
                    oldConsultaOfEstudiosEstudioRealizado.getEstudios().remove(estudiosEstudioRealizado);
                    oldConsultaOfEstudiosEstudioRealizado = em.merge(oldConsultaOfEstudiosEstudioRealizado);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Consulta consulta) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Consulta persistentConsulta = em.find(Consulta.class, consulta.getId());
            List<EstudioRealizado> estudiosOld = persistentConsulta.getEstudios();
            List<EstudioRealizado> estudiosNew = consulta.getEstudios();
            List<EstudioRealizado> attachedEstudiosNew = new ArrayList<EstudioRealizado>();
            for (EstudioRealizado estudiosNewEstudioRealizadoToAttach : estudiosNew) {
                estudiosNewEstudioRealizadoToAttach = em.getReference(estudiosNewEstudioRealizadoToAttach.getClass(), estudiosNewEstudioRealizadoToAttach.getId());
                attachedEstudiosNew.add(estudiosNewEstudioRealizadoToAttach);
            }
            estudiosNew = attachedEstudiosNew;
            consulta.setEstudios(estudiosNew);
            consulta = em.merge(consulta);
            for (EstudioRealizado estudiosOldEstudioRealizado : estudiosOld) {
                if (!estudiosNew.contains(estudiosOldEstudioRealizado)) {
                    estudiosOldEstudioRealizado.setConsulta(null);
                    estudiosOldEstudioRealizado = em.merge(estudiosOldEstudioRealizado);
                }
            }
            for (EstudioRealizado estudiosNewEstudioRealizado : estudiosNew) {
                if (!estudiosOld.contains(estudiosNewEstudioRealizado)) {
                    Consulta oldConsultaOfEstudiosNewEstudioRealizado = estudiosNewEstudioRealizado.getConsulta();
                    estudiosNewEstudioRealizado.setConsulta(consulta);
                    estudiosNewEstudioRealizado = em.merge(estudiosNewEstudioRealizado);
                    if (oldConsultaOfEstudiosNewEstudioRealizado != null && !oldConsultaOfEstudiosNewEstudioRealizado.equals(consulta)) {
                        oldConsultaOfEstudiosNewEstudioRealizado.getEstudios().remove(estudiosNewEstudioRealizado);
                        oldConsultaOfEstudiosNewEstudioRealizado = em.merge(oldConsultaOfEstudiosNewEstudioRealizado);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = consulta.getId();
                if (findConsulta(id) == null) {
                    throw new NonexistentEntityException("The consulta with id " + id + " no longer exists.");
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
            Consulta consulta;
            try {
                consulta = em.getReference(Consulta.class, id);
                consulta.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The consulta with id " + id + " no longer exists.", enfe);
            }
            List<EstudioRealizado> estudios = consulta.getEstudios();
            for (EstudioRealizado estudiosEstudioRealizado : estudios) {
                estudiosEstudioRealizado.setConsulta(null);
                estudiosEstudioRealizado = em.merge(estudiosEstudioRealizado);
            }
            em.remove(consulta);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Consulta> findConsultaEntities() {
        return findConsultaEntities(true, -1, -1);
    }

    public List<Consulta> findConsultaEntities(int maxResults, int firstResult) {
        return findConsultaEntities(false, maxResults, firstResult);
    }

    private List<Consulta> findConsultaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Consulta.class));
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

    public Consulta findConsulta(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Consulta.class, id);
        } finally {
            em.close();
        }
    }

    public int getConsultaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Consulta> rt = cq.from(Consulta.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
