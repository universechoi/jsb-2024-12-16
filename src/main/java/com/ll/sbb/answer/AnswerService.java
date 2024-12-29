package com.ll.sbb.answer;

import com.ll.sbb.question.Question;
import com.ll.sbb.user.SiteUser;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AnswerService {

    private final AnswerRepository answerRepository;

    public void create(Question question, String content, SiteUser author) {
        Answer answer = Answer.builder().question(question).content(content).author(author).build();

        this.answerRepository.save(answer);
    }
}
