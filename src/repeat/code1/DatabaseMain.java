package repeat.code1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class DatabaseMain {
    public static void main(String[] args) throws IOException {
        DatabaseMain main = new DatabaseMain();

        ArrayList<StudentVO> list = main.getFileData();
        //main.testDelete();
        main.testInsert(list);
    }

    public void testDelete() throws SQLException {

        GisaDAO dao = new GisaDAO();
        boolean flag = dao.deleteData(990002);

        if(flag) {
            System.out.println("DELETE 성공");
        } else {
            System.out.println("DELETE 실패");
        }
    }

    private ArrayList<StudentVO> getFileData() throws IOException {
        ArrayList<StudentVO> list = new ArrayList<StudentVO>();

        // 파일 읽어오기
        File file = new File("./Abc1115.csv");
        FileReader fr = new FileReader(file);
        // 한줄씩 읽기
        BufferedReader br = new BufferedReader(fr);
        //String data ="990001,addx, 17, 29, 16, 49, 43,154,C,A,C";

        String line = null;
        StudentVO vo = null;

        while ((line = br.readLine()) != null) {
            vo = new StudentVO(line);
            list.add(vo);
        }
        br.close();
        fr.close();

        return list;
    }

    public void testInsert(ArrayList<StudentVO> list) throws IOException {

            GisaDAO dao = new GisaDAO();

            try {
                boolean flag = dao.insertData(list);
                if (flag) {
                    System.out.println("INSERT 성공");
                } else {
                    System.out.println("INSERT 실패");
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

}

