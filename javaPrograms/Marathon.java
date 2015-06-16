
class Marathon{
	public static int findFastestTime(int[] times){
		int fastest = Integer.MAX_VALUE;
		int timeIndex = -1;

		for(int i = 0; i < times.length; i++){
			if (times[i] < fastest){
				fastest = times[i];
				timeIndex = i;
			}
		}
		return timeIndex;
	}

	public static int secondFastest(int [] times, int firstFastest){
		int fastest = times[0];
		int timeIndex = 0;

		for(int i = 0; i < times.length; i++){
					if (times[i] < fastest && times[i] > firstFastest){
						fastest = times[i];
						timeIndex = i;
					}
			}
			return timeIndex;

	}
	

	public static void main(String[] args){
		String[] names = {"Elena", "Thomas", "Hamilton", "Suzie", "Phil", "Matt", "Alex", "Emma", "John", "James", "Jane", "Emily", "Daniel", "Neda", "Aaron", "Kate"};
		int[] times ={341,273,278,329,445,402,388,275,243,334,412,393,299,343,317,265};

		// for (int i = 0; i < names.length; i++){
		// 	System.out.println(names[i] + ":" + times[i]);
		// }
		

		int fastestTime = findFastestTime(times);
		System.out.println("The fastest runner is " + names[fastestTime] + " with a speed of " + times[fastestTime]);
		int secondFastestTime = secondFastest(times, times[fastestTime]);
		System.out.println("The 2nd fastest runner is " + names[secondFastestTime] + " with a speed of " + times[secondFastestTime]);

	}


}