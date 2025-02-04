package az.abbtech.student.repository.impl;

import az.abbtech.student.entity.StudentLessonGradeEntity;
import az.abbtech.student.repository.StudentLessonGradeRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class StudentLessonGradeRepositoryImpl implements StudentLessonGradeRepository {

    JdbcTemplate jdbcTemplate;

    public StudentLessonGradeRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void save(StudentLessonGradeEntity studentLessonGrade) {
        String sql = "INSERT INTO student_lesson_grade(grade, student_id) VALUES(?, ?)";
        jdbcTemplate.update(sql, studentLessonGrade.getGrade(), studentLessonGrade.getStudentId());
    }

    @Override
    public List<StudentLessonGradeEntity> findAll() {
        String sql = "SELECT * FROM student_lesson_grade";
        return jdbcTemplate.query(sql, studentLessonGradeEntityRowMapper);
    }

    @Override
    public StudentLessonGradeEntity findById(int id) {
        String sql = "SELECT * FROM student_lesson_grade WHERE student_id = ?";
        return jdbcTemplate.queryForObject(sql, studentLessonGradeEntityRowMapper, id);
    }

    @Override
    public void deleteById(int id) {
        String sql = "DELETE FROM student_lesson_grade WHERE student_id = ?";
        jdbcTemplate.update(sql, id);
    }

    @Override
    public void update(StudentLessonGradeEntity studentLessonGrade) {
        String sql = "UPDATE student_lesson_grade SET grade = ? WHERE student_id = ?";
        jdbcTemplate.update(sql, studentLessonGrade.getGrade(), studentLessonGrade.getStudentId());
    }

    private static RowMapper<StudentLessonGradeEntity> studentLessonGradeEntityRowMapper = new RowMapper<StudentLessonGradeEntity>() {
        @Override
        public StudentLessonGradeEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
            return new StudentLessonGradeEntity(rs.getInt("id")
                    , rs.getBigDecimal("grade")
                    , rs.getInt("student_id"));
        }
    };
}
