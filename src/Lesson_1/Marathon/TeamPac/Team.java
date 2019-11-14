package Lesson_1.Marathon.TeamPac;

import Lesson_1.Marathon.TeamPac.Cat;
import Lesson_1.Marathon.TeamPac.Competitor;
import Lesson_1.Marathon.TeamPac.Dog;
import Lesson_1.Marathon.TeamPac.Human;

public class Team {
    String teamName;

    public Team(String teamName) {
        this.teamName = teamName;
    }

    Competitor[] competitors = {new Human("Боб", 3000, 60, 60),
                                new Cat("Барсик"),
                                new Dog("Бобик"),
                                new Human("Джек", 6000, 400, 30)};

    public Competitor[] getCompetitors() {
        return competitors;
    }
    public void teamInfo(){
        System.out.println("Состав команды " + teamName);
        for (Competitor c: competitors) {
            c.fullInfo();
        }
        System.out.println();
    }

    public void passInfo(){
        System.out.println("В команде " + teamName + " все препятствия прошли: ");
        for (Competitor c : competitors) {
            if (c.isOnDistance())
            c.info();
        }
        System.out.println();
    }
}
