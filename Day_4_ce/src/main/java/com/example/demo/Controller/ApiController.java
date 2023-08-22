package com.example.demo.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Model.Student;
import com.example.demo.Service.StudentService;

@RestController
public class ApiController {
@Autowired
StudentService ss;
@PostMapping("addstudent")
public Student add(@RequestBody Student s)
{
	return ss.saveinfo(s);
}
@PostMapping("addnstudent")
public List<Student> addndetails(@RequestBody List<Student> s)
{
	   return ss.savedetails(s);
}
@GetMapping("showdetails")
public List<Student> show()
{
	return ss.showinfo();
}
@GetMapping("ShowByID/{id}")
public  Optional<Student>  getmyid(@PathVariable int id)
{
	return ss.getid(id);
}
@PutMapping("update")
public Student modify(@RequestBody Student s)
{
	return ss.changeinfo(s);
}
@PutMapping("updatebyid/{id}")
public String modifybyid(@PathVariable int id,@RequestBody Student s)
{
    return ss.updateinfobyid(id, s);		
}
@DeleteMapping("deletedetail")
public String del(@RequestBody Student s)
{
	ss.deleteinfo(s);
	return "deleted successfully";
}
@DeleteMapping("deleteid/{id}")
public void deletemyid(@PathVariable int id)
{
	   ss.deleteid(id);
}

}
