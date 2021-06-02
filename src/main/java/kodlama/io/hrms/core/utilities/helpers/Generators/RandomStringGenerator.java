package kodlama.io.hrms.core.utilities.helpers.Generators;

import java.util.Locale;
import java.util.Random;

public class RandomStringGenerator {
	public static String Generate(int targetStringLenght)
	{
		int leftLimit=48;
		int rightLimit=122;
		Random random=new Random();
		String generatedString=random.ints(leftLimit,rightLimit+1).
				filter(i->(i<=57||i>=65)&&(i<=90||i>=97))
				.limit(targetStringLenght).collect(StringBuilder::new,StringBuilder::appendCodePoint,
						StringBuilder::append).toString().toUpperCase(new Locale("us"));
		return generatedString;
	}

}
