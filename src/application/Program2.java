package application;

import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();

		System.out.println("=== TEST 1: department findById ===");

		Department department = departmentDao.findById(3);
		System.out.println(department);

		System.out.println("=== TEST 2: department findAll ===");

		List<Department> list = departmentDao.findAll();

		for (Department obj : list) {
			System.out.println(obj);
		}

		System.out.println("=== TEST 3: department insert ===");

		Department newDepartment = new Department(null, "Mesas");
		departmentDao.insert(newDepartment);
		System.out.println("Inserido! Novo id: " + newDepartment.getId());

		System.out.println("=== TEST 4: department update ===");

		department = departmentDao.findById(1);
		department.setName("PC");
		departmentDao.update(department);
		System.out.println("Atualiza��o concluida");

		System.out.println("=== TEST 5: department delete ===");
		System.out.print("Digite o id para deletar: ");
		int id = sc.nextInt();
		departmentDao.deleteById(id);
		System.out.println("Exclus�o concluida ");
		sc.close();

	}

}
