package abc.abc201_250.abc216;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemDTest extends TestBase {

	@Test
	void case1() {
		check("2 2\n" + "2\n" + "1 2\n" + "2\n" + "1 2", "Yes");
	}

	@Test
	void case2() {
		check("2 2\n" + "2\n" + "1 2\n" + "2\n" + "2 1", "No");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("abc216/D");
	}
}
