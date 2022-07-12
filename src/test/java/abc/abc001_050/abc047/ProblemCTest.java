package abc.abc001_050.abc047;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void case1() {
		check("BBBWW", "1");
	}

	@Test
	void case2() {
		check("WWWWWW", "0");
	}

	@Test
	void case3() {
		check("WBWBWBWBWB", "9");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ARC063/C");
	}
}
