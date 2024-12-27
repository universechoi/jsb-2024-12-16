package com.ll.sbb.initData;

import com.ll.sbb.question.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class InitData {

    private final QuestionService questionService;

    @Bean
    public ApplicationRunner initDataApplicationRunner() {
        return args -> {
            if (questionService.count() > 0) {
                return ;
            }
            for (int i = 0; i <= 300; i++) {
                String subject = String.format("테스트 데이터입니다.:[%03d]", i);
                String content = "내용 없음";
                this.questionService.create(subject, content);
            }
        };
    }
}
