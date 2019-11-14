package Lesson_1.Marathon.CoursePac;

import Lesson_1.Marathon.TeamPac.Team;
import Lesson_1.Marathon.TeamPac.Competitor;

public class Course{
    Obstacle[] course;

    public Course(Obstacle...course) {
        this.course = course;
    }

    public void doItAll(Team team){
        for(Competitor c : team.getCompetitors()){
            for (Obstacle o : course){
                o.doIt(c);
                if (!c.isOnDistance()) break;
            }
        }
    }



}