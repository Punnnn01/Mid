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

import th.ac.ku.kps.eng.soa.mid.model.Lecturer;

public class LecturerDAO {

	public ArrayList<Lecturer> getAllLecturer() {
		ArrayList<Lecturer> listOfLecture = new ArrayList();
		try {
			File file = new File("C:\\Users\\mhaee\\OneDrive\\Desktop\\Lec.dat");
			if (!file.exists()) {
				Lecturer l1 = new Lecturer();
				l1.setId(1);
				l1.setName("Joe doe");
				l1.setEmail("jd1@scu.ac.au");

				Lecturer l2 = new Lecturer();
				l2.setId(2);
				l2.setName("Joe doe");
				l2.setEmail("jd2@scu.ac.au");
				listOfLecture.add(l1);
				listOfLecture.add(l2);
				saveLecturerList(listOfLecture);
			} else {
				FileInputStream fis = new FileInputStream(file);
				ObjectInputStream ois = new ObjectInputStream(fis);
				listOfLecture = (ArrayList<Lecturer>) ois.readObject();
				saveLecturerList(listOfLecture);
				ois.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listOfLecture;
	}

	private void saveLecturerList(List<Lecturer> lecList) {
		try {
			File file = new File("C:\\Users\\mhaee\\OneDrive\\Desktop\\Lec.dat");
			System.out.println("Saving to file: " + file.getAbsolutePath());
			FileOutputStream fos = new FileOutputStream(file);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(lecList);
			oos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public Lecturer getLecturerByname(String name) {
		List<Lecturer> lecList = getAllLecturer();
		for (Lecturer lec : lecList) {
			if (lec.getName().equalsIgnoreCase(name)) {
				return lec;
			}
		}
		return null;
	}

	public Lecturer getLecturerById(int id) {
		List<Lecturer> lecList = getAllLecturer();
		for (Lecturer lec : lecList) {
			if (lec.getId() == id) {
				return lec;
			}
		}
		return null;
	}

	public int addLec(Lecturer lec) {
		List<Lecturer> lecList = getAllLecturer();
		boolean lecExists = false;
		for (Lecturer l : lecList) {
			if (l.getName().equalsIgnoreCase(lec.getName())) {
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

	public int updateLecterer(Lecturer lec) {
		List<Lecturer> lecList = getAllLecturer();
		boolean lecExists = false;
		int i = 0;
		for (Lecturer c : lecList) {
			if (c.getId() == lec.getId()) {
				lecExists = true;
				break;
			}
			i++;
		}

		if (lecExists) {
			lecList.set(i, lec);
			saveLecturerList(lecList);
			return 1;
		}
		return 0;
	}

	public int deleteLecterer(int id) {
		List<Lecturer> lecList = getAllLecturer();
		boolean lecExists = false;
		int i = 0;
		for (Lecturer l : lecList) {
			if (l.getId() == id) {
				lecExists = true;
				break;
			}
			i++;
		}

		if (lecExists) {
			lecList.remove(i);
			saveLecturerList(lecList);
			return 1;
		}

		return 0;
	}
}