package nag.com.worldcup_4;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class CheckDuplicates {

	private static String curDir = System.getProperty("user.dir");

	@SuppressWarnings("resource")
	public static void main(String[] args) throws FileNotFoundException, IOException {

		Utility util = new Utility();
		PropertyReader propReader = new PropertyReader();
		HashMap<String, String> propMap = propReader.getProperties(curDir + "/src/test/resources/config.properties");
		Integer[] nums = { 1, 1, 1, 3, 3, 4, 3, 2, 4, 2 };
		System.out.println("************ Check Duplicate Element in an Array ****************");
		System.out.println("Default Array - " + Arrays.asList(nums));
		System.out.println("Verifing Duplicate is number Array....");
		util.checkDuplicates(nums);

		Integer[] nums2 = { 1, 2, 3, 1 };
		System.out.println("Default Array 2 - " + Arrays.asList(nums2));
		System.out.println("Verifing Duplicate is number Array....");
		util.checkDuplicates(nums2);

		Integer[] nums3 = { 1, 2, 3, 4 };
		System.out.println("Default Array 3 - " + Arrays.asList(nums3));
		System.out.println("Verifing Duplicate is number Array....");
		util.checkDuplicates(nums3);

		Scanner in = new Scanner(System.in);

		List<String> invalidId;
		List<Integer> validId = new ArrayList<Integer>();
		boolean flag = false;

		System.out.println("Do wish to enter you own input.. [Y/N]. Any answer other than Y|y is considered as N");
		String s1 = in.nextLine();
		if (s1.equalsIgnoreCase("Y")) 
			flag = true;
		else
			System.out.println("................ Exiting ..........");
		while (flag) {
			int minSize = Integer.parseInt(propMap.get("minSize"));
			int maxSize = Integer.parseInt(propMap.get("maxSize"));
			int minValue = Integer.parseInt(propMap.get("minValue"));
			int maxValue = Integer.parseInt(propMap.get("maxValue"));
			System.out.println("");
			invalidId = new ArrayList<String>();
			validId = new ArrayList<Integer>();
			System.out.println("Enter nums array [Separated by ','].");
			System.out.println("****** Constraints *******");
			System.out.println("    " + minSize + " <= nums.length <= " + maxSize);
			System.out.println("   " + minValue + " <= nums[i] <= " + maxValue);
			System.out.println("e.g. ,-1,-10,40,1,2,3,4,5,6");
			System.out.println("************************************");
			System.out.println("Waiting for num array .......");

			String s = in.nextLine();
			String input[] = s.split(",");
			if (input.length >= minSize & input.length <= maxSize) {
				for (String str : input) {
					int i = 0;
					try {
						i = Integer.parseInt(str.trim());
						if (i <= maxValue & i >= minValue) {
							validId.add(i);
						} else {
							invalidId.add(str);
						}
					} catch (Exception e) {
						invalidId.add(str);
					}
				}
				if (!invalidId.isEmpty()) {
					System.out.println("Invalid values - " + invalidId);
					System.out.println("Would you like to continue with Valid Array Values (Y) : " + validId);
					System.out.println("              OR             ");
					System.out.println("Would you like to enter new Array (N)");
					String y_n = in.nextLine();
					if (!y_n.equalsIgnoreCase("y")) {
						continue;
					} 
				} 
				if (!validId.isEmpty()) {
					System.out.println("Array  - " + validId.toString());
					System.out.println("Verifing Duplicates in number Array....");
					util.checkDuplicates(validId.toArray(new Integer[0]));
				}
				else
					System.out.println("Array is Blank....");

			} else {
				System.out.println("Array length should be in range - "+minSize+ " to " +maxSize);
			}
			
			System.out.println("Do you want to enter a new Array [Y/N]. Any answer other than Y|y is considered as N - " );
			String y_n = in.nextLine();
			if (!y_n.equalsIgnoreCase("y")) {
				System.out.println("................ Exiting ..........");
				flag=false;
			} 		
			
		}

		

	}

}
