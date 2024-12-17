package com.ll.sbb.initData;

import com.ll.sbb.question.Question;
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
            Question question1 = questionService.save("초기데이터1", "내용1입니다.");
            Question question2 = questionService.save("초기데이터2", "내용2입니다.");
            Question question3 = questionService.save("초기데이터3", "내용3입니다.");
        };
    }
}
