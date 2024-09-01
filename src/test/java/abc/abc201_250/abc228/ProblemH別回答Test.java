package abc.abc201_250.abc228;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemH別回答Test extends TestBase {

	@Test
	void case1() {
		check("3 5\n" + "3 2\n" + "2 4\n" + "4 3", "12");
	}

	@Test
	void case2() {
		check("1 1\n" + "1 1", "1");
	}

	@Test
	void case3() {
		check("7 7\n" + "3 2\n" + "1 7\n" + "4 1\n" + "1 8\n" + "5 2\n" + "9 8\n" + "2 1", "29");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("abc228/H");
	}
}
