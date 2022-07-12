package abc.abc101_150.abc131;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemATest extends TestBase {

	@Test
	void case1() {
		check("3776", "Bad");
	}

	@Test
	void case2() {
		check("8080", "Good");
	}

	@Test
	void case3() {
		check("1333", "Bad");
	}

	@Test
	void case4() {
		check("0024", "Bad");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ABC131/A");
	}
}
