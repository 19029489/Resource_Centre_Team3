import java.util.ArrayList;

public class CategoryDB {

	public static ArrayList<Category> catList = new ArrayList<Category>();

	public static void addCategory(Category cat) {
		catList.add(cat);
	}
	
	public static void viewAllCategory() {
		if (catList.size() > 0) {
			for (int i = 0; i < catList.size(); i++) {
				System.out.println(catList.get(i).getName() + "\n");
			}
		}
		else {
			System.out.println("No categories in the list.");
		}
		
	}
	
	public static void delCategory(String cat) {
		catList.remove(cat);
	}

	public static boolean searchCategoryDB(String cat) {
		boolean isFound = false;
		for (int i = 0; i < catList.size(); i++) {
			if (catList.get(i).getName().equals(cat)) {
				isFound = true;
			}	
		}		
		return isFound;
	}

	public static void updateCategory(String cat, String newCat) {
		for (int i = 0; i < catList.size(); i++) {
			if (catList.get(i).getName().equals(cat)) {
				catList.get(i).setName(newCat);
				break;
			}	
		}
		
	}

}
