package other.math_and_algorithm;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class Problem102Test extends TestBase {

	@Test
	void case1() {
		check("3\n" + "BWR", "W");
	}

	@Test
	void case2() {
		check("4\n" + "RRBB", "W");
	}

	@Test
	void case3() {
		check("6\n" + "BWWRBW", "B");
	}

	@Test
	void case4() {
		check("8\n" + "WWBRBBWB", "R");
	}

	@Test
	void case5() {
		check("21\n" + "BWBRRBBRWBRBBBRRBWWWR", "B");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ARC117/C");
	}
}
