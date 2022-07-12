package abc.abc101_150.abc124;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemDTest extends TestBase {

	@Test
	void case1() {
		check("5 1\n" + "00010", "4");
	}

	@Test
	void case2() {
		check("14 2\n" + "11101010110011", "8");
	}

	@Test
	void case3() {
		check("1 1\n" + "1", "1");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ABC124/D");
	}
}
