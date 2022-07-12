package abc.abc201_250.abc204;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemF別回答Test extends TestBase {

	@Test
	void case1() {
		check("2 2", "7");
	}

	@Test
	void case2() {
		check("3 3", "131");
	}

	@Test
	void case3() {
		check("5 100", "379944232");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("abc204/F");
	}
}
