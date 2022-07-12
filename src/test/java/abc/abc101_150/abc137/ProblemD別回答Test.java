package abc.abc101_150.abc137;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemD別回答Test extends TestBase {

	@Test
	void case1() {
		check("3 4\n" + "4 3\n" + "4 1\n" + "2 2", "5");
	}

	@Test
	void case2() {
		check("5 3\n" + "1 2\n" + "1 3\n" + "1 4\n" + "2 1\n" + "2 3", "10");
	}

	@Test
	void case3() {
		check("1 1\n" + "2 1", "0");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ABC137/D");
	}
}
