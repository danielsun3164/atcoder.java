package other.exawizards2019;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemETest extends TestBase {

	@Test
	void case1() {
		check("2 1", "500000004" + LF + "750000006" + LF + "750000006");
	}

	@Test
	void case2() {
		check("3 2", "500000004" + LF + "500000004" + LF + "625000005" + LF + "187500002" + LF + "187500002");
	}

	@Test
	void case3() {
		check("6 9",
				"500000004" + LF + "500000004" + LF + "500000004" + LF + "500000004" + LF + "500000004" + LF
						+ "500000004" + LF + "929687507" + LF + "218750002" + LF + "224609377" + LF + "303710940" + LF
						+ "633300786" + LF + "694091802" + LF + "172485353" + LF + "411682132" + LF + "411682132");
	}
}
