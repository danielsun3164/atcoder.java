package abc.abc201_250.abc213;

import java.io.File;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemHTest extends TestBase {

	@Test
	void case1() {
		check("3 2 2\n" + "1 2\n" + "1 0\n" + "1 3\n" + "2 0", "5");
	}

	@Test
	void case2() {
		check("3 3 4\n" + "1 2\n" + "3 0 0 0\n" + "1 3\n" + "0 1 0 0\n" + "2 3\n" + "2 0 0 0", "130");
	}

	@Test
	void case3() {
		check("2 1 5\n" + "1 2\n" + "31415 92653 58979 32384 62643", "844557977");
	}

	@Test
	void case4() {
		check(new File("/daniel/tmp/20220328/in/03_t_max_perfect_00.txt"),
				new File("/daniel/tmp/20220328/out/03_t_max_perfect_00.txt"));
	}

	@Test
	void case5() {
		check(new File("/daniel/tmp/20220328/in/04_t_max_cycle_00.txt"),
				new File("/daniel/tmp/20220328/out/04_t_max_cycle_00.txt"));
	}

	@Test
	void case6() {
		check(new File("/daniel/tmp/20220328/in/05_t_max_anti_matrix_00.txt"),
				new File("/daniel/tmp/20220328/out/05_t_max_anti_matrix_00.txt"));
	}

	@Test
	void case7() {
		check(new File("/daniel/tmp/20220328/in/06_t_max_random_00.txt"),
				new File("/daniel/tmp/20220328/out/06_t_max_random_00.txt"));
	}

	@Test
	void case8() {
		check(new File("/daniel/tmp/20220328/in/06_t_max_random_01.txt"),
				new File("/daniel/tmp/20220328/out/06_t_max_random_01.txt"));
	}

	@Test
	void case9() {
		check(new File("/daniel/tmp/20220328/in/06_t_max_random_02.txt"),
				new File("/daniel/tmp/20220328/out/06_t_max_random_02.txt"));
	}
}
