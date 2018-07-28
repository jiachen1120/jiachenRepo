class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Set<List<Integer>> set = new HashSet<> ();
        if (nums == null || nums.length < 3) {
            return res;
        }
        mergeSort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            int a = nums[i];
            int b_id = i + 1;
            int c_id = nums.length - 1;
            while (b_id < c_id) {
                if (nums[b_id] + nums[c_id] + a == 0) {
                    if (set.add(new ArrayList<Integer> (Arrays.asList(a, nums[b_id], nums[c_id])))) {
                        res.add(new ArrayList<Integer> (Arrays.asList(a, nums[b_id], nums[c_id])));
                    }
                    b_id++;
                    c_id--;
                } else if (nums[b_id] + nums[c_id] + a > 0) {
                    c_id--;
                } else {
                    b_id++;
                }
            }
        }
        return res;
    }
    
    public static void mergeSort(int arr[]) {
		if (arr == null || arr.length <= 1) {
			return;
		}
		int[] temp = new int[arr.length];
		mergeSort_rec(arr, temp, 0, arr.length - 1);
	}
	
	public static void mergeSort_rec(int arr[], int temp[], int str, int end) {
		if (str >= end) {
			return;
		}
		int mid = str + (end - str) / 2;
		mergeSort_rec(arr, temp, str, mid);
		mergeSort_rec(arr, temp, mid + 1, end);
		merge(arr, temp, str, mid, end);
	}
	
	public static void merge(int[] arr, int[] temp, int str, int mid, int end) {
		int s1 = str;
		int s2 = mid + 1;
		int s = 0;
		while (s1 <= mid && s2 <= end) {
			if (arr[s1] < arr[s2]) {
				temp[s++] = arr[s1++];
			} else {
				temp[s++] = arr[s2++];
			}
		}
		while (s1 <= mid) {
			temp[s++] = arr[s1++];
		}
		while (s2 <= end) {
			temp[s++] = arr[s2++];
		}
		for (int i = 0; i < end - str + 1; i++) {
			arr[str + i] = temp[i];
		}
	}
}