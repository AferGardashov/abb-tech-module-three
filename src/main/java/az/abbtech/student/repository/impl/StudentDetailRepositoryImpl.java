package az.abbtech.student.repository.impl;

import az.abbtech.student.entity.StudentDetailEntity;
import az.abbtech.student.repository.StudentDetailRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class StudentDetailRepositoryImpl implements StudentDetailRepository {

    JdbcTemplate jdbcTemplate;

    public StudentDetailRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void save(StudentDetailEntity studentDetailEntity) {
        String sql = "INSERT INTO student_detail(address, phone, city, student_id) VALUES(?,?,?,?)";
        jdbcTemplate.update(sql, studentDetailEntity.getAddress(), studentDetailEntity.getPhone(), studentDetailEntity.getCity(), studentDetailEntity.getStudentId());
    }

    @Override
    public List<StudentDetailEntity> findAll() {
        String sql = "SELECT * FROM student_detail";
        return jdbcTemplate.query(sql, studentDetailEntityRowMapper);
    }

    @Override
    public StudentDetailEntity findById(int id) {
        String sql = "SELECT * FROM student_detail WHERE student_id = ?";
        return jdbcTemplate.queryForObject(sql, studentDetailEntityRowMapper, id);
    }

    @Override
    public void deleteById(int id) {
        String sql = "DELETE FROM student_detail WHERE student_id = ?";
        jdbcTemplate.update(sql, id);
    }

    @Override
    public void update(StudentDetailEntity studentDetailEntity) {
        String sql = "UPDATE student_detail SET address=?, phone=?, city=?, student_id=? WHERE student_id = ?";
        jdbcTemplate.update(sql);
    }

    private static RowMapper<StudentDetailEntity> studentDetailEntityRowMapper = new RowMapper<StudentDetailEntity>() {
        @Override
        public StudentDetailEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
            return new StudentDetailEntity(rs.getInt("id")
                    , rs.getString("address")
                    , rs.getString("phone")
                    , rs.getString("city")
                    , rs.getInt("student_id")
            );
        }
    };
}
