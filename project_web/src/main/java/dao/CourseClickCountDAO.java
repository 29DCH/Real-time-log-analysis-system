package dao;

import domain.CourseClickCount;
import utils.HBaseUtils;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 实战课程访问数量数据访问层
 */
@Component
public class CourseClickCountDAO {


    /**
     * 根据天查询
     */
    public List<CourseClickCount> query(String day) throws Exception {

        List<CourseClickCount> list = new ArrayList<>();


        // 去HBase表中根据day获取实战课程对应的访问量
        Map<String, Long> map = HBaseUtils.getInstance().query("imooc_course_clickcount","20171022");

        for(Map.Entry<String, Long> entry: map.entrySet()) {
            CourseClickCount model = new CourseClickCount();
            model.setName(entry.getKey());
            model.setValue(entry.getValue());

            list.add(model);
        }

        return list;
    }

    public static void main(String[] args) throws Exception{
        CourseClickCountDAO dao = new CourseClickCountDAO();
        List<CourseClickCount> list = dao.query("20171022");
        for(CourseClickCount model : list) {
            System.out.println(model.getName() + " : " + model.getValue());
        }
    }

}
