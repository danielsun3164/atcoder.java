package abc.abc151_200.abc170;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemATest extends TestBase {

	@Test
	void case1() {
		check("0 2 3 4 5", "1");
	}

	@Test
	void case2() {
		check("1 2 0 4 5", "3");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ABC170/A");
	}
}
