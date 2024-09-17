package other.joi2007ho;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemETest extends TestBase {

	@Test
	void case1() {
		check("1\n" + "6 9 0 0", "5");
	}

	@Test
	void case2() {
		check("4\n" + "3 2 0 4\n" + "1 3 0 0\n" + "4 4 2 1\n" + "2 2 0 0", "40");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("joi2007ho/E");
	}
}
