package com.study.develop.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Film {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int film_id;

    private String title		         ;

    private String description           ;

    private short  release_year		     ;

    private int    language_id		     ;

    private Integer	   original_language_id	 ;

    private int    rental_duration	     ;

    private double rental_rate		     ;

    private int    length		         ;

    private double replacement_cost	     ;

    private String rating	             ;

    private String special_features		 ;

    @LastModifiedDate
    private LocalDateTime last_update; // 수정 시간


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
