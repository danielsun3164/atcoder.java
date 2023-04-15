package abc.abc201_250.abc218;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemHTest extends TestBase {

	@Test
	void case1() {
		check("6 2\n" + "3 1 4 1 5", "11");
	}

	@Test
	void case2() {
		check("7 6\n" + "2 7 1 8 2 8", "10");
	}

	@Test
	void case3() {
		check("11 7\n" + "12345 678 90123 45678901 234567 89012 3456 78901 23456 7890", "46207983");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("abc218/H");
	}
}
