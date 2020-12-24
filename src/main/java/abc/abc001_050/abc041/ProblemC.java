package abc.abc001_050.abc041;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemC {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			Student[] students = new Student[n];
			IntStream.range(0, n).forEach(i -> students[i] = new Student(i + 1, scanner.nextInt()));
			Arrays.sort(students);
			Arrays.stream(students).mapToInt(student -> student.no).forEach(System.out::println);
		}
	}

	/**
	 * 生徒を表すクラス
	 */
	private static class Student implements Comparable<Student> {
		/** 出席番号 */
		int no;
		/** 身長 */
		int height;

		Student(int no, int height) {
			super();
			this.no = no;
			this.height = height;
		}

		@Override
		public int compareTo(Student o) {
			return o.height - this.height;
		}
	}
}
