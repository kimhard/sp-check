package kr.board.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kr.board.entity.Member;
import kr.board.mapper.MemberMapper;

@Controller
public class MemberController {
	
	@Autowired
	MemberMapper memberMapper;
	
	@RequestMapping("/memJoin.do")
	public String memJOin() {
		return "member/join";
	}
	
	@RequestMapping("/memregisterCheck.do")
	public @ResponseBody int memregisterCheck(@RequestParam("memID") String memID) {
		Member m = memberMapper.registerCheck(memID);
		if(m !=null|| memID.equals("")) {
			return 0; // 이미 회원이 존재하거나, 회원가입때 아무것도 입력을 안했을떄
		}
		return 1; // 사용가능한 아이디를 쳤을때는 1로 리턴
		
	}
	//회원가입처리
	@RequestMapping("/memRegister.do")
	public String memRegister(Member m, RedirectAttributes rttr, HttpSession session) {
		if(m.getMemID()==null || m.getMemID().equals("")||
		   m.getMemName()==null || m.getMemName().equals("")||	
		   m.getMemAge()==0 || m.getMemName().equals("") || 
		   m.getMemGender()==null || m.getMemGender().equals("")||
		   m.getMemEmail()==null || m.getMemEmail().equals("")){
		   
		   //누락메세지를 가지고 가기? - > 객체바인딩( model, HttpServletRequest , HttpSession)
		   rttr.addFlashAttribute("msgType","누락 메세지");
		   rttr.addFlashAttribute("msg","모든 내용을 입력하세요.");
		   return "redirect:/memJoin.do";
		}
		m.setMemProfile(""); //사진이 없다는 의미 ""
		//회원을 테이블에 저장하기
		int result = memberMapper.register(m);
		if(result==1) { //회원가입 성공 메시지 보내기
			rttr.addFlashAttribute("msgType","성공 메세지");
			rttr.addFlashAttribute("msg","회원가입의 성공했습니다.");
			// 	회원가입 성공하면 -> 로그인처리 까지 되는걸로 , 로그인이 되면 보통 세션으로 처리한다. 
			session.setAttribute("m", m);
			return "redirect:/";
			
		}else {
			
		}
		
		
		return "";
	}
}
