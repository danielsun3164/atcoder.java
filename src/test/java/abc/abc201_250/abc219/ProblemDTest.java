package abc.abc201_250.abc219;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemDTest extends TestBase {

	@Test
	void case1() {
		check("3\n" + "5 6\n" + "2 1\n" + "3 4\n" + "2 3", "2");
	}

	@Test
	void case2() {
		check("3\n" + "8 8\n" + "3 4\n" + "2 3\n" + "2 1", "-1");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("abc219/D");
	}
}
