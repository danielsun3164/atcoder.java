package other.zone2021;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemFTest extends TestBase {

	@Test
	void case1() {
		check(4, 1, new int[] { 3 });
	}

	@Test
	void case2() {
		check(8, 0, new int[] {});
	}

	@Test
	void case3() {
		check("8 7\n" + "1 2 3 4 5 6 7", "-1");
	}

	private void check(int n, int m, int[] a) {
		in.input(n + " " + m);
		in.input(Arrays.stream(a).mapToObj(String::valueOf).collect(Collectors.joining(" ")));
		Set<Integer> set = Arrays.stream(a).boxed().collect(Collectors.toSet());
		execute();
		String[] lines = out.toString().split("\\R");
		assertEquals(n - 1, lines.length);
		Arrays.stream(lines).forEach(line -> {
			String[] numbers = line.split("\\s+");
			assertEquals(2, numbers.length);
		});
		DisjointSetUnion dsu = new DisjointSetUnion(n);
		try (InputStream is = new ByteArrayInputStream(out.toByteArray()); Scanner scanner = new Scanner(is)) {
			IntStream.range(1, n).forEach(i -> {
				int u = scanner.nextInt(), v = scanner.nextInt();
				assertFalse(u + "^" + v + "=" + (u ^ v) + "はaに含まれている", set.contains(u ^ v));
				dsu.merge(u, v);
			});
			assertEquals(1, dsu.groupNum);
		} catch (IOException | NoSuchElementException e) {
			e.printStackTrace();
			fail();
		}
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ZONe2021/F", (inputIs, expectedIs) -> {
			try (Scanner inputScanner = new Scanner(inputIs); Scanner expectedScanner = new Scanner(expectedIs)) {
				int result = expectedScanner.nextInt();
				if (-1 == result) {
					check(inputIs, "-1");
					return;
				}
				int n = inputScanner.nextInt(), m = inputScanner.nextInt();
				check(n, m, IntStream.range(0, m).map(i -> inputScanner.nextInt()).toArray());
			}
		});
	}

	/**
	 * https://github.com/atcoder/ac-library/blob/master/atcoder/dsu.hpp のJava実装
	 */
	private static class DisjointSetUnion {
		/** 項目数 */
		final int n;
		/** 親のidかグループのサイズ */
		final int[] parentOrSize;
		/** グループの数 */
		int groupNum;

		/**
		 * コンストラクター
		 *
		 * @param n 項目数
		 */
		DisjointSetUnion(int n) {
			if (!(0 <= n)) {
				throw new IllegalArgumentException("n is " + n);
			}
			this.n = n;
			parentOrSize = new int[n];
			Arrays.fill(parentOrSize, -1);
			groupNum = n;
		}

		/**
		 * aとbを同じグループにマージする
		 *
		 * @param a
		 * @param b
		 * @return マージ後のグループリーダー
		 */
		int merge(int a, int b) {
			if (!((0 <= a) && (a < n))) {
				throw new IllegalArgumentException("a is " + a);
			}
			if (!((0 <= b) && (b < n))) {
				throw new IllegalArgumentException("b is " + b);
			}
			int x = leader(a), y = leader(b);
			if (x == y) {
				return x;
			}
			int max = (-parentOrSize[x] < -parentOrSize[y]) ? y : x;
			int min = (-parentOrSize[x] < -parentOrSize[y]) ? x : y;
			parentOrSize[max] += parentOrSize[min];
			parentOrSize[min] = max;
			groupNum--;
			return max;
		}

		/**
		 * aとbが同じグループに所属しているかを判定する
		 *
		 * @param a
		 * @param b
		 * @return aとbが同じグループに所属しているか
		 */
		@SuppressWarnings("unused")
		boolean same(int a, int b) {
			if (!((0 <= a) && (a < n))) {
				throw new IllegalArgumentException("a is " + a);
			}
			if (!((0 <= b) && (b < n))) {
				throw new IllegalArgumentException("b is " + b);
			}
			return leader(a) == leader(b);
		}

		/**
		 * aのグループリーダーを取得する
		 *
		 * @param a
		 * @return aのグループリーダー
		 */
		int leader(int a) {
			if (!((0 <= a) && (a < n))) {
				throw new IllegalArgumentException("a is " + a);
			}
			if (parentOrSize[a] < 0) {
				return a;
			}
			return parentOrSize[a] = leader(parentOrSize[a]);
		}

		/**
		 * aの所属グループのメンバー数を取得する
		 *
		 * @param a
		 * @return aの所属グループのメンバー数
		 */
		@SuppressWarnings("unused")
		int size(int a) {
			if (!((0 <= a) && (a < n))) {
				throw new IllegalArgumentException("a is " + a);
			}
			return -parentOrSize[leader(a)];
		}

		/**
		 * @return グループの一覧
		 */
		@SuppressWarnings("unused")
		int[][] groups() {
			// leaderBuf[i]はiのリーダー、groupSize[i]はiの所在groupのサイズ
			int[] leaderBuf = new int[n], groupSize = new int[n];
			IntStream.range(0, n).forEach(i -> {
				leaderBuf[i] = leader(i);
				groupSize[leaderBuf[i]]++;
			});
			Set<Integer> leaderSet = new HashSet<>();
			int count = 0;
			// groupNo[i]はiの所在グループの番号、groupLeader[i]はグループiのリーダー
			int[] groupNo = new int[n], groupLeader = new int[groupNum];
			for (int i = 0; i < n; i++) {
				if (!leaderSet.contains(leaderBuf[i])) {
					groupNo[leaderBuf[i]] = count;
					groupLeader[count] = leaderBuf[i];
					count++;
					leaderSet.add(leaderBuf[i]);
				}
				groupNo[i] = groupNo[leaderBuf[i]];
			}
			int[] indexes = new int[groupNum];
			int[][] result = new int[groupNum][];
			for (int i = 0; i < groupNum; i++) {
				result[i] = new int[groupSize[groupLeader[i]]];
			}
			Arrays.fill(indexes, 0);
			for (int i = 0; i < n; i++) {
				result[groupNo[i]][indexes[groupNo[i]]++] = i;
			}
			return result;
		}
	}
}
