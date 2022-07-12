package abc.abc151_200.abc181;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void case1() {
		check("4\n" + "0 1\n" + "0 2\n" + "0 3\n" + "1 1", "Yes");
	}

	@Test
	void case2() {
		check("14\n" + "5 5\n" + "0 1\n" + "2 5\n" + "8 0\n" + "2 1\n" + "0 0\n" + "3 6\n" + "8 6\n" + "5 9\n" + "7 9\n"
				+ "3 4\n" + "9 2\n" + "9 8\n" + "7 2", "No");
	}

	@Test
	void case3() {
		check("9\n" + "8 2\n" + "2 3\n" + "1 3\n" + "3 7\n" + "1 0\n" + "8 8\n" + "5 6\n" + "9 7\n" + "0 1", "Yes");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ABC181/C");
	}
}
