package abc.abc101_150.abc131;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void case1() {
		check("4 9 2 3", "2");
	}

	@Test
	void case2() {
		check("10 40 6 8", "23");
	}

	@Test
	void case3() {
		check("314159265358979323 846264338327950288 419716939 937510582", "532105071133627368");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ABC131/C");
	}
}
