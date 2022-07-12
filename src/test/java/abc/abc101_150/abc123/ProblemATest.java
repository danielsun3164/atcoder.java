package abc.abc101_150.abc123;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemATest extends TestBase {

	@Test
	void case1() {
		check("1\n" + "2\n" + "4\n" + "8\n" + "9\n" + "15", "Yay!");
	}

	@Test
	void case2() {
		check("15\n" + "18\n" + "26\n" + "35\n" + "36\n" + "18", ":(");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ABC123/A");
	}
}
