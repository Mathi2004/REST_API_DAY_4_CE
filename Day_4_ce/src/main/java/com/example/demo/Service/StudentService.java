package com.example.demo.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Model.Student;
import com.example.demo.Repo.StudentRepo;

@Service
public class StudentService {
	@Autowired
	StudentRepo sr;
	public Student saveinfo(Student s)
	{
	   return sr.save(s);
	}
	 public List<Student> savedetails(List<Student> s)
	  {
		  return sr.saveAll(s);
	  }
    public List<Student> showinfo()
    {
    	return sr.findAll();
    }
    public Optional<Student> getid(int id)
	{
		return sr.findById(id);
	}
    public Student changeinfo(Student s)
    {
    	return sr.saveAndFlush(s);
    }
    public void deleteinfo(Student s)
    {
    	sr.delete(s);
    }
    public void deleteid(int id)
    {
  	  sr.deleteById(id);
    }
    public String updateinfobyid(int id,Student s)
    {
    	sr.saveAndFlush(s);
    	if(sr.existsById(id))
		{		
	return "updated";
		}
		else
		{
	          return "enter valid id";
		}

    }
}
