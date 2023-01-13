package com.driver.services;

import com.driver.models.Card;
import com.driver.models.Student;
import com.driver.repositories.CardRepository;
import com.driver.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {


    @Autowired
    CardService cardService4;

    @Autowired
    StudentRepository studentRepository4;
    @Autowired
    private CardRepository cardRepository;

    public Student getDetailsByEmail(String email){
        Student student = null;
        student = studentRepository4.findByEmailId(email);
        return student;
    }

    public Student getDetailsById(int id){
        Student student = null;
        student = studentRepository4.findById(id).get();
        return student;
    }

    public void createStudent(Student student){
        try{
            Card card = cardService4.createAndReturn(student);
            cardRepository.save(card);
            //it should save student automatically bcz card is the parent .
        }catch (Exception e){
            System.out.println(e);
        }
    }

    public void updateStudent(Student student){
        try{
            int cardId = student.getCard().getId();
            Card card = cardService4.updateCard(cardId,student);
            cardRepository.save(card);
            //since card is parent it should automatically change the student table
        }catch(Exception e){
            System.out.println(e);
        }

    }

    public void deleteStudent(int id){
        //Delete student and deactivate corresponding card
        try{
            studentRepository4.deleteById(id);
            cardService4.deactivateCard(id);
        }catch(Exception e){
            System.out.println(e);
        }
    }
}
