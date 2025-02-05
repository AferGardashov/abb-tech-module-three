package az.abbtech.student;

import az.abbtech.student.dto.req.ReqStudentDto;
import az.abbtech.student.dto.resp.RespStudentDto;
import az.abbtech.student.entity.StudentEntity;
import az.abbtech.student.repository.StudentRepository;
import az.abbtech.student.service.impl.StudentServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class StudentServiceImplTest {

    @Mock
    private StudentRepository studentRepository;

    @InjectMocks
    private StudentServiceImpl studentServiceImpl;

    @BeforeEach
    void setUp() {
        studentServiceImpl = new StudentServiceImpl(studentRepository);
    }

    @Test
    void testSaveStudent() {
        ReqStudentDto reqStudent =
                new ReqStudentDto("John Doe", BigDecimal.valueOf(85), "johndoe", "password123");
        studentServiceImpl.saveStudent(reqStudent);
        verify(studentRepository, times(1)).saveStudent(any(StudentEntity.class));

    }

    @Test
    void testGetStudents() {
        List<StudentEntity> mockStudents = List.of(
                new StudentEntity(1, "Alice", BigDecimal.valueOf(76), "alice123", "pass1"),
                new StudentEntity(2, "Bob", BigDecimal.valueOf(70.80), "bob456", "pass2")
        );

        when(studentRepository.findAll()).thenReturn(mockStudents);

        List<RespStudentDto> students = studentServiceImpl.getStudents();

        assertEquals(2, students.size());
        assertEquals("Alice", students.get(0).name());
        assertEquals("Bob", students.get(1).name());
    }

    @Test
    void testGetStudentById() {
        StudentEntity mockStudent = new StudentEntity(1, "Charlie", BigDecimal.valueOf(75), "charlie789", "pass3");

        when(studentRepository.findById(1)).thenReturn(mockStudent);

        RespStudentDto student = studentServiceImpl.getStudentById(1);

        assertNotNull(student);
        assertEquals("Charlie", student.name());
        assertEquals(BigDecimal.valueOf(75), student.score());
    }

    @Test
    void testDeleteStudentById() {
        doNothing().when(studentRepository).deleteById(1);

        studentServiceImpl.deleteStudentById(1);

        verify(studentRepository, times(1)).deleteById(1);
    }

    @Test
    void testUpdateStudent() {
        ReqStudentDto reqStudent = new ReqStudentDto("Updated Name", BigDecimal.valueOf(90), "updateduser", "newpass");

        studentServiceImpl.updateStudent(reqStudent, 1);

        verify(studentRepository, times(1)).update(any(StudentEntity.class));
    }
}
