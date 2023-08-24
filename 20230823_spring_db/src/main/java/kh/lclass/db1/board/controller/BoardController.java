package kh.lclass.db1.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import kh.lclass.db1.board.model.service.BoardService;
import kh.lclass.db1.board.model.vo.BoardVo;

@Controller
@RequestMapping("/board")
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	
	@GetMapping("/list")
	public String list(Model model) {
		model.addAttribute("boardList", boardService.selectList());
		return "board/list";
	}
	
	@GetMapping("/get")
	public String get(Model model, int bno) {
		model.addAttribute("boardVo", boardService.selectOne(bno));
		return "board/get";
	}
	
	@GetMapping("/insert")
	public String insert() {
		return "board/insert";
	}

	@PostMapping("/insert")
	public String insertDo(BoardVo vo, String btitle) {
		System.out.println(vo);
		System.out.println(btitle);
		return "redirect:/board/list";	//절대위치 작성
	}
}
