package interfaces;

import java.util.ArrayList;

public interface DAOinterface<T> {
	public int insert(T t);
	public int update(T t);
	public int delete(String t);
	public ArrayList<T> selectAll();
	public ArrayList<T> Find(T t);
}
