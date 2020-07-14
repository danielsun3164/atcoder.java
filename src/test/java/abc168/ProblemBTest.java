package abc168;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void case1() {
		in.input("7\n" + "nikoandsolstice");
		ProblemB.main(null);
		assertResultIs("nikoand...");
	}

	@Test
	void case2() {
		in.input("40\n" + "ferelibenterhominesidquodvoluntcredunt");
		ProblemB.main(null);
		assertResultIs("ferelibenterhominesidquodvoluntcredunt");
	}
}
