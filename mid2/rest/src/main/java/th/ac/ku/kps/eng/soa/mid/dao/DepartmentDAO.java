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

public class DepartmentDAO {
	
	public DepartmentDAO() {
		
	}
	
	public ArrayList<Department> getAllDepartment() {
		
		ArrayList<Department> listOfDepartment = new ArrayList<Department>();
		try {
			File file = new File("Department.dat");
			if (!file.exists()) {
				Department d1 = new Department("1","Department of Chem","chem@scu.ac.au");
				listOfDepartment.add(d1);
				saveDepartmentList(listOfDepartment);
			} 
			else {
				FileInputStream fis = new FileInputStream(file);
				ObjectInputStream ois = new ObjectInputStream(fis);
				listOfDepartment = (ArrayList<Department>)
				ois.readObject();
				ois.close();
			}
			} catch (Exception e) {
			e.printStackTrace();
			}
			return listOfDepartment;
			}
	
		private void saveDepartmentList(List<Department> depList) {
			try {
				File file = new File("Department.dat");
				FileOutputStream fos;
				fos = new FileOutputStream(file);
				ObjectOutputStream oos = new ObjectOutputStream(fos);
				oos.writeObject(depList);
				oos.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
	}
		
		public Department getDepartmentById(String id) {
			List<Department> depList = getAllDepartment();
			for (Department dep : depList) {
				if (dep.getId().equalsIgnoreCase(id)) {
				return dep;
				}
			}

			return null;
		}
		
		public int addDepartment(Department dep) {
			List<Department> depList = getAllDepartment();
			boolean depExists = false;
			for (Department l : depList) {
				if (l.name.equalsIgnoreCase(dep.name)) {
					depExists = true;
					break;
				}
			}
			if (!depExists) {
				depList.add(dep);
				saveDepartmentList(depList);
				return 1;
			}
				return 0;
		}
		
		public int deleteDepartment(String id) {
	        List<Department> depList = getAllDepartment();
	        for (int i = 0; i < depList.size(); i++) {
	        	Department dep = depList.get(i);
	            if (dep.getId().equalsIgnoreCase(id)) {
	            	depList.remove(i);
	                saveDepartmentList(depList);
	                return 1;
	            }
	        }
	        return 0;
	    }

}
