import java.util.ArrayList;




/** includes and updates the users' scores */
public class UserInfo {

	private ArrayList<String> usernames;
	private ArrayList<Integer> scores;

	public UserInfo() {
		usernames = new ArrayList<String>();
		scores = new ArrayList<Integer>();
	}

	
	public void addInfo(String un, int s) {
		this.usernames.add(un);
		this.scores.add(s);
	}

	/** retrieves the score. */
	public int getScore(int index) {
		if (index >= this.scores.size() || index < 0) {
			return -1;
		} else {
			return this.scores.get(index);
		}
	}
	/** retrieves the username. */
	public String getUsername(int index) {
		if (index >= this.usernames.size() || index < 0) {
			return "null";
		} else {
			return this.usernames.get(index);
		}
	}

	/** retrieves the correct index for user. */
	public int getUserIndex(String un) {

		for (int i = 0; i < this.usernames.size(); i++) {
			String thisUn = this.usernames.get(i);
			if (thisUn.equals(un)) {
				return i;
			}
		}

		return -1;
	}

	/** retrieves the size of the leaderboard. */ 
	public int size() {
		return this.usernames.size();
	}

}
