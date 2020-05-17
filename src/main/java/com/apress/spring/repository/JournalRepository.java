package com.apress.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.apress.spring.domain.Journal;

public interface JournalRepository extends JpaRepository<Journal, Long> {
	// JpaRepository 상속해서 JPA 기술 구현
	// spring data repository 엔진이 자동으로 인지하여 CURD 및 custom method 구현 가능
}
