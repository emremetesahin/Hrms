package kodlama.io.hrms;

import java.time.LocalDateTime;
import java.util.regex.Pattern;

import kodlama.io.hrms.core.utilities.helpers.Generators.RandomStringGenerator;

public class Main {

	public static void main(String[] args) {
		System.out.println(RandomStringGenerator.Generate(5));
		LocalDateTime time = LocalDateTime.now().plusDays(1);
		System.out.println(time);
		String regex = "(\\Ahttps?:\\/\\/(?:www\\.|(?!www))[a-zA-Z0-9][a-zA-Z0-9-]+[a-zA-Z0-9]\\.[^\\s]{2,}|www\\.[a-zA-Z0-9][a-zA-Z0-9-]+[a-zA-Z0-9]\\.[^\\s]{2,}|https?:\\/\\/(?:www\\.|(?!www))[a-zA-Z0-9]+\\.[^\\s]{2,}|www\\.[a-zA-Z0-9]+\\.[^\\s]{2,})";
		String string="www.foufos.com";
		var result=Pattern.matches(regex, string);
		System.out.println(result);
		//AuthManager.isMailAdressContainsWebSiteDomain(emremetesahin, string)
	}
}