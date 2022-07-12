package abc.abc151_200.abc161;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemDTest extends TestBase {

	@Test
	void case1() {
		check("15", "23");
	}

	@Test
	void case2() {
		check("1", "1");
	}

	@Test
	void case3() {
		check("13", "21");
	}

	@Test
	void case4() {
		check("100000", "3234566667");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ABC161/D");
	}
}
