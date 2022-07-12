package abc.abc151_200.abc163;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemDTest extends TestBase {

	@Test
	void case1() {
		check("3 2", "10");
	}

	@Test
	void case2() {
		check("200000 200001", "1");
	}

	@Test
	void case3() {
		check("141421 35623", "220280457");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ABC163/D");
	}
}
