package abc.abc201_250.abc228;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemGTest extends TestBase {

	@Test
	void case1() {
		check("2 2 1\n" + "31\n" + "41", "5");
	}

	@Test
	void case2() {
		check("2 3 4\n" + "777\n" + "777", "1");
	}

	@Test
	void case3() {
		check("10 10 300\n" + "3181534389\n" + "4347471911\n" + "4997373645\n" + "5984584273\n" + "1917179465\n"
				+ "3644463294\n" + "1234548423\n" + "6826453721\n" + "5892467783\n" + "1211598363", "685516949");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("abc228/G");
	}
}
