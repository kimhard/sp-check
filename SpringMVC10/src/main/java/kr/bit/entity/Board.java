package kr.bit.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Board { //vo로도 사용이 되지만 실제로는 DB의 table로 간다.
	
	@Id //PK
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idx;
	private String title;
	
	@Column(length=2000)
	private String content;
	
	@Column(updatable=false)
	private String writer;
	
	
	@Column(insertable = false, updatable = false, columnDefinition ="datetime default now()")
	private Date indate; //now()
	@Column(insertable = false, updatable = false, columnDefinition ="int default 0")
	private Long count;
	
}
