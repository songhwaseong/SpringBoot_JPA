package com.study.develop.contorller;

import com.study.develop.entity.Board;
import com.study.develop.service.ActorService;
import com.study.develop.service.BoardService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;


@Slf4j
@Controller
public class BoardController {  //localhost:8080/board/write

    @Autowired
    private BoardService boardService;
    @Autowired
    private ActorService actorService;

    @GetMapping("/board/write")
    public String boardWriteForm(){

        log.info("======>>>>> write");
        return "boardWrite";
    }

    @PostMapping("/board/writepro")
    public String boardWritePro(Board board, Model model, MultipartFile file) throws  Exception{
        boardService.write(board, file);

        model.addAttribute("message", "글 작성이 완료되었습니다.");
        model.addAttribute("searchUrl", "/board/boardList");

        return "message";
    }

    @GetMapping("/board/boardList")
    public String boardList(Model model, @PageableDefault(page = 0, size = 10, sort = "id", direction = Sort.Direction.DESC) Pageable pagealbe){

        Page<Board> list = boardService.boardList(pagealbe);

        int nowPage = list.getPageable().getPageNumber();
        int startPage = Math.max(nowPage - 4, 1);
        int endPage = Math.min(nowPage + 5, list.getTotalPages());

        model.addAttribute("list", list);
        model.addAttribute("nowPage", nowPage);
        model.addAttribute("startPage", startPage);
        model.addAttribute("endPage", endPage);

        return "boardList";
    }

    @GetMapping("/board/view")
    public String boardDetail(Model model, Integer id){
        model.addAttribute("board", boardService.boardDetail(id));
        model.addAttribute("actor", actorService.getActor(1));
        model.addAttribute("actorList", actorService.getActorList());

        return "boardView";
    }

    @GetMapping("/board/modify")
    public String boardModify(Model model, Integer id){
        model.addAttribute("board", boardService.boardDetail(id));
        return "boardModify";
    }

    @GetMapping("/board/delete")
    public String boardDelete(Integer id){
        boardService.boardDelete(id);
        return "redirect:/board/boardList";
    }

    @PostMapping("/board/update")
    public String boardWritePro(Board board, MultipartFile file) throws Exception {
        boardService.write(board, file);

        return "redirect:/board/boardList";
    }
}
