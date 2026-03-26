package com.study.develop.service;

import com.study.develop.entity.Actor;
import com.study.develop.entity.City;
import com.study.develop.repository.ActorRepository;
import com.study.develop.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;


@Component
public class CityService {

    @Autowired
    private CityRepository cityRepository;

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

    public City getCity (Integer id){
        return cityRepository.findById(id).get();
    }

    public List<City> getCityList (){
        return cityRepository.findAll();
    }

//    public void boardDelete (Integer id){
//        boardRepository.deleteById(id);
//    }

}

