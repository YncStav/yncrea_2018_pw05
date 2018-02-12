package yncrea.pw05.contract.facade;

import yncrea.pw05.contract.dto.StudentDTO;

import javax.jws.WebService;
import java.util.List;

@WebService
public interface StudentWS {
    public List<StudentDTO> getAllStudents();
    public void saveStudent(StudentDTO student);
}
