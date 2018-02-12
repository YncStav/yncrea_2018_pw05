package yncrea.pw05.client;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import yncrea.pw05.contract.dto.StudentDTO;
import yncrea.pw05.contract.facade.StudentWS;

import java.util.List;

public class ClientApp {
    public static void main(String[] args){
        final AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        final StudentWS studentWS = context.getBean()
        final List<StudentDTO> allStudents = studentWS.getAllStudents();
        allStudents.stream();
    }
}
