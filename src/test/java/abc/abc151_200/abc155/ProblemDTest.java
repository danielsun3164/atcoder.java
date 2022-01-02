package abc.abc151_200.abc155;

import java.io.File;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemDTest extends TestBase {

	@Test
	void case1() {
		check("4 3\n" + "3 3 -4 -2", "-6");
	}

	@Test
	void case2() {
		check("10 40\n" + "5 4 3 2 -1 0 0 0 0 0", "6");
	}

	@Test
	void case3() {
		check("30 413\n"
				+ "-170202098 -268409015 537203564 983211703 21608710 -443999067 -937727165 -97596546 -372334013 398994917 -972141167 798607104 -949068442 -959948616 37909651 0 886627544 -20098238 0 -948955241 0 -214720580 277222296 -18897162 834475626 0 -425610555 110117526 663621752 0",
				"448283280358331064");
	}

	@Test
	void case4() {
		check(new File("/daniel/tmp/20220102/in/sub1_02.txt"), new File("/daniel/tmp/20220102/out/sub1_02.txt"));
	}
}
