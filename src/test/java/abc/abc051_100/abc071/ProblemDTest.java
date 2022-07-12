package abc.abc051_100.abc071;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemDTest extends TestBase {

	@Test
	void case1() {
		check("3\n" + "aab\n" + "ccb", "6");
	}

	@Test
	void case2() {
		check("1\n" + "Z\n" + "Z", "3");
	}

	@Test
	void case3() {
		check("52\n" + "RvvttdWIyyPPQFFZZssffEEkkaSSDKqcibbeYrhAljCCGGJppHHn\n"
				+ "RLLwwdWIxxNNQUUXXVVMMooBBaggDKqcimmeYrhAljOOTTJuuzzn", "958681902");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ARC081/D");
	}
}
