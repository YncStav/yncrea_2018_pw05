package yncrea.pw05.web.service.impl;

import org.modelmapper.ModelMapper;
import yncrea.pw05.contract.dto.StudentDTO;
import yncrea.pw05.contract.facade.StudentWS;
import yncrea.pw05.core.entity.Student;
import yncrea.pw05.core.service.StudentService;

import javax.inject.Named;
import javax.jws.WebService;
import java.util.ArrayList;
import java.util.List;

@Named("studentWS")
@WebService(endpointInterface = "yncrea.pw05.contract.facade.StudentWS")
public class StudentWSImpl implements StudentWS{

    private StudentService studentService;

    private StudentDTO convertToDTO(Student studentService){
        ModelMapper modelMapper = new ModelMapper();
        StudentDTO studentDTO = modelMapper.map(studentService, StudentDTO.class);
        return studentDTO;
    }

    private Student DTOToStudent(StudentDTO studentDTO){
        ModelMapper modelMapper = new ModelMapper();
        Student student = modelMapper.map(studentDTO, Student.class);
        return student;
    }

    @Override
    public List<StudentDTO> getAllStudents() {
        List<Student> students = studentService.findAll();
        List<StudentDTO> DTOStudents = new ArrayList<>();
        for (Student student: students) {
            DTOStudents.add(convertToDTO(student));
        }
        return DTOStudents;
    }

    @Override
    public void saveStudent(StudentDTO student) {
        studentService.saveStudent(DTOToStudent(student));
    }
}
