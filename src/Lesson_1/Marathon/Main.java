package Lesson_1.Marathon;

import Lesson_1.Marathon.CoursePac.Course;
import Lesson_1.Marathon.CoursePac.Cross;
import Lesson_1.Marathon.CoursePac.Wall;
import Lesson_1.Marathon.CoursePac.Water;
import Lesson_1.Marathon.TeamPac.Team;

public class Main {
    public static void main(String[] args) {
        Team team = new Team("Super Team");
        Course course = new Course(new Cross(80), new Water(2), new Wall(1), new Cross(120));
        team.teamInfo();
        course.doItAll(team);
        team.passInfo();
    }
}