package kr.bit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kr.bit.entity.Board;

@Repository //생략 가능
public interface BoardRepository extends JpaRepository<Board, Long>{
	
	

}
