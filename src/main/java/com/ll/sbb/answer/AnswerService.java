package com.ll.sbb.answer;

import com.ll.sbb.question.Question;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AnswerService {

    private final AnswerRepository answerRepository;

    public void create(Question question, String content) {
        Answer answer = Answer.builder().question(question).content(content).build();

        this.answerRepository.save(answer);
    }
}
