package com.study.develop.service;

import com.study.develop.entity.Qualifications;
import com.study.develop.repository.QualificationsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class QualificationsService {

    @Autowired
    private QualificationsRepository qualificationsRepository;

//    public void write(Board board, MultipartFile file) throws Exception{
//
//        String projectPath = System.getProperty("user.dir") + "\\board\\src\\main\\resources\\static\\files";
//
//        UUID uuid = UUID.randomUUID();
//
//        String filename = uuid + "_" + file.getOriginalFilename();
//
//        File saveFile = new File(projectPath, filename);
//
//        file.transferTo(saveFile);
//
//        board.setFilename(filename);
//        board.setFilepath("/files/" + filename);
//
//        boardRepository.save(board);
//    }

//    public Page<Board> boardList (Pageable pagealbe){
//        return boardRepository.findAll(pagealbe);
//    }

    public void write(Qualifications qualifications){
        qualificationsRepository.save(qualifications);
    }

    public Qualifications getQualifications (Integer id){
        return qualificationsRepository.findById(id).get();
    }

    public List<Qualifications> getQualificationsList(){
        return qualificationsRepository.findAll();
    }

//    public void boardDelete (Integer id){
//        boardRepository.deleteById(id);
//    }

}

