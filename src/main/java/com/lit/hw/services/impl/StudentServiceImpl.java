package com.lit.hw.services.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.sql.DataSource;

import com.lit.hw.entities.Student;
import com.lit.hw.services.StudentService;

public class StudentServiceImpl implements StudentService {
	private DataSource dataSource;

	public StudentServiceImpl(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public ArrayList<Student> list() {
		String sql = "select * from student ORDER BY id;";
		try (Connection cnn = dataSource.getConnection();) {
			PreparedStatement ps = cnn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			System.out.println(ps.toString());
			ArrayList<Student> listStudent = new ArrayList<Student>();
			while (rs.next()) {
				Student s = new Student();
				s.setId(rs.getInt("id"));
				s.setFirstname(rs.getString("first_name"));
				s.setLastname(rs.getString("last_name"));
				s.setClassroom(rs.getString("classroom"));
				listStudent.add(s);
			}
			return listStudent;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public boolean add(Student stu) {
		String sql = "INSERT INTO student(first_name,last_name,classroom) "
				+ "VALUES (?,?,?);";
		try (Connection cnn = dataSource.getConnection();) {
			PreparedStatement ps = cnn.prepareStatement(sql);
			ps.setString(1, stu.getFirstname());
			ps.setString(2, stu.getLastname());
			ps.setString(3, stu.getClassroom());
			System.out.println(ps.toString());
			if (ps.executeUpdate() > 0)
				return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean update(Student stu) {
		String sql = "update student set " + "first_name = ?, "
				+ "last_name = ?, " + "classroom= ? " + "where id = ?";
		try (Connection cnn = dataSource.getConnection();) {
			PreparedStatement ps = cnn.prepareStatement(sql);
			ps.setString(1, stu.getFirstname());
			ps.setString(2, stu.getLastname());
			ps.setString(3, stu.getClassroom());
			ps.setInt(4, stu.getId());
			System.out.println(ps.toString());
			if (ps.executeUpdate() > 0)
				return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean delete(int stuId) {
		String sql = "Delete from student where id = ?";
		try (Connection cnn = dataSource.getConnection();) {
			PreparedStatement ps = cnn.prepareStatement(sql);
			ps.setInt(1, stuId);
			System.out.println(ps.toString());
			if (ps.executeUpdate() > 0)
				return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public Student show(int stuId) {
		String sql = "select * from student where id = ?";
		try (Connection cnn = dataSource.getConnection();) {
			PreparedStatement ps = cnn.prepareStatement(sql);
			ps.setInt(1, stuId);
			ResultSet rs = ps.executeQuery();
			System.out.println(ps.toString());
			if (rs.next()) {
				Student s = new Student();
				s.setId(rs.getInt("id"));
				s.setFirstname(rs.getString("first_name"));
				s.setLastname(rs.getString("last_name"));
				s.setClassroom(rs.getString("classroom"));
				return s;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public ArrayList<Student> search(String keyword, String type) {
		String sql = "select * from student where LOWER(" + type
				+ ") like LOWER(?) ORDER BY " + type;
		try (Connection cnn = dataSource.getConnection();) {
			PreparedStatement ps = cnn.prepareStatement(sql);
			System.out.println(ps.toString());
			ps.setString(1, keyword + "%");
			ResultSet rs = ps.executeQuery();
			ArrayList<Student> listStudent = new ArrayList<Student>();
			while (rs.next()) {
				Student s = new Student();
				s.setId(rs.getInt("id"));
				s.setFirstname(rs.getString("first_name"));
				s.setLastname(rs.getString("last_name"));
				s.setClassroom(rs.getString("classroom"));
				listStudent.add(s);
			}
			return listStudent;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
