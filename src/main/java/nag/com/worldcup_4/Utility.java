package nag.com.worldcup_4;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Utility {
	
	public boolean checkDuplicates(Integer nums[]) {

		List<Integer> inputList = Arrays.asList(nums);
		Set<Integer> inputSet = new HashSet<Integer>(inputList);
		if (inputSet.size() < inputList.size()) {
			System.out.println("There is/are duplicate element/s.");
			return false;
		} else {
			System.out.println("There is no duplicate element.");
			return true;
		}

	}

}
