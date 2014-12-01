package tw.edu.ncu.cc.manage.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import tw.edu.ncu.cc.manage.repository.IDao;

@Repository
public class DaoImpl<T> implements IDao<T>
{
    
    private EntityManager entityManager;
    
    @PersistenceContext
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    public T find(Class<T> clazz, int id) {
        return entityManager.find(clazz, id);
    }
    public void create(T baseBean) {
        entityManager.persist(baseBean);
    }

    public void save(T baseBean) {
       entityManager.merge(baseBean);        
    }

    public void delete(T baseBean) {
        T bean=entityManager.merge(baseBean);
        entityManager.remove(bean);
    }

    public int getTotalCount(String hql, Object... params) {
        //???
        Query query = creatQuery(hql);
        for(int i=0; params!=null && i<params.length;i++){
            query.setParameter(i+1, params[i]);
        }
        Object object = creatQuery(hql).getFirstResult();
        return ((Long)object).intValue();
    }

    @SuppressWarnings("unchecked")
    public List<T> list(String hql, int firstResult, int maxSize,
            Object... params) {
      //???
        Query query = creatQuery(hql);
        for(int i=0; params != null && i <params.length;i++){
            query.setParameter(i+1, params[i]);
        }
        List<T> list = creatQuery(hql).setFirstResult(firstResult).setMaxResults(maxSize).getResultList();
        return list;
    }

    public Query creatQuery(String hql) {
        return entityManager.createQuery(hql);
    }

}
