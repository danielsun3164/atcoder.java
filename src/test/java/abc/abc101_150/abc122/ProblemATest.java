package abc.abc101_150.abc122;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemATest extends TestBase {

	@Test
	void case1() {
		check("A", "T");
	}

	@Test
	void case2() {
		check("G", "C");
	}

	@Test
	void case3() {
		check("T", "A");
	}

	@Test
	void case4() {
		check("C", "G");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ABC122/A");
	}
}
