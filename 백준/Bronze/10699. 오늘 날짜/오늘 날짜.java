import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class Main {
	public static void main(String[] args) {
		System.out.println(ZonedDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
	}
}