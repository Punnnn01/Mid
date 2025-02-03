package th.ac.ku.kps.eng.soa.mid.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import th.ac.ku.kps.eng.soa.mid.model.*;

public class LecturerDAO {
	
	public LecturerDAO() {
		
	}
	
	public ArrayList<Lecturer> getAllLecturer() {
		
		ArrayList<Lecturer> listOfLecturer = new ArrayList<Lecturer>();
		
		try {
			File file = new File("Lecturer.dat");
			if (!file.exists()) {
				Lecturer l1 = new Lecturer("1", "Joe doe", "jd1@scu.ac.au");
				Lecturer l2 = new Lecturer("2", "Jane doe", "jd2@scu.ac.au");
				listOfLecturer.add(l1);
				listOfLecturer.add(l2);
				saveLecturerList(listOfLecturer);
			} 
			else {
				FileInputStream fis = new FileInputStream(file);
				ObjectInputStream ois = new ObjectInputStream(fis);
				listOfLecturer = (ArrayList<Lecturer>)
				ois.readObject();
				ois.close();
			}
			} catch (Exception e) {
			e.printStackTrace();
			}
			return listOfLecturer;
			}
	
		private void saveLecturerList(List<Lecturer> lecList) {
			try {
				File file = new File("Lecturer.dat");
				FileOutputStream fos;
				fos = new FileOutputStream(file);
				ObjectOutputStream oos = new ObjectOutputStream(fos);
				oos.writeObject(lecList);
				oos.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		public Lecturer getLecturerById(String id) {
			List<Lecturer> lecList = getAllLecturer();
			for (Lecturer lec : lecList) {
				if (lec.getId().equalsIgnoreCase(id)) {
				return lec;
				}
			}

			return null;
		}
		
		public int addLecturer(Lecturer lec) {
			List<Lecturer> lecList = getAllLecturer();
			boolean lecExists = false;
			for (Lecturer l : lecList) {
				if (l.name.equalsIgnoreCase(lec.name)) {
					lecExists = true;
					break;
				}
			}
			if (!lecExists) {
				lecList.add(lec);
				saveLecturerList(lecList);
				return 1;
			}
				return 0;
		}
		
		public int updateLecturer(String id) {
	        List<Lecturer> lecList = getAllLecturer();
	        for (int i = 0; i < lecList.size(); i++) {
	        	Lecturer lec = lecList.get(i);
	            if (lec.getId().equalsIgnoreCase(id)) {
	            	lecList.remove(i);
	                saveLecturerList(lecList);
	                return 1;
	            }
	        }
	        return 0;
	    }
		
		
		public int deleteLecturer(String id) {
	        List<Lecturer> lecList = getAllLecturer();
	        for (int i = 0; i < lecList.size(); i++) {
	        	Lecturer lec = lecList.get(i);
	            if (lec.getId().equalsIgnoreCase(id)) {
	            	lecList.remove(i);
	                saveLecturerList(lecList);
	                return 1;
	            }
	        }
	        return 0;
	    }



}
