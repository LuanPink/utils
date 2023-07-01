package model;

import javax.swing.JComboBox;
import javax.swing.JComponent;

public class ModelFilter extends JComponent{
	private String nameFilter;
	private int index;
	private String[] item;

	public ModelFilter() {
		
	}
	
	public ModelFilter(String nameFilter, int index, String... item) {
		this.nameFilter = nameFilter;
		this.index = index;
		this.item = item;
	}

	public String getNameFilter() {
		return nameFilter;
	}

	public void setNameFilter(String nameFilter) {
		this.nameFilter = nameFilter;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public String[] getItem() {
		return item;
	}

	public void setItem(String[] item) {
		this.item = item;
	}


	
	
}
