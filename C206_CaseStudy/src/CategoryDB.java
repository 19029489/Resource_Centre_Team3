// BY CHONG YEE HUNG 19034609

import java.util.ArrayList;

public class CategoryDB {

	public static ArrayList<Category> catList = new ArrayList<Category>();

	public static void addCategory(Category cat) {
		catList.add(cat);
		System.out.println("Category successfully added");
	}
	
	public static String viewAllCategory() {
		String output = "";
		if (catList.size() > 0) {
			for (int i = 0; i < catList.size(); i++) {
				output += catList.get(i).getName()+"\n";
				System.out.println(catList.get(i).getName());
			}
		}
		else {
			System.out.println("No categories in the list");
			output = "No categories in the list";
		}
		return output;
	}
	
	public static void delCategory(String cat) {
		for (int i = 0; i < catList.size(); i++) {
			if(catList.get(i).getName().equals(cat)) {
				catList.remove(i);
				System.out.println("Category successfully deleted");
			}
			else {
				System.out.println("Category cannot found. Please try again.");
			}
		}
		
	}

	public static boolean searchCategoryDB(String cat) {
		boolean isFound = false;
		for (int i = 0; i < catList.size(); i++) {
			if (catList.get(i).getName().equals(cat)) {
				isFound = true;
			}
		}
		if (isFound == true) {
			System.out.println("Category found");
		}
		else {
			System.out.println("Category not found. Please try again.");
		}
		return isFound;
	}

	public static void updateCategory(String cat, String newCat) {
		for (int i = 0; i < catList.size(); i++) {
			if (catList.get(i).getName().equals(cat)) {
				catList.get(i).setName(newCat);
				System.out.println("Category successfully updated");
				break;
			}
			else {
				System.out.println("Category will not be updated");
			}
		}
		
	}

}
