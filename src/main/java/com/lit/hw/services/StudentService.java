package com.lit.hw.services;

import java.util.ArrayList;

import com.lit.hw.entities.Student;

public interface StudentService {
	public ArrayList<Student> list();
	public boolean add(Student stu);
	public boolean update(Student stu);
	public boolean delete(int stuId);
	public Student show(int stuId);
	public ArrayList<Student> search(String keyword, String type);
}
