package com.study.develop.service;

import com.study.develop.entity.Country;
import com.study.develop.entity.Film;
import com.study.develop.repository.CountryRepository;
import com.study.develop.repository.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CountryService {

    @Autowired
    private CountryRepository countryRepository;

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

    public Country getCountry (Integer id){return countryRepository.findById(id).get();}


    public List<Country> getCountryList(){
        return countryRepository.findAll();
    }

//    public void boardDelete (Integer id){
//        boardRepository.deleteById(id);
//    }

}

