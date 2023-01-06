package other.typical90;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class Problem047Test extends TestBase {

	@Test
	void case1() {
		check("5\n" + "RGBGB\n" + "GRGRB", "6");
	}

	@Test
	void case2() {
		check("3\n" + "RRR\n" + "BBB", "5");
	}

	@Test
	void case3() {
		check("10\n" + "BGGGRBBGRG\n" + "RGBBRGRGGG", "4");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("typical90/047");
	}
}
