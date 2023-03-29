package demo_drill_for_test;

import java.time.LocalDate;

public class dateFactory {
public static LocalDate getLocalDate() {
	int day = (int) (Math.random()*27)+1;
	int month = (int) (Math.random()*11)+1;
	int year = (int) (Math.random()*50)+1960;
	return LocalDate.of(year, month, day);
	
}
}
