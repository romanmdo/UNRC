package _005_buble_sort;

import java.util.ArrayList;
import java.util.List;

public class Main {
	public static void main(String[] args) {
		BubbleSort b = new BubbleSort();

		b.bubbleSort(new ArrayList<>(List.of(7, 9, 3, 1)));
	}
}