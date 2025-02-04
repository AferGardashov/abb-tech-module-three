package az.abbtech.student.repository.impl;

import az.abbtech.student.entity.StudentClassEntity;
import az.abbtech.student.repository.StudentClassRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class StudentClassRepositoryImpl implements StudentClassRepository {

    JdbcTemplate jdbcTemplate;

    public StudentClassRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void save(StudentClassEntity studentClass) {
        String sql = "INSERT INTO student_class (STUDENT_ID, CLASS_ID) VALUES (?, ?)";
        jdbcTemplate.update(sql, studentClass.getStudentId(), studentClass.getClassId());
    }

    @Override
    public StudentClassEntity findById(int id) {
        String sql = "SELECT * FROM student_class WHERE STUDENT_ID = ?";
        return jdbcTemplate.queryForObject(sql, studentClassEntityRowMapper, id);
    }

    @Override
    public List<StudentClassEntity> findAll() {
        String sql = "SELECT * FROM student_class";
        return jdbcTemplate.query(sql, studentClassEntityRowMapper);
    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM student_class WHERE STUDENT_ID = ?";
        jdbcTemplate.update(sql, id);
    }

    @Override
    public void update(StudentClassEntity studentClass) {
        String sql = "UPDATE student_class SET CLASS_ID = ? WHERE STUDENT_ID = ?";
        jdbcTemplate.update(sql, studentClass.getClassId(), studentClass.getStudentId());
    }

    private static RowMapper<StudentClassEntity> studentClassEntityRowMapper = new RowMapper<StudentClassEntity>() {
        @Override
        public StudentClassEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
            return new StudentClassEntity(rs.getInt("id")
                    , rs.getInt("student_id")
                    , rs.getInt("class_id"));
        }
    };
}
