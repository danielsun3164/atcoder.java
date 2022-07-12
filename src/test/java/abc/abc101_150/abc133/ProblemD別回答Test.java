package abc.abc101_150.abc133;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemD別回答Test extends TestBase {

	@Test
	void case1() {
		check("3\n" + "2 2 4", "4 0 4");
	}

	@Test
	void case2() {
		check("5\n" + "3 8 7 5 5", "2 4 12 2 8");
	}

	@Test
	void case3() {
		check("3\n" + "1000000000 1000000000 0", "0 2000000000 0");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ABC133/D");
	}
}
