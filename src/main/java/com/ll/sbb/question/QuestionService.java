package com.ll.sbb.question;

import com.ll.sbb.DataNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class QuestionService {

    private final QuestionRepository questionRepository;

    public Question save(String Subject, String content) {
        Question question = new Question();
        question.setSubject(Subject);
        question.setContent(content);

        this.questionRepository.save(question);

        return question;
    }

    public List<Question> getList() {
        return this.questionRepository.findAll();
    }

    public Question getQuestion(Integer id) {
        Optional<Question> question = this.questionRepository.findById(id);
        if (question.isPresent()) {
            return question.get();
        } else {
            throw new DataNotFoundException("question not found");
        }
    }

    public long count() {
        return this.questionRepository.count();
    }
}
