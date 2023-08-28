package kh.lclass.db1.board.controller;

import java.security.Principal;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kh.lclass.db1.board.model.service.BoardService;
import kh.lclass.db1.board.model.vo.BoardVo;

@Controller
@RequestMapping("/board")
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	
	@GetMapping("/list")
	public ModelAndView list(
//			RedirectAttributes rttr,
			//			Model model	>controller > JSP 데이터 전달
			ModelAndView mv
			) throws Exception{
		
		//안보임. 의미없음. >  JSP에서 데이터 꺼내짐.
//		System.out.println(rttr.getAttribute("msg2"));
//		Map<String, Object> map = (Map<String, Object>) rttr.getFlashAttributes();
//		System.out.println(map);
				
//		model.addAttribute("boardList", boardService.selectList());
//		return "board/list";
		mv.addObject("boardList", boardService.selectList());
		mv.setViewName("board/list");
		return mv;
	}
	
	@GetMapping("/get")
	public String get(Model model, int bno) throws Exception {
		
		//controller > JSP 데이터 전달
		model.addAttribute("boardVo", boardService.selectOne(bno));
		//controller > JSP 선택 forward
		return "board/get";
	}
	
	@GetMapping("/insert")
	public String insert(){
		return "board/insert";
	}

	@PostMapping("/insert")
	public String insertDo(
			RedirectAttributes redirectAttr, 
			// redirect:/URL시 데이터를 전달하기 위해 추가된 자료형 url > jsp
			BoardVo vo, String btitle, Principal principal
			) {
		
		
		//
		String viewPage ="redirect:/";
		
		System.out.println(vo);
		System.out.println(btitle);
		
		//TODO login 한 mid 
		vo.setMid("kh1");
//		String mid = principal.getName();
		
		int result;
		try {
			result = boardService.insert(vo);
			//1 : 글 등록 성공, 0 : 실패
			if (result<1) {
				redirectAttr.addFlashAttribute("msg", "글등록 실패했습니다. 다시 입력하고 등록해주세요.");
				viewPage = "redirect:/board/insert";
			}else {
				redirectAttr.addFlashAttribute("msg", "글 등록되었습니다.");
				viewPage = "redirect:/board/list";
			}
		} catch (Exception e) {
			//오류발생시
			viewPage = "redirect:/board/list";
		}
		
		return viewPage;	//절대위치 작성
	}
//	@ExceptionHandler
//	public void e() {}
}
