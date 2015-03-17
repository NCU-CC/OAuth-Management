package tw.edu.ncu.cc.manage.service;

import java.util.List;

public interface IService<T> {
    public T find(Class<T> clazz,int id);
    public void create(T baseBean);
    public void save(T baseBean);
    public void delete(T baseBean);
//    public List<T> list(String query);
    public int getTotalCount(String query,Object... params);
    public List<T> list(String query, int firstResult, int maxSize, Object ... params);
    
}
