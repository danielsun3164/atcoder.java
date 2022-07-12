package abc.abc101_150.abc138;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemETest extends TestBase {

	@Test
	void case1() {
		check("contest\n" + "son", "10");
	}

	@Test
	void case2() {
		check("contest\n" + "programming", "-1");
	}

	@Test
	void case3() {
		check("contest\n" + "sentence", "33");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ABC138/E");
	}
}
