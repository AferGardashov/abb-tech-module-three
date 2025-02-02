package az.abbtech.student.entity;

import java.math.BigDecimal;

public class StudentEntity{

    private Integer id;
    private String name;
    private BigDecimal score;
    private String username;
    private String password;

    public StudentEntity(Integer id, String name, BigDecimal score, String username, String password) {
        this.id = id;
        this.name = name;
        this.score = score;
        this.username = username;
        this.password = password;
    }

    public StudentEntity(String name, BigDecimal score, String username, String password) {
        this.name = name;
        this.score = score;
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getScore() {
        return score;
    }

    public void setScore(BigDecimal score) {
        this.score = score;
    }
}
