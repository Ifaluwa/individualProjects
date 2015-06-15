class FooCorporation{
	public static final int MAX_HOURS = 60;
	public static final double MIN_PAY = 8.00;

	public static void totalPay(double pay, int hours){

		if(hours > MAX_HOURS || pay < MIN_PAY){
			System.out.println("error!");
		} else {
			if(hours > 40){
				double overTime = (hours - 40)*1.50;
				double total = overTime + (pay * 40);
				System.out.println(total);
			} else {
				double total = (pay * hours);
				System.out.println(total);
			}
		
		}

	}


	public static void main(String[] args){
		totalPay(7.50, 35);
		totalPay(8.20, 47);
		totalPay(10.00, 73);

	}
}
