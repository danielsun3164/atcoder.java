package abc.abc201_250.abc218;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void case1() {
		check("1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26", "abcdefghijklmnopqrstuvwxyz");
	}

	@Test
	void case2() {
		check("2 1 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26", "bacdefghijklmnopqrstuvwxyz");
	}

	@Test
	void case3() {
		check("5 11 12 16 25 17 18 1 7 10 4 23 20 3 2 24 26 19 14 9 6 22 8 13 15 21", "eklpyqragjdwtcbxzsnifvhmou");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("abc218/B");
	}
}
