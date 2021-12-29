package com.StreletsA.deeplay;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Main {

	public static void main(String[] args) {
		
		// Task 1
		/*
		int[] arr = new int[] {3,1,8,4,6,5};
		
		for(int num : findThreeMaxNums(arr)) {
			System.out.print(String.valueOf(num) + " ");
		}
		*/
		
		// Task 2
		/*
		System.out.print(calculateSumOfDigits(123));
		*/
		
		// Task 3
		/*
		int[] arr = new int[] {1, 2, 2, 2, 2, 5, 6, 7, 7, 8};
		ArrayList<ArrayList<Integer>> ans = distributeIntoEqualGroups(arr, 3);
		
		for(ArrayList<Integer> group : ans) {
			for(int i : group) {
				System.out.print(String.valueOf(i) + " ");
			}
			System.out.println();
		}
		*/
		
	}
	
	// O(n)
	private static int[] findThreeMaxNums(int[] arr) {
		
		if (arr.length < 3)
			return arr;
		
		int[] answer = new int[3];
		
		answer[0] = arr[0];
		answer[1] = arr[0];
		answer[2] = arr[0];
		
		for(int num : arr) {
			if(num > answer[2]) {
				if(num > answer[1]) {
					if(num > answer[0]) {
						answer[2] = answer[1];
						answer[1] = answer[0];
						answer[0] = num;
					}
					
					else {
						answer[2] = answer[1];
						answer[1] = num;
					}
					
				}
				
				else {
					answer[2] = num;
				}
				
			}
			
		}
		
		return answer;

	}
	
	// O(n)
	private static int calculateSumOfDigits(int num) {
		
		int sum = 0;
		
		while(num > 0) {
			
			sum += num % 10;
			num /= 10;
			
		}
		
		return sum;
		
	}
	
	/*
	 * 1 5 8
	 * 7 7
	 * 2 2 2 2 6
	 * 
	 * 1 2 2 2 2 5 6 7 7 8 -> 42
	 * 
	 * 8 6
	 * 7 7
	 * 5 2 2 2 2 1
	 */
	
	private static ArrayList<ArrayList<Integer>> distributeIntoEqualGroups(int[] arr, int countOfGroups) {
		
		Integer[] integerArr = new Integer[arr.length];
		
		for(int i = 0; i < arr.length; i++)
			integerArr[i] = arr[i];
		
		ArrayList<Integer> arrList = new ArrayList(Arrays.asList(integerArr));
		ArrayList<ArrayList<Integer>> ansList = new ArrayList<>();
		
		int sum = 0;
		
		for(int i : arr)
			sum += i;
		
		if(sum % countOfGroups != 0)
			return null;
		
		Collections.sort(arrList);
		
		for(int i = 0; i < countOfGroups; i++) {
			
			ArrayList<Integer> group = new ArrayList<>();
			
			int groupSum = 0;
			int index = arrList.size() - 1;
			
			while(groupSum != sum / countOfGroups) {
				
				if(groupSum + arrList.get(index) <= sum / countOfGroups) {
					groupSum += arrList.get(index);
					group.add(arrList.get(index));
					arrList.remove(index);
				}
				
				index--;
				
			}
			
			ansList.add(group);
			
		}
		
		return ansList;
	}
	
}
