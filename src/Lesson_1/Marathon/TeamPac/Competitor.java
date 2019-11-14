package Lesson_1.Marathon.TeamPac;

public interface Competitor {
    void run(int dist);
    void swim(int dist);
    void jump(int height);
    boolean isOnDistance();
    void info();
    void fullInfo();

}