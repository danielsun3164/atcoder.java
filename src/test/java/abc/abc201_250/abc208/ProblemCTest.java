package abc.abc201_250.abc208;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void case1() {
		check("2 7\n" + "1 8", "4" + LF + "3");
	}

	@Test
	void case2() {
		check("1 3\n" + "33", "3");
	}

	@Test
	void case3() {
		check("7 1000000000000\n" + "99 8 2 4 43 5 3", "142857142857" + LF + "142857142857" + LF + "142857142858" + LF
				+ "142857142857" + LF + "142857142857" + LF + "142857142857" + LF + "142857142857");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("abc208/C");
	}
}
