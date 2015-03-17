package tw.edu.ncu.cc.manage.repository;

import java.util.List;

import javax.persistence.Query;

public interface IDao<T> {
    public T find(Class<T> clazz, int id);
    public void create(T baseBean);
    public void save(T baseBean);
    public void delete(T baseBean);
    public int getTotalCount(String hql, Object... params);
//    public List<T> list(String hql);
    public List<T> list(String hql, int firstResult, int maxSize,Object... params);
    public Query creatQuery(String hql);
}
