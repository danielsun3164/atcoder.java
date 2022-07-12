package abc.abc051_100.abc071;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void case1() {
		check("atcoderregularcontest", "b");
	}

	@Test
	void case2() {
		check("abcdefghijklmnopqrstuvwxyz", "None");
	}

	@Test
	void case3() {
		check("fajsonlslfepbjtsaayxbymeskptcumtwrmkkinjxnnucagfrg", "d");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ARC081/B");
	}
}
