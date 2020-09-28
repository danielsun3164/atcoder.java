package other.joi2006yo;

import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemC {

	/** 東へ回転するコマンド */
	private static final String EAST = "East";
	/** 南へ回転するコマンド */
	private static final String SOUTH = "South";
	/** 西へ回転するコマンド */
	private static final String WEST = "West";
	/** 北へ回転するコマンド */
	private static final String NORTH = "North";
	/** 右へ回転するコマンド */
	private static final String RIGHT = "Right";
	/** 左へ回転するコマンド */
	private static final String LEFT = "Left";

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			// 順番に上、東、南、西、北、下の数字を表す
			int[] saikoro = new int[] { 1, 3, 2, 4, 5, 6 };
			System.out.println(IntStream.range(0, n).map(i -> process(saikoro, scanner.next())).sum() + 1);
		}
	}

	/**
	 * サイコロに操作を行い、一番上の数字を返す
	 * 
	 * @param saikoro サイコロを表す配列
	 * @param command 操作コマンド
	 * @return 操作後のサイコロの一番上の数字
	 */
	private static int process(int[] saikoro, String command) {
		switch (command) {
		case EAST:
			swap(saikoro, 0, 1);
			swap(saikoro, 5, 3);
			swap(saikoro, 0, 5);
			break;
		case SOUTH:
			swap(saikoro, 0, 2);
			swap(saikoro, 5, 4);
			swap(saikoro, 0, 5);
			break;
		case WEST:
			swap(saikoro, 0, 3);
			swap(saikoro, 5, 1);
			swap(saikoro, 0, 5);
			break;
		case NORTH:
			swap(saikoro, 0, 4);
			swap(saikoro, 5, 2);
			swap(saikoro, 0, 5);
			break;
		case LEFT:
			swap(saikoro, 2, 1);
			swap(saikoro, 4, 3);
			swap(saikoro, 2, 4);
			break;
		default:
		case RIGHT:
			swap(saikoro, 1, 2);
			swap(saikoro, 3, 4);
			swap(saikoro, 1, 3);
			break;
		}
		return saikoro[0];
	}

	/**
	 * 数列のi番目とj番目を交換する
	 * 
	 * @param array
	 * @param i
	 * @param j
	 */
	private static void swap(int[] array, int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
}
