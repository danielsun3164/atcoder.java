package abc.abc101_150.abc134;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void case1() {
		check("3\n" + "1\n" + "4\n" + "3", "4" + LF + "3" + LF + "4");
	}

	@Test
	void case2() {
		check("2\n" + "5\n" + "5", "5" + LF + "5");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ABC134/C");
	}
}
