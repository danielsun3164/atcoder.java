package practice.practice;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ProblemB {

	/** Merge insertion sort用 */
	private static final int[] T = { 0, 2, 4, 10 };

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			@SuppressWarnings("unused")
			int n = scanner.nextInt(), q = scanner.nextInt();
			Character[] array = IntStream.range(0, n).mapToObj(i -> Character.valueOf((char) (i + 'A')))
					.toArray(Character[]::new);
			Comparator<Character> comparator = new Comparator<Character>() {
				@Override
				public int compare(Character o1, Character o2) {
					System.out.println("? " + o1 + " " + o2);
					char result = scanner.next().charAt(0);
					return ('>' == result) ? 1 : -1;
				}
			};
			if (5 == n) {
				List<Character> list = mergeInsertionSort(array, comparator);
				for (int i = 0; i < n; i++) {
					array[i] = list.get(i);
				}
			} else {
				mergeSort(array, 0, array.length, comparator);
			}
			System.out.println("! " + toString(array));
		}
	}

	/**
	 * 配列を文字列へ変換
	 *
	 * @param array 配列
	 * @return 変換された文字列
	 */
	private static String toString(Character[] array) {
		StringBuilder sb = new StringBuilder();
		Arrays.stream(array).forEach(c -> sb.append(c));
		return sb.toString();
	}

	/**
	 * マージソートの実装
	 *
	 * @param array      ソート対象の配列
	 * @param start      ソート開始位置
	 * @param end        ソート終了位置（含まない）
	 * @param comparator 比較メソッド
	 */
	private static void mergeSort(Character[] array, int start, int end, Comparator<Character> comparator) {
		int size = end - start;
		if (1 == size) {
			return;
		}
		Character[] array2 = new Character[array.length];
		System.arraycopy(array, start, array2, 0, size);
		mergeSort(array2, 0, size >> 1, comparator);
		mergeSort(array2, size >> 1, size, comparator);
		int count = start, count1 = 0, count2 = size >> 1;
		while (count < end) {
			if (count1 == (size >> 1)) {
				array[count++] = array2[count2++];
			} else if (count2 == size) {
				array[count++] = array2[count1++];
			} else if (comparator.compare(array2[count1], array2[count2]) < 0) {
				array[count++] = array2[count1++];
			} else {
				array[count++] = array2[count2++];
			}
		}
	}

	/**
	 * Merge insertion sortの実装
	 *
	 * Knuth, Donald E. (1998), "Merge insertion", The Art of Computer Programming, Vol. 3: Sorting and Searching (2nd
	 * ed.), pp. 184–186 に従って実装、計算量ではなく、比較回数を一番少なく実装したもの、N<11のみに使用する予定
	 *
	 * @param array      ソート対象の配列
	 * @param comparator 比較メソッド
	 * @return ソートされた配列
	 */
	private static List<Character> mergeInsertionSort(Character[] array, Comparator<Character> comparator) {
		if (1 == array.length) {
			return Arrays.stream(array).collect(Collectors.toList());
		}
		for (int i = 0; i < (array.length / 2); i++) {
			// ペアの比較
			if (comparator.compare(array[i * 2], array[(i * 2) + 1]) > 0) {
				swap(array, i * 2, (i * 2) + 1);
			}
		}
		// ペアの大きいほうをソートし、リストへ追加
		List<Character> result = mergeInsertionSort(
				IntStream.range(0, array.length / 2).mapToObj(i -> array[(i * 2) + 1]).toArray(Character[]::new),
				comparator);
		Character[] larges = result.toArray(Character[]::new);
		for (int i = 0; i < T.length; i++) {
			int start = (0 == i) ? -1 : T[i - 1];
			if (start >= array.length) {
				break;
			}
			for (int j = T[i]; j > start; j--) {
				if (j < larges.length) {
					insert(result, array[indexOf(array, larges[j]) - 1], 0, result.indexOf(larges[i]), comparator);
				} else if (((2 * j) + 1) == array.length) {
					insert(result, array[2 * j], 0, result.size(), comparator);
				} else {
					break;
				}
			}
		}
		return result;
	}

	/**
	 * 配列の中のdataのインデックスを返す
	 *
	 * @param array 配列
	 * @param data  データ
	 * @return 配列の中のdataのインデックス
	 */
	private static int indexOf(Character[] array, Character data) {
		for (int i = 0; i < array.length; i++) {
			if (data.equals(array[i])) {
				return i;
			}
		}
		return 0;
	}

	/**
	 * 配列のi番目のものとj番目と交換する
	 *
	 * @param array 配列
	 * @param i
	 * @param j
	 */
	private static void swap(Character[] array, int i, int j) {
		Character temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}

	/**
	 * リストの開始位置と終了位置の間にデータを大きさ順に挿入する
	 *
	 * @param list       リスト
	 * @param data       該当データ
	 * @param start      開始位置
	 * @param end        終了位置（含まない）
	 * @param comparator 比較メソッド
	 */
	private static void insert(List<Character> list, Character data, int start, int end,
			Comparator<Character> comparator) {
		if (start == end) {
			list.add(start, data);
			return;
		}
		int med = (start + end) / 2;
		if (comparator.compare(list.get(med), data) < 0) {
			insert(list, data, med + 1, end, comparator);
		} else {
			insert(list, data, start, med, comparator);
		}
	}
}
