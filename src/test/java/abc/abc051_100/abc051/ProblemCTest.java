package abc.abc051_100.abc051;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemCTest extends TestBase {

	/** 上 */
	private static final char UP = 'U';
	/** 下 */
	private static final char DOWN = 'D';
	/** 左 */
	private static final char LEFT = 'L';

	@Test
	void case1() {
		check(0, 0, 1, 2, "UURDDLLUUURRDRDDDLLU".length());
	}

	@Test
	void case2() {
		check(-2, -2, 1, 1, "UURRURRDDDLLDLLULUUURRURRDDDLLDL".length());
	}

	void check(int sx, int sy, int tx, int ty, int resultLength) {
		in.input(sx + " " + sy + " " + tx + " " + ty);
		execute();
		String[] lines = out.toString().split("\\R");
		assertEquals(1, lines.length);
		assertEquals(resultLength, lines[0].length());
		int nx = sx, ny = sy;
		Map<Point, Integer> map = new HashMap<>();
		for (int c : lines[0].toCharArray()) {
			switch (c) {
			case UP -> ny++;
			case DOWN -> ny--;
			case LEFT -> nx--;
			default -> nx++;
			}
			Point point = new Point(nx, ny);
			map.put(point, map.getOrDefault(point, 0) + 1);
		}
		assertEquals(sx, nx);
		assertEquals(sy, ny);
		assertEquals(2, map.get(new Point(sx, sy)));
		assertEquals(2, map.get(new Point(tx, ty)));
		assertEquals(resultLength - 4,
				map.values().stream().mapToInt(Integer::intValue).filter(value -> 1 == value).count());
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ABC051/C", (inputIs, expectedIs) -> {
			try (Scanner inputScanner = new Scanner(inputIs); Scanner expectedScanner = new Scanner(expectedIs)) {
				check(inputScanner.nextInt(), inputScanner.nextInt(), inputScanner.nextInt(), inputScanner.nextInt(),
						expectedScanner.next().length());
			}
		});
	}

	/**
	 * x,y を格納するクラス
	 */
	private static class Point {
		int x, y;

		Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

		@Override
		public int hashCode() {
			return Objects.hash(x, y);
		}

		@Override
		public boolean equals(Object obj) {
			if (obj instanceof Point) {
				Point p = (Point) obj;
				return (x == p.x) && (y == p.y);
			}
			return false;
		}
	}
}
