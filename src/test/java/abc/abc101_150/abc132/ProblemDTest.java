package abc.abc101_150.abc132;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemDTest extends TestBase {

	@Test
	void case1() {
		check("5 3", "3" + LF + "6" + LF + "1");
	}

	@Test
	void case2() {
		check("2000 3", "1998" + LF + "3990006" + LF + "327341989");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ABC132/D");
	}
}
