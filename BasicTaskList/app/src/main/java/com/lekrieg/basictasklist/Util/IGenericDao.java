package com.lekrieg.basictasklist.Util;

import java.util.List;

public interface IGenericDao<T> {
	public boolean save(T t);
	public boolean update(T t);
	public boolean delete(T t);

	public List<T> listContent();
}
