package kodlama.io.hrms;

import java.time.LocalDateTime;

import kodlama.io.hrms.core.utilities.helpers.Generators.RandomStringGenerator;


public class Main {

	public static void main(String[] args) {
		System.out.println(RandomStringGenerator.Generate(5));
		LocalDateTime time=LocalDateTime.now().plusDays(1);
		System.out.println(time);
		}
}