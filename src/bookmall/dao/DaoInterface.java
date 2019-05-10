package bookmall.dao;

import java.util.List;

public interface DaoInterface<E> {
	public int insert(E vo);
	public List<E> getList();
	public List<E> getList(E condition);
	public int update(int no, E vo);
	public int delete(int no);
}
