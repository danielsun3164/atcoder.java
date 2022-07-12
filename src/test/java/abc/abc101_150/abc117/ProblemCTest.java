package abc.abc101_150.abc117;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void case1() {
		check("2 5\n" + "10 12 1 2 14", "5");
	}

	@Test
	void case2() {
		check("3 7\n" + "-10 -3 0 9 -100 2 17", "19");
	}

	@Test
	void case3() {
		check("100 1\n" + "-100000", "0");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ABC117/C");
	}
}
