package abc.abc101_150.abc106;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void case1() {
		check("1214\n" + "4", "2");
	}

	@Test
	void case2() {
		check("3\n" + "157", "3");
	}

	@Test
	void case3() {
		check("299792458\n" + "9460730472580800", "2");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ABC106/C");
	}
}
