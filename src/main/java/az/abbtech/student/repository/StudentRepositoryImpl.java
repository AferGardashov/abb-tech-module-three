package az.abbtech.student.repository;

import az.abbtech.student.entity.StudentEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class StudentRepositoryImpl implements StudentRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public StudentRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void saveStudent(StudentEntity student) {
        String sql = "INSERT INTO student (NAME, SCORE, USERNAME, PASSWORD) VALUES (?,?,?,?)";
        jdbcTemplate.update(sql, student.getName(), student.getScore(), student.getUsername(), student.getPassword());
    }

    @Override
    public List<StudentEntity> findAll() {
        String sql = "SELECT * FROM student";
        List<StudentEntity> students = jdbcTemplate.query(sql, studentEntityRowMapper);
        return students;
    }

    @Override
    public StudentEntity findById(int id) {
        String sql = "SELECT * FROM student WHERE id = ?";
        StudentEntity student = jdbcTemplate.queryForObject(sql, studentEntityRowMapper, id);
        return student;
    }

    @Override
    public void deleteById(int id) {
        String sql = "DELETE FROM student_lesson_grade WHERE id = ?; " +
                "DELETE FROM student_detail WHERE id = ?; " +
                "DELETE FROM student WHERE id = ?; ";
        jdbcTemplate.update(sql, id, id, id);
    }

    @Override
    public void update(StudentEntity student) {
        String sql = "UPDATE student SET name = ?, score = ?, username = ?, password = ? WHERE id = ?";
        jdbcTemplate.update(sql, student.getName(), student.getScore(), student.getUsername(), student.getPassword(), student.getId());
    }

    private static RowMapper<StudentEntity> studentEntityRowMapper = new RowMapper<StudentEntity>() {
        @Override
        public StudentEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
            return new StudentEntity(rs.getInt("id")
                    , rs.getString("name")
                    , rs.getBigDecimal("score")
                    , rs.getString("username")
                    , rs.getString("password"));
        }
    };

}
