package Lesson_2.Enum;

public class DayOfWeekMain {
    public static void main(final String[] args) {
        System.out.println(getWorkingHours(DayOfWeek.SUNDAY));
    }

    private static String getWorkingHours(Enum<DayOfWeek> day) {
        int workWeekHour = 40;
        int dayWorkHour = 8;
        int hour = 0;
        String msg;
        switch (day.ordinal()) {
            case 0:
                hour = workWeekHour;
                break;
            case 1:
                hour = workWeekHour - dayWorkHour * day.ordinal();
                break;
            case 2:
                hour = workWeekHour - dayWorkHour * day.ordinal();;
                break;
            case 3:
                hour = workWeekHour - dayWorkHour * day.ordinal();;
                break;
            case 4:
                hour = workWeekHour - dayWorkHour * day.ordinal();;
                break;
            case 5:
                hour = 0;
            case 6:
                hour = 0;
                break;
        }
        if(day.ordinal() <= 4) {
            msg = "Сегодня " + day + " до конца рабочей недели осталось: " + hour + " часов";
        } else {
            msg = "Ура! Сегодня " + day + " - выходной. Нужно срочно отдыхать!";
        }
        return msg;
    }
}
