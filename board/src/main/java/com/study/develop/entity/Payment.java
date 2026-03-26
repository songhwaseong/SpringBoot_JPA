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
import org.springframework.data.annotation.LastModifiedDate;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int payment_id	     ;

    private int customer_id	     ;

    private int staff_id	     ;

    private Integer rental_id	     ;

    private double amount	     ;

    @CreatedDate
    private Timestamp payment_date;

    @LastModifiedDate
    private Timestamp last_update;



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
