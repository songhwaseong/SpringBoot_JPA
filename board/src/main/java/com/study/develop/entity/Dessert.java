package com.study.develop.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Dessert {

    @Id
    private int id	        ;
    private int price	        ;
    private int quantity	        ;
    private int stock	        ;
    private String name	        ;
    private String image	    ;
    private String category         ;
    private String desc         ;
    private String regDate         ;
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
