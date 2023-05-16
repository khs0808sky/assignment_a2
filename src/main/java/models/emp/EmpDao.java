package models.emp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Connection;
import java.sql.PreparedStatement;

@Transactional
public class EmpDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public long insert(Emp emp) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        String sql = "INSERT INTO EMP2 (EMPNO, ENAME, JOB) VALUES (?, ?, ?)";
       jdbcTemplate.update(con -> {
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setLong(1, emp.getEMPNO());
            pstmt.setString(2, emp.getENAME());
            pstmt.setString(3, emp.getJOB());
            return pstmt;
        }, keyHolder);

       Number key = keyHolder.getKey();
       long EMPNO = key.longValue();
       return EMPNO;
    }

    public long update(Emp emp) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        String sql = "UPDATE EMP2 SET ENAME = ? WHERE EMPNO = ?";
        jdbcTemplate.update(con -> {
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1, emp.getENAME());
            pstmt.setLong(2, emp.getEMPNO());
            return pstmt;
        }, keyHolder);

        Number key = keyHolder.getKey();
        long EMPNO = key.longValue();
        return EMPNO;
    }

    public long delete(Emp emp) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        String sql = "DELETE FROM EMP2 WHERE EMPNO = ?";
        jdbcTemplate.update(con -> {
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setLong(1, emp.getEMPNO());
            return pstmt;
        }, keyHolder);

        Number key = keyHolder.getKey();
        long EMPNO = key.longValue();
        return EMPNO;
    }

    public Emp get(long EMPNO) {
        try {
            Connection conn = null;
            String sql = "SELECT * FROM EMP WHERE EMPNO = ?";
            Emp emp = jdbcTemplate.queryForObject(con -> {
                PreparedStatement pstmt = conn.prepareStatement(sql);
                pstmt.setLong(1, EMPNO);
            });
            return emp;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
