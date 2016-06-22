import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeSet;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.util.JSON;


public class Classify_item {
	//myself
	private static TreeSet<String> containers = new TreeSet<String>();
	private static double percent1 = 0.3;
	private static double percent2 = 0.6;
	private static MongoDBUtils qa;
	private static HashMap<String,String> dicts;
	private static DB db;
	
	public static void main(String[] args) {
		qa = new MongoDBUtils("weibo_data");
		dicts = dict();
		classify();
		splitIntoFile();
		
		//Export background data
		/*MongoDBUtils qa = new MongoDBUtils("weibo_data");
		DBCollection col = db.getCollection("AnnotatedData");
		BasicDBObject cond = new BasicDBObject();
		cond.put("state", "labeled");
		TreeSet<String> duplicate = new TreeSet<String>();
		HashMap<String,String> total = new HashMap<String,String>();
		DBCursor cur = col.find(cond);
		while(cur.hasNext()){
			DBObject obj = cur.next();
			duplicate.add(obj.get("wb_id").toString());
		}
		System.out.println(cur.count());
		
		
		DBCursor curback = qa.getAllValues("weibo_data", new String[]{"idstr","text"});
		try {
			BufferedWriter filewriter = new BufferedWriter(new FileWriter(new File("F:\\Database.txt")));
			int count = 0; 
			while(curback.hasNext()){
				DBObject obj = curback.next();
				if(!duplicate.contains(obj.get("idstr").toString())){			
					total.put(obj.get("idstr").toString(),obj.get("text").toString());
				}
			}
			Set <Entry<String,String>> aa = total.entrySet();
			Iterator<Map.Entry<String, String>> it = aa.iterator();
			while(it.hasNext()){
				Map.Entry<String, String> aaa = it.next();
				filewriter.write(aaa.getValue());
				filewriter.newLine();
				count++;
			}
			System.out.println(count);
			filewriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}*/
	}
	
	//myself 
	//Return the map of weibo_data as return
	public static HashMap<String,String> dict(){
		HashMap<String,String> dict = new HashMap<String,String>();
		DBCursor cur = qa.getAllValues("weibo_data", new String[]{"idstr","user"});
		long startTime = System.currentTimeMillis();
		int i = 0;
		while(cur.hasNext()){
			DBObject obj = cur.next();
			dict.put(obj.get("idstr").toString(), ((DBObject) JSON.parse(obj.get("user").toString())).get("name").toString());
			System.out.println(i++);
		}
		long endTime = System.currentTimeMillis();
		System.out.println(endTime-startTime);
		return dict;
	}
	
	//search each element in annotated, look into the map, then put it into one set.
	//consists of function classify and putIntoSet
	public static void classify() {
		DBCollection col = db.getCollection("AnnotatedData");
		BasicDBObject cond = new BasicDBObject();
		cond.put("state", "labeled");
		DBCursor cur = col.find(cond);
		System.out.println("%30");
		while(cur.hasNext()){
			DBObject obj = cur.next();
			putIntoSet(obj.get("wb_id").toString(), obj.get("sentence").toString());
		}
		System.out.println("%60");
	}
	
	public static void putIntoSet(String wb_id,String sentence) {
		String name = dicts.get(wb_id);
		String item = name + " " + sentence;
		containers.add(item); 
	}
	
	//split each element in file, then collect those with same weibo account into one array
	//After shuffling, then output the element into different files. 
	//consists of splitIntoFile and intoFile
	public static void splitIntoFile() {
		Boolean flag = true;
		String nameflag = null;
		ArrayList<String> temp = new ArrayList<String>();
		for(String item: containers){
			String[] word = item.split(" ");
			String sentence = word[1];
			if(flag){
				nameflag = word[0];
				flag = false;
			}
			if(word[0].equals(nameflag)){
				temp.add(sentence);
			}
			else{
				flag = true;
				shuffleArray(temp);
				intoFile(temp);
				temp.clear();
			}
		}
	}
	
	public static void intoFile(ArrayList<String> temp){
		try {
			int idx1 = (int) (percent1*temp.size());
			int idx2 = (int) (percent2*temp.size());
			BufferedWriter filetrain =new BufferedWriter(new FileWriter(new File("F:\\weibo_train.txt"),true));
			BufferedWriter filedev =new BufferedWriter(new FileWriter(new File("F:\\weibo_dev.txt"),true));
			BufferedWriter filetest =new BufferedWriter(new FileWriter(new File("F:\\weibo_test.txt"),true));
			for(int i=0;i<idx1;i++){
				filetrain.write(temp.get(i));
				filetrain.newLine();
			}
			for(int i=idx1;i<idx2;i++){
				filedev.write(temp.get(i));
				filedev.newLine();
			}
			for(int i=idx2;i<temp.size();i++){
				filetest.write(temp.get(i));
				filetest.newLine();
			}
			filetrain.close();
			filedev.close();
			filetest.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void shuffleArray(ArrayList<String> temp){
		for(int i=0;i<50;i++){
			int idx1 = (int) (Math.random() * temp.size());
			int idx2 = (int) (Math.random() * temp.size());
			String ele1 = temp.get(idx1);
			String ele2 = temp.get(idx2);
			temp.set(idx1, ele2);
			temp.set(idx2, ele1);
		}
	}
}

