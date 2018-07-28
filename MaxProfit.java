package jiachen.algorithm;

public class MaxProfit {
	public static int[] maxProfit(int[] arr) {
		if (arr == null || arr.length < 2) {
			return new int[]{-1};
		}
		int currentBuy = arr[0];
		int globalSell = arr[1];
		int globalProfit = globalSell - currentBuy;
		
		int currentProfit = Integer.MIN_VALUE;
		for(int i = 0; i < arr.length; i++) {
			currentProfit = arr[i] - currentBuy;
			if (currentProfit > globalProfit) {
				globalProfit = currentProfit;
				globalSell = arr[i];
			}
			if (arr[i] < currentBuy) {
				currentBuy = arr[i];
			}
		}
		int globalBuy = globalSell - globalProfit;
		return new int[] {globalBuy, globalSell, globalProfit};
	}
}
