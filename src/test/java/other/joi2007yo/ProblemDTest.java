package other.joi2007yo;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemDTest extends TestBase {

	@Test
	void case1() {
		check("2\n" + "2\n" + "1\n" + "0", "2" + LF + "4" + LF + "3" + LF + "1");
	}

	@Test
	void case2() {
		check("3\n" + "4\n" + "2\n" + "4\n" + "0\n" + "0", "1" + LF + "5" + LF + "4" + LF + "3" + LF + "2" + LF + "6");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("joi2007yo/D");
	}
}
