package other.joi2007yo;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemATest extends TestBase {

	@Test
	void case1() {
		check("100 80 70 60\n" + "80 70 80 90", "320");
	}

	@Test
	void case2() {
		check("100 80 70 60\n" + "80 70 60 100", "310");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("joi2007yo/A");
	}
}
