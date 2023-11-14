import java.util.ArrayList;

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
	
	public int getScore(int index) {
		if (index >= this.scores.size() || index < 0) {
			return -1;
		} else {
			return this.scores.get(index);
		}
	}
	
	public String getUsername(int index) {
		if (index >= this.usernames.size() || index < 0) {
			return "null";
		} else {
			return this.usernames.get(index);
		}
	}
	
	public int getUserIndex(String un) {
		
		for (int i = 0; i < this.usernames.size(); i++) {
			String thisUn = this.usernames.get(i);
			if (thisUn.equals(un)) {
				return i;
			}
		}
		
		return -1;
	}
	
	public int size() {
		return this.usernames.size();
	}

}
