package abc.abc201_250.abc231;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemDTest extends TestBase {

	@Test
	void case1() {
		check("4 2\n" + "1 3\n" + "2 3", "Yes");
	}

	@Test
	void case2() {
		check("4 3\n" + "1 4\n" + "2 4\n" + "3 4", "No");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("abc231/D");
	}
}
