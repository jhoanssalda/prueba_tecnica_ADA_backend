package service;

import java.util.List;

public interface CRUDService<T, ID> {

    List<T> findAll();
    T findById(ID id);
    T create(T obj);
    T update(ID id, T obj);
    void delete(ID id);

}
