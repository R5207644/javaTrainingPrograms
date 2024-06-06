//WAP to move element one position next and last element at first

import java.util.Scanner;
public class MoveInArray {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n, temp;

		System.out.print("enter size of array = ");
		n = sc.nextInt();
		System.out.println();
		int[] arr = new int[n];

		System.out.println("enter array = ");
		for(int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}

		temp = arr[n-1];

		for(int i = n-1; i >= 1; i--) {
			arr[i] = arr[i-1];
		}

		arr[0] = temp;

		System.out.println("your array is = ");
		for(int i = 0; i < n; i++) {
			System.out.print(arr[i]+" ");
		}
		sc.close();
	}
}