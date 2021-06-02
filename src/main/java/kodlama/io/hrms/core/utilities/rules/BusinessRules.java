package kodlama.io.hrms.core.utilities.rules;

import kodlama.io.hrms.core.utilities.results.Result;

public class BusinessRules {
	
	public static Result Run(Result... results)
	{
		for (Result result : results) {
			if(!result.getSuccess())
			{
				return result;
			
			}
			
		}
		return null;
	}

}
