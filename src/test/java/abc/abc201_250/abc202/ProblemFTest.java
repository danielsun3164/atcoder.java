package abc.abc201_250.abc202;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemFTest extends TestBase {

	@Test
	void case1() {
		check("4\n" + "0 0\n" + "1 2\n" + "0 1\n" + "1 0", "2");
	}

	@Test
	void case2() {
		check("23\n" + "-5255 7890\n" + "5823 7526\n" + "5485 -113\n" + "7302 5708\n" + "9149 2722\n" + "4904 -3918\n"
				+ "8566 -3267\n" + "-3759 2474\n" + "-7286 -1043\n" + "-1230 1780\n" + "3377 -7044\n" + "-2596 -6003\n"
				+ "5813 -9452\n" + "-9889 -7423\n" + "2377 1811\n" + "5351 4551\n" + "-1354 -9611\n" + "4244 1958\n"
				+ "8864 -9889\n" + "507 -8923\n" + "6948 -5016\n" + "-6139 2769\n" + "4103 9241", "4060436");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("abc202/F");
	}
}
