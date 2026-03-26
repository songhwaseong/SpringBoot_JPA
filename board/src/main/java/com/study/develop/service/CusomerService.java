package com.study.develop.service;

import com.study.develop.entity.City;
import com.study.develop.entity.Customer;
import com.study.develop.repository.CityRepository;
import com.study.develop.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CusomerService {

    @Autowired
    private CustomerRepository customerRepository;

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

    public Customer getCustomer (Integer id){
        return customerRepository.findById(id).get();
    }

    public List<Customer> getCustomerList (){
        return customerRepository.findAll();
    }

//    public void boardDelete (Integer id){
//        boardRepository.deleteById(id);
//    }

}

