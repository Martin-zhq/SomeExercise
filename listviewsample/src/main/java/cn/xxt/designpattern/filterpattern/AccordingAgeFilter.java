package cn.xxt.designpattern.filterpattern;

import java.util.ArrayList;
import java.util.List;

public class AccordingAgeFilter implements FilterInterface {

    @Override
    public List<Student> filterStudent(List<Student> students) {
        List<Student> accrodingAgeList = new ArrayList<>();

        for (Student student : students) {
            if (23 > student.getAge()) {
                accrodingAgeList.add(student);
            }
        }

        return accrodingAgeList;
    }
}
