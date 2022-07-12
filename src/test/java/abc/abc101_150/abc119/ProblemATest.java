package abc.abc101_150.abc119;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemATest extends TestBase {

	@Test
	void case1() {
		check("2019/04/30", "Heisei");
	}

	@Test
	void case2() {
		check("2019/11/01", "TBD");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ABC119/A");
	}
}
