package abc.abc201_250.abc223;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemF別回答Test extends TestBase {

	@Test
	void case1() {
		check("5 3\n" + "(())(\n" + "2 1 4\n" + "2 1 2\n" + "2 4 5", "Yes" + LF + "No" + LF + "No");
	}

	@Test
	void case2() {
		check("5 3\n" + "(())(\n" + "2 1 4\n" + "1 1 4\n" + "2 1 4", "Yes" + LF + "No");
	}

	@Test
	void case3() {
		check("8 8\n" + "(()(()))\n" + "2 2 7\n" + "2 2 8\n" + "1 2 5\n" + "2 3 4\n" + "1 3 4\n" + "1 3 5\n" + "1 1 4\n"
				+ "1 6 8", "Yes" + LF + "No" + LF + "No");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("abc223/F");
	}
}
