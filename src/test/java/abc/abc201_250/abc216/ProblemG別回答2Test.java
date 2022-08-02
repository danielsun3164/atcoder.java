package abc.abc201_250.abc216;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemG別回答2Test extends TestBase {

	@Test
	void case1() {
		check("6 3\n" + "1 4 3\n" + "2 2 1\n" + "4 6 2", "0 1 1 1 0 1");
	}

	@Test
	void case2() {
		check("8 2\n" + "2 6 1\n" + "3 5 3", "0 0 1 1 1 0 0 0");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("abc216/G");
	}
}
