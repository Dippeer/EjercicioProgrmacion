package curso.dao;

import java.util.List;

import curso.exception.DAOException;

public interface DAO<T, K>  {
	public void add(T element) throws DAOException;

	public T get(K key)throws DAOException;

	public List<T> getAll()throws DAOException;

	public void uptade(T element)throws DAOException;

	public boolean remove(K key)throws DAOException;
}
