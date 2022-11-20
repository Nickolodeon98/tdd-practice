package algorithms.programmers;

public class EnumTest {
    public static void main(String[] args) {
        WeekDays weekDays = WeekDays.values()[0]; // MONDAY
        WeekDays weekDays1 = WeekDays.values()[3]; // THURSDAY

        for (WeekDays day : WeekDays.values()) {
            System.out.println(day);
        }
    }
}
