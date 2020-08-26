import java.util.ArrayList;

public class CategoryDB {

	public static ArrayList<Category> catList = new ArrayList<Category>();

	public static void addCategory(Category cat) {
		catList.add(cat);
	}
	
	public static Object allCategory() {
		String output = "";
		for (int i = 0; i < catList.size(); i++) {
			output += catList.get(i) + "\n";
		}
		
		return output;
	}
	
	public static void delCategory(Category cat) {
		catList.remove(cat);
	}





}
