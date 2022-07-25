package bit.project.lawbot.domain;

import lombok.Data;

import java.util.List;

@Data
public class ChartDTO {
    private long chart;

    //지울거
    private String student;

    //공통
    private String type;
    private int year;

    //harm_response
    private float elementary;
    private float middle;
    private float high;

    //attacker_type
    private float same_school_same_class;
    private float same_school_same_grade;
    private float same_school_other_grade;
    private float other_school;
    private float unknown;
    private float other;

    //harm_type
    private float speech;
    private float bullying;
    private float stalking;
    private float physical;
    private float cyber;
    private float extortion;
    private float sexual;
    private float coercion;

    private List<Integer> result1;
    private List<Integer> result2;
}
