package org.huyha.dao;

import java.io.Serializable;
import java.util.Collection;
import java.util.Optional;

import org.hibernate.Session;
import org.huyha.exception.StudentNotAuthorizedException;

public interface Dao<T> {

	Optional<T> get(int id, Class<T> type);

	Collection<T> getAll(Class<T> type);

	T save(T t);

	void update(T t);

	void delete(T t);
}
