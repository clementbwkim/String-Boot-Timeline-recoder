package com.apress.spring;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.apress.spring.domain.Journal;
import com.apress.spring.repository.JournalRepository;

@SpringBootApplication
public class SpringBootJournalApplication {
 
    
    
    //InitializingBean은 스프링 엔진이 인스턴스 생성 후 초기화 할 때 항상 호출하는 특수 클래스
    //saveData는 스프링 시동 준비전에 실행
	@Bean // Bean 생성
    InitializingBean saveData(JournalRepository repo) {
        return () ->{
        	repo.save(new Journal("스프링 부트 입문","스프링 공부 시작", "05/17/2020"));
			repo.save(new Journal("스프링 프로젝트 샘플","스프링 샘플!", "05/18/2020"));
			repo.save(new Journal("스프링 부트 구조","스프링 구조 탐색", "05/19/2020"));
			repo.save(new Journal("스프링 부트 클라우드","스프링 부트 클라우드 활용", "05/20/2020"));
			repo.save(new Journal("번 아웃 방지 휴식","휴식", "05/21/2020"));
			repo.save(new Journal("복습 단계","복습", "05/22/2020"));
        };
    } // saveData(JournalRepository repo)는 앱이 시동 준비를 마치기 전에 실행
     
    public static void main(String[] args) {
        SpringApplication.run(SpringBootJournalApplication.class, args);
    }
}

