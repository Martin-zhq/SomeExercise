package cn.xxt.designpattern.filterpattern;

import java.util.ArrayList;
import java.util.List;

public class ComputerFilter implements FilterInterface {

    @Override
    public List<Student> filterStudent(List<Student> students) {
        List<Student> csers = new ArrayList<>();

        for (Student student : students) {
            if ("computer".equals(student.getMajor())) {
                csers.add(student);
            }
        }

        return csers;
    }
}
