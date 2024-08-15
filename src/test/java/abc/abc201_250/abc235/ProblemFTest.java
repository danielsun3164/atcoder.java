package abc.abc201_250.abc235;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemFTest extends TestBase {

	@Test
	void case1() {
		check("104\n" + "2\n" + "0 1", "520");
	}

	@Test
	void case2() {
		check("999\n" + "4\n" + "1 2 3 4", "0");
	}

	@Test
	void case3() {
		check("1234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890\n"
				+ "5\n" + "0 2 4 6 8", "397365274");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("abc235/F");
	}
}
