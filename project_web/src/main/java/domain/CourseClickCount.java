package domain;

import org.springframework.stereotype.Component;

/**
 * 实战课程访问数量实体类
 */
@Component
public class CourseClickCount {

    private String name;
    private long value;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getValue() {
        return value;
    }

    public void setValue(long value) {
        this.value = value;
    }
}
