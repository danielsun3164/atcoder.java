package abc.abc168;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void case1() {
		check("7\n" + "nikoandsolstice", "nikoand...");
	}

	@Test
	void case2() {
		check("40\n" + "ferelibenterhominesidquodvoluntcredunt", "ferelibenterhominesidquodvoluntcredunt");
	}
}
