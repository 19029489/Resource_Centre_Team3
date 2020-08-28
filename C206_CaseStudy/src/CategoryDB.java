import java.util.ArrayList;

public class CategoryDB {

	public static ArrayList<Category> catList = new ArrayList<Category>();

	public static void addCategory(Category cat) {
		catList.add(cat);
	}
	
	public static String viewAllCategory() {
		String output = "";
		for (int i = 0; i < catList.size(); i++) {
			output += catList.get(i).getName() + "\n";
		}
		return output;
	}
	
	public static void delCategory(Category cat) {
		catList.remove(cat);
	}

	public static void searchCategoryDB(Category cat) {
		catList.remove(cat);
	}



}
