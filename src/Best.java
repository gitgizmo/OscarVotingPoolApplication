import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;


public class Best {
	
	private String fileName = "/tmp/awards.txt";

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Best best = new Best();
		best.process();

	}
	
private void process() {

	try {
		//BufferedReader br = openFile("/tmp/awards.txt");
		ArrayList list1 = new ArrayList();
		list1.add(read(1, 8));
		list1.add(read(10, 17));
		list1.add(read(19, 26));
		list1.add(read(28, 35));
		list1.add(read(37, 44));
		list1.add(read(46, 53));
		list1.add(read(55, 62));
		list1.add(read(64, 71));
		list1.add(read(73, 80));
		list1.add(read(82, 89));
		
		list1.add(read(91, 98));
		list1.add(read(100, 105));
		list1.add(read(107, 114));
		list1.add(read(116, 123));
		list1.add(read(125, 132));
		list1.add(read(134, 141));
		
		list1.add(read(143, 150));
		list1.add(read(152, 159));
		list1.add(read(161, 168));
		list1.add(read(170, 177));
		list1.add(read(179, 186));
		list1.add(read(188, 195));
		
		print(list1);
		
		
		
		System.out.println(createAllHTML(list1));
		System.out.println(createAllSuccessHTML(list1));
		System.out.println(createAllJava(list1));
		System.out.println(createAllMessage(list1));
		System.out.println(createAllSQL(list1));
		System.out.println(createAllSQLInsert(list1));
		System.out.println(createAllRanking(list1));
		System.out.println(createAllStats(list1));
	} catch (IOException e) {
		e.printStackTrace();
	}
	

}
	
	
	
private BufferedReader openFile(String fileName) throws FileNotFoundException {
		  FileInputStream fstream = new FileInputStream(fileName);
		  DataInputStream in = new DataInputStream(fstream);
		  BufferedReader br = new BufferedReader(new InputStreamReader(in));
		  return br;
}

private ArrayList read(int start, int end) throws IOException {
	BufferedReader br = openFile(fileName);
	
    for (int i=0; i<start-1; i++) {
  	  br.readLine();
    }
	

	  ArrayList list = new ArrayList();
	 String value = "";
      for (int i=0; i<=end-start; i++) {
    	  value = br.readLine();
    	  if (null == value) value = "";
    	  value = value.trim();
    	  if ( ! value.equals("")) {
    	     list.add(value.trim());
    	  }
      }
      
      return list;
}


private void print(ArrayList list) {
	Iterator i = list.iterator();
	System.out.println("***");
	while (i.hasNext()) {
		Object o = i.next();
		System.out.println(o.toString());
	}
	System.out.println("***");
}

private String createHTML(ArrayList list) {
	
	String fullName = (String) list.get(0);
	
	String singular = buildTitleName(list);
	String listName = buildTitleName(list) + "List";
	
//	String a = "<tr>\n";
//	a += "<td>Choose " +  fullName + ":</td>\n";
//	a += "<td><form:radiobuttons path=\"" + singular + "\" items=\"${" + listName + "}\" elements=\"br\"/> </td>\n";
//	a += "<td><form:errors path=\"" + singular + "\" cssClass=\"error\" /></td>\n";
//	a += "</tr>\n";
	
	
	String a = "<fieldset>\n";
	a += "  <legend>" + fullName + "</legend>";
	a += "  <dl>\n";
	a += "     <dt></dt>\n";
	a += "       <dd>\n";
	a += "          <form:radiobuttons path=\"" + singular + "\" items=\"${" + listName + "}\" element=\"br\"/> \n";
	a += "       </dd>\n";
	a += "  </dl>\n";
	a += "</fieldset>\n";
	return a;
	
}

private String createSuccessHTML(ArrayList list) {
	String fullName = (String) list.get(0);
	String singular = buildTitleName(list);
	
	String a = "";
	a += "<br /> " + fullName + ": ${vote." + singular + "}";

	return a;
	
}


private String createMessage(ArrayList list) {
	String singular = buildTitleName(list);
	String a = "required."+singular+"=Please select " + list.get(0);
	return a;
}

private String createAllMessage(ArrayList list) {

	String a = "";
	for (int i = 0; i < list.size(); i++) {
		a += createMessage((ArrayList)list.get(i));
		a += "\n";
	}
	

	return a;
	
}


private String createStats(ArrayList list) {
	String singular = buildTitleName(list);
	String a = "categories.put(\"" + list.get(0) + "\",voteDAO.obtainCounts(\"" + singular + "\"));";
	return a;
}

private String createAllStats(ArrayList list) {

	String a = "";
	for (int i = 0; i < list.size(); i++) {
		a += createStats((ArrayList)list.get(i));
		a += "\n";
	}
	

	return a;
	
}




private String createRanking(ArrayList list) {
	String singular = buildTitleName(list);

	String firstChar = singular.substring(0, 1).toUpperCase();
	String name = firstChar + singular.substring(1);
	
	String a = "if (voter.get" + name + "().equals(winner.get" + name + "())) voter.setCounter(voter.getCounter()+1);";
	return a;
}

private String createAllRanking(ArrayList list) {

	String a = "";
	for (int i = 0; i < list.size(); i++) {
		a += createRanking((ArrayList)list.get(i));
		a += "\n";
	}
	

	return a;
	
}

private String createSQL(ArrayList list) {
	String singular = buildTitleName(list);
	String a = ""+singular + " varchar(255),";
	return a;
}

private String createAllSQL(ArrayList list) {

	String a = "CREATE TABLE votes (\n";;
	for (int i = 0; i < list.size(); i++) {
		a += createSQL((ArrayList)list.get(i));
		a += "\n";
	}
	a+=");";
	

	return a;
	
}



private String createSQLInsert(ArrayList list) {
	String singular = buildTitleName(list);
	String a = ""+singular + " varchar(255),";
	return a;
}

private String createAllSQLInsert(ArrayList list) {

	String a = "INSERT TABLE votes (\n";;
	for (int i = 0; i < list.size(); i++) {
		a += createSQL((ArrayList)list.get(i));
		a += "";
	}
	a+=")\n;";
	a+="VALUES ";
	for (int i = 0; i < list.size(); i++) {
		if (! (i==0)) a += ",";
		a += "?";
		
	}
	
	a += ")";
	return a;
	
}



private String createJava(ArrayList list) {
	String fullName = (String) list.get(0);
	String singular = buildTitleName(list);
	String listName = buildTitleName(list) + "List";
	String a = "List<String> " + listName + " = new ArrayList<String>();\n";
	
	for (int i = 1; i < list.size(); i++) {
		String value = (String) list.get(i);
		a += listName + ".add(\"" + value + "\");\n";
	}
	
	a += "referenceData.put(\"" + listName + "\", " + listName +");\n\n";
	return a;
}


private String createAllJava(ArrayList list) {

	String a = "";
	for (int i = 0; i < list.size(); i++) {
		a += createJava((ArrayList)list.get(i));
		a += "\n";
	}
	

	return a;
	
}


private String createAllSuccessHTML(ArrayList list) {

	String a = "";
	for (int i = 0; i < list.size(); i++) {
		a += createSuccessHTML((ArrayList)list.get(i));
		a += "\n";
	}
	

	return a;
	
}


private String createAllHTML(ArrayList list) {

	String a = "";
	for (int i = 0; i < list.size(); i++) {
		a += createHTML((ArrayList)list.get(i));
		a += "\n";
	}
	

	return a;
	
}

private String buildTitleName(ArrayList list) {
	String fullName = (String) list.get(0);
	fullName = fullName.replaceAll(" ", "");
	String firstChar = fullName.substring(0, 1).toLowerCase();
	return firstChar + fullName.substring(1);
}


}


