package abc.abc101_150.abc146;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemFTest extends TestBase {

	@Test
	void case1() {
		check("9 3\n" + "0001000100", "1 3 2 3");
	}

	@Test
	void case2() {
		check("5 4\n" + "011110", "-1");
	}

	@Test
	void case3() {
		check("6 6\n" + "0101010", "6");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ABC146/F");
	}
}
