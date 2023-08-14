package kr.bit.mapper;

import java.sql.Connection;
import java.util.List;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.bit.entity.Board;
import lombok.extern.log4j.Log4j;
@Log4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")

public class BoardMapperTest {

	@Autowired
	BoardMapper boardMapper;
	
//	@Test
//	public void testGetList() {
//		List<Board> list = boardMapper.getList();
//		for(Board vo: list) {
//			System.out.println(vo);
//		}
//	}
	@Test
	public void testInsert() {
		Board vo = new Board();
		vo.setMemID("bit02");
		vo.setTitle("B");
		vo.setContent("새로작성한글");
		vo.setWriter("욱");
		//boardMapper.insert(vo);
		boardMapper.insertSelectKey(vo);
		log.info(vo);
	}
	
	
}
