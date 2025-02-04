package az.abbtech.student.repository.impl;

import az.abbtech.student.entity.ClassEntity;
import az.abbtech.student.repository.ClassRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class ClassRepositoryImpl implements ClassRepository {

    JdbcTemplate jdbcTemplate;

    public ClassRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public void save(ClassEntity classEntity) {
        String sql = "INSERT INTO class (NAME) VALUES (?)";
        jdbcTemplate.update(sql, classEntity.getName());
    }

    @Override
    public List<ClassEntity> findAll() {
        String sql = "SELECT * FROM class";
        List<ClassEntity> classes = jdbcTemplate.query(sql, classEntityRowMapper);
        return classes;
    }

    @Override
    public ClassEntity findById(int id) {
        String sql = "SELECT * FROM class WHERE id = ?";
        ClassEntity classEntity = jdbcTemplate.queryForObject(sql, classEntityRowMapper, id);
        return classEntity;
    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM class WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }

    @Override
    public void update(ClassEntity classEntity) {
        String sql = "UPDATE class SET name = ? WHERE id = ?";
        jdbcTemplate.update(sql, classEntity.getName(), classEntity.getId());
    }

    private static RowMapper<ClassEntity> classEntityRowMapper = new RowMapper<ClassEntity>() {
        @Override
        public ClassEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
            return new ClassEntity(rs.getInt("id")
                    , rs.getString("name"));
        }
    };
}
