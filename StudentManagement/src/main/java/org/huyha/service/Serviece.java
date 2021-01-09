package org.huyha.service;

import java.util.Collection;
import java.util.Optional;

public interface Serviece<T> {

	Optional<T> get(int id, Class<T> type);

	Collection<T> getAll(Class<T> type);

	boolean save(T t);

	boolean update(T t);

	boolean delete(T t);
}
