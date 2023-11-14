import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class UserInfoTest {
	
	UserInfo rec = new UserInfo();

	@Test
	void test() {
		assertEquals(0,rec.size());
		rec.addInfo("Mark", 100);
		rec.addInfo("James", 200);		
		rec.addInfo("Sarah", 350);
		assertEquals(3,rec.size());
		assertEquals(1,rec.getUserIndex("James"));
		assertEquals(200,rec.getScore(1));
	}

}
