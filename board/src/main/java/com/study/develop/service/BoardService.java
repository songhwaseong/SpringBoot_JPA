package com.study.develop.service;

import com.study.develop.entity.Board;
import com.study.develop.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.UUID;


@Service
public class BoardService {

    @Autowired
    private BoardRepository boardRepository;

    public void write(Board board, MultipartFile file) throws Exception{

        String projectPath = System.getProperty("user.dir") + "\\board\\src\\main\\resources\\static\\files";

        UUID uuid = UUID.randomUUID();

        String filename = uuid + "_" + file.getOriginalFilename();

        File saveFile = new File(projectPath, filename);

        file.transferTo(saveFile);

        board.setFilename(filename);
        board.setFilepath("/files/" + filename);

        boardRepository.save(board);
    }

    public Page<Board> boardList (Pageable pagealbe){
        return boardRepository.findAll(pagealbe);
    }

    public Board boardDetail (Integer id){
        return boardRepository.findById(id).get();
    }

    public void boardDelete (Integer id){
        boardRepository.deleteById(id);
    }

}

