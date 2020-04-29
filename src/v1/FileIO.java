package v1;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.Writer;
import java.io.IOException;
import java.io.InvalidClassException;
import java.io.NotSerializableException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
public class FileIO {
	private static final boolean APPEND_MODE = true;
	private static final boolean OVERWRITE_MODE = false;
	private static final Logger LOGGER = Logger.getLogger(GUI.class.getName());
	
	public static void fileIO() {
		
	}

	
	public static void writeUserInfo(User user) {
		new File("Admin").mkdir();
		new File("Admin\\Users").mkdir();
		try
		{
			new File("Admin\\Usernames.txt").createNewFile();
			new File("Admin\\User Log.txt").createNewFile();
			//new File("Admin\\Exercises.txt").createNewFile();
		if(!usernames().contains(user.getUsername())) {
		   Writer usernameWriter = new FileWriter("Admin\\Usernames.txt", APPEND_MODE);
		   usernameWriter.write(user.getUsername() + "\n");
		   usernameWriter.close();
		}
		   FileOutputStream fileStream = new FileOutputStream("Admin\\Users\\" + user.getUsername() + ".ser");
		   ObjectOutputStream objectStream = new ObjectOutputStream(fileStream);
		   objectStream.writeObject(user);
		   objectStream.close();
		}
		catch (InvalidClassException e)
		{
		    System.out.println("Invalid class exception");
		}
		catch (NotSerializableException e)
		{
		    System.out.println("NotSerializable");
		}
		catch (IOException e)
		{
		    System.out.println("IOException");
		}
		catch (Exception e)
		{
		    System.out.println("Error when saving to file.");
		}
		
	}

	
	public static Object deserialize(String filePath) {
		try
		{
		    FileInputStream fileStream = new FileInputStream(filePath);
		    ObjectInputStream objectStream = new ObjectInputStream(fileStream);
		    Object obj = objectStream.readObject(); 
		    objectStream.close();
		    return obj;  
		    
		}
		catch (Exception e)
		{
		    System.out.println("Error when loading from file.");
		    return null;
		}
	}
	
	
	public static ArrayList<String> usernames(){
		ArrayList<String> usernames = new ArrayList<>();
		try {
			BufferedReader br = new BufferedReader(new FileReader("Admin\\Usernames.txt"));
			String line = br.readLine();
			while(line != null) {
				usernames.add(line);
				line = br.readLine();
			}
			br.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return  usernames;
	}
	
	public static void logLogin(String username) {
		try {
			FileHandler filehandler = new FileHandler("Admin\\User Log.txt", APPEND_MODE);
			LOGGER.addHandler(filehandler);
		} catch (IOException e) {
			e.printStackTrace();
		}
		LOGGER.log(Level.INFO, username + " successfully logged in");
	}
	
	
	/**
	 * User for reserializing exerciselist/foodlist run
	 * backendtest to update the lists
	 * delete when serialized lists are complete
	 */
	public static void serializeLists(ExerciseList e) {
		try {
			FileOutputStream file = new FileOutputStream("Admin\\exerciselist.ser");
			ObjectOutputStream out = new ObjectOutputStream(file);
			out.writeObject(e);
			out.close();
		} catch (IOException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		}
	}
	public static void serializeLists(FoodList f) {
		try {
			FileOutputStream file = new FileOutputStream("Admin\\foodlist.ser");
			ObjectOutputStream out = new ObjectOutputStream(file);
			out.writeObject(f);
			out.close();
		} catch (IOException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		}
	}

}
