package com.ll.sbb;

import com.ll.sbb.question.Question;
import com.ll.sbb.question.QuestionRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@ActiveProfiles("test")
class SbbApplicationTests {

    @Autowired
    private QuestionRepository questionRepository;

    @Test
    @DisplayName("questionRepository.save()")
    void saveTest() {
        Question q1 = new Question();
        q1.setSubject("sbb가 무엇인가요?");
        q1.setContent("sbb에 대해 알고 싶습니다.");
        this.questionRepository.save(q1);

        Question q2 = new Question();
        q2.setSubject("스프링 부트 모델 질문입니다.");
        q2.setContent("id는 자동으로 생성되나요?");
        this.questionRepository.save(q2);
    }

    @Test
    @DisplayName("findAll()")
    void findAllTest() {
        List<Question> all = this.questionRepository.findAll();
        assertEquals(2, all.size());

        Question q = all.get(0);
        assertEquals("sbb가 무엇인가요?", q.getSubject());
    }

    @Test
    @DisplayName("findById()")
    void findByIdTest() {
        Optional<Question> oq = this.questionRepository.findById(1);
        if (oq.isPresent()) {
            Question q = oq.get();
            assertEquals("sbb가 무엇인가요?", q.getSubject());
        }
    }

    @Test
    @DisplayName("findBySubject()")
    void findBySubjectTest() {
        Question q = this.questionRepository.findBySubject("sbb가 무엇인가요?");
        assertEquals(1, q.getId());
    }
}
