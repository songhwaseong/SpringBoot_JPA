package com.study.develop.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Qualifications {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id	              ;
    private Integer obligfldcd	  ;
    private String seriescd		  ;
    private String jmcd		      ;
    private String mdobligfldnm	  ;
    private String seriesnm		  ;
    private int mdobligfldcd	  ;
    private String obligfldnm	  ;
    private String qualgbcd		  ;
    private String jmfldnm		  ;
    private String qualgbnm		  ;
}


//@Entity
//@Table(name="BOARD")
//@SequenceGenerator(
//        name = "BOARD_SEQ_GENERATOR",  // JPA에서 사용할 시퀀스 이름
//        sequenceName = "board_id_seq",    // 오라클 시퀀스 이름
//        initialValue = 1,             // 초기값
//        allocationSize = 1            // 증가값 (DB 시퀀스의 INCREMENT BY 값과 동일)
//)
//@Data
//public class Board {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "BOARD_SEQ_GENERATOR")
//    private Integer id;
//
//    private String title;
//
//    private String content;
//
//    private String filename;
//
//    private String filepath;
//
//}
