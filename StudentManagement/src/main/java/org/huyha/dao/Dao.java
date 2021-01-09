package org.huyha.dao;

import java.io.Serializable;
import java.util.Collection;
import java.util.Optional;

public interface Dao<T> {

	Optional<T> get(int id, Class<T> type);

	Collection<T> getAll(Class<T> type);

	int save(T t);

	int update(T t);

	int delete(T t);
}
