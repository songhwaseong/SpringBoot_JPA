package com.study.develop.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.Instant;
import java.time.LocalDateTime;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int customer_id;

    private int store_id;

    private String first_name;

    private String last_name;

    private String email;

    private int address_id;

    private int active;

    @CreatedDate
    private LocalDateTime create_date; // 생성 시간

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
