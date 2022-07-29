package repeat.code1;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class GisaDAO {
    public boolean deleteData(int stdNo) throws SQLException {
        boolean flag = false;
        // 컨넥션 취득
        Connection con = ConnectionManager.getConnection();

        // 쿼리 작성
        String sql = "DELETE  FROM gisa3 WHERE std_no = "+stdNo;

        // 쿼리 전솔 통로 작성
        Statement stmt = con.createStatement();

        // 쿼리 전송
        int affectedCount = stmt.executeUpdate(sql);
        // 결과 처리
        if(affectedCount > 0) {
            flag = true;
        }
        // 연결된 통로 모두 닫기
        stmt.close();
        con.close();

        return flag;
    }
    public boolean insertData(ArrayList<StudentVO> list) throws SQLException {
        boolean flag = false;
        int affectedCount = 0;
        // 컨넥션 객체 가져오기
        Connection con = ConnectionManager.getConnection();
        Statement stmt = con.createStatement();

        for(StudentVO vo : list) {
            String sql = "INSERT INTO gisa3 VALUES (" + vo.getStdNo() + ",'" + vo.getEmail() + "'," +
                vo.getKor() + "," + vo.getEng() + "," + vo.getMath() + "," +
                vo.getSci() + "," + vo.getHist() + "," + vo.getTotal() + ",'" +
                vo.getMgrCode() + "','" + vo.getAccCode() + "','" + vo.getLocCode() + "')";
            // 삽입 준비
           stmt = con.createStatement();
            // 삽입
            affectedCount += stmt.executeUpdate(sql);
        }
        // 삽입 쿼리
//        String sql = "INSERT INTO gisa3 VALUES (" + vo.getStdNo() + ",'" + vo.getEmail() + "'," +
//                vo.getKor() + "," + vo.getEng() + "," + vo.getMath() + "," +
//                vo.getSci() + "," + vo.getHist() + "," + vo.getTotal() + ",'" +
//                vo.getMgrCode() + "','" + vo.getAccCode() + "','" + vo.getLocCode() + "')";

        // 연결된 통로 모두 닫기
        stmt.close();
        con.close();

        // 삽입 준비
        //Statement stmt = con.createStatement();

        // 삽입
        //affectedCount += stmt.executeUpdate(sql);
        if(affectedCount > 0) {
            flag = true;
        }
        return flag;


    }
}
