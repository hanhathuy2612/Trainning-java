package service;

import java.util.Collection;
import java.util.Optional;

public interface Service<T> {
	
	Optional<T> get(int id);
    Collection<T> getAll();
    boolean save(T t);
    boolean update(T t);
    boolean delete(T t);
}
