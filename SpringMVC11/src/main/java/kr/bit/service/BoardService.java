package kr.bit.service;

import java.util.List;

import kr.bit.entity.Board;

public interface BoardService {
	
	public List<Board> getList();
	public void register(Board vo);
	public Board get(Long idx);
	public void delete(Long idx);
	public void update(Board vo); // 수정
}
