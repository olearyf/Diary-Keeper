import java.util.Scanner;
import java.io.File;
import java.io.PrintWriter;
import java.io.FileNotFoundException;

public class Diary {
	
	//2d array, one for name one for entry, later one for date/time
	
	
	private String[] titles, entries, dates;


	public Diary(){
		titles = new String[0];
		entries = new String[0];
	}
		
	public static void main (String args[]) {
		Diary diary = new Diary();
		String answer = "null";
		String response = "null";
		int response_two = 0;
		Scanner kb = new Scanner(System.in);
		while(answer!= "q"){
			System.out.flush();
			System.out.println("(a)dd title, (ad)d content, (p)rint, (s)ave, or (q)uit");
			answer = kb.nextLine();
			switch(answer){
				case "a":
					System.out.println("Enter the title: ");
					response = kb.nextLine();
					diary.addTitle(response);
					break;
				case "ad":
					System.out.println("Enter the content: ");
					response = kb.nextLine();
					diary.addContent(response);
					break;
				/*case "d":
					System.out.println("Enter the index: ");
					response_two = kb.nextInt();
					rolo.delete(response_two);
					break;*/
				case "p":
					System.out.println(diary);
					break;
				case "s":
					boolean result = diary.save(diary);
					if(result == true){
						System.out.println("Your data is saved!");
					}
					else{
					}
					break;
				case "q":
					System.out.println("Bye");
					System.exit(0);
			}
		}
		System.exit(0);
	}
	
	public void addTitle(String name){
		int length = titles.length;
		int size = length + 1;
		int count = 0;
		String[] temp = new String[size];
		if(titles.length!=0){
		for(int k = 0; k<titles.length; k++){
			temp[k] = titles[k];
			count++;
		}
		}
		if(count<temp.length){
			temp[count] = name;
		}
		titles = temp;
	}
	
	public void addContent(String content){
		int length = entries.length;
		int size = length + 1;
		int count = 0;
		String[] temp = new String[size];
		if(entries.length!=0){
		for(int k = 0; k<entries.length; k++){
			temp[k] = entries[k];
			count++;
		}
		}
		if(count<temp.length){
			temp[count] = content;
		}
		entries = temp;
	}
	/*
	public boolean delete(int index){
		//Deletes the element at the specified index (resizing names by -1)
		//check for a correct index
		//Returns true if successful, false otherwise (i.e. if index is out of bounds)
		if(index>=0){
			String[] temp = new String[names.length-1];
			names[index] = "0";
			entries[index] = "0";
			for(int i = 0; i<temp.length; i++){
				if(names[i] != "0"){
					temp[i] = names[i];
				}
			}
			names = new String[temp.length];
			names = temp;
			
			for(int i = 0; i<temp.length; i++){
				if(entries[i] != "0"){
					temp[i] = entries[i];
				}
			}
			entries = new String[temp.length];
			entries = temp;
			return true;
		}
		else{
				return false;
		}
		
	}*/
	
	public String toString(){
		String str = "Entries: ";
		for(int i = 0; i<titles.length;i++){
			str = str + '\n' + "Title: " + titles[i] + '\n' + "Entry: " + entries[i] + '\n';
		}
		return str;
	}
	
	public boolean save(Diary d){
		String pathname = "data.txt";
		File file = new File(pathname);
		PrintWriter output = null;
		try {
			output = new PrintWriter(file);
		}
		catch (FileNotFoundException ex){
			System.out.println("Cannot save data.");
			return false;
		}
		output.println(d);
		output.close();
		return true;
	}
	
	public String[] getTitles(){
		String[] titlesData = new String[0];
		return titlesData;
	}
	
	public String[] getDates(){
		String[] datesData = new String[0];
		return datesData;
	}
	
	public String[] getEntries(){
		String[] entryData = new String[0];
		return entryData;
	}
	
}

