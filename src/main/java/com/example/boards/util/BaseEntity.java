package com.example.boards.util;

import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseEntity {

    @CreatedDate
    public LocalDateTime createdAt; // 초기 설정 할때 날짜
    @LastModifiedDate
    public LocalDateTime modifiedAt; // 수정 할때 날짜



}
