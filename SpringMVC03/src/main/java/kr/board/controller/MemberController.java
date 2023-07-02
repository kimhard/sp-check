package kr.board.controller;

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
	public String memRegister(Member m, RedirectAttributes rttr) {
		if(m.getMemID()==null || m.getMemID().equals("")||
		   m.getMemPassword()==null || m.getMemPassword().equals("")||	
		   m.getMemName()==null || m.getMemName().equals("")||	
		   m.getMemAge()==0 || m.getMemName().equals("") || 
		   m.getMemGender()==null || m.getMemGender().equals("")||
		   m.getMemEmail()==null || m.getMemEmail().equals("")){
		   
		   //누락메세지를 가지고 가기? - > 객체바인딩( model, HttpServletRequest , HttpSession)
		   rttr.addFlashAttribute("msgType","누락 메세지");
		   rttr.addFlashAttribute("msg","모든 내용을 입력하세요.");
		   return "redirect:/memJoin.do";
			
			
		}
		   
				
		return "";
	}
}
