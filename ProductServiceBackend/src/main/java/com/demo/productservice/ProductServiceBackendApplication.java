package com.demo.productservice;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.demo.productservice.inheritancerelations.singletable.Mentor;
import com.demo.productservice.inheritancerelations.singletable.MentorRepository;
import com.demo.productservice.inheritancerelations.singletable.Student;
import com.demo.productservice.inheritancerelations.singletable.StudentRepository;
import com.demo.productservice.inheritancerelations.singletable.User;
import com.demo.productservice.inheritancerelations.singletable.UserRepository;

@SpringBootApplication
public class ProductServiceBackendApplication implements CommandLineRunner {

	private MentorRepository mentorRepository;
	private UserRepository userRepository;
	private StudentRepository studentRepository;

	ProductServiceBackendApplication(@Qualifier("st_mertorrepo") MentorRepository mentorRepository,

			@Qualifier("st_studentrepo") StudentRepository studentRepository,

			@Qualifier("st_userrepo") UserRepository userRepository) {

		this.mentorRepository = mentorRepository;
		this.studentRepository = studentRepository;
		this.userRepository = userRepository;
	}

	/*
	 * private MentorRepository mentorRepository;
	 * private StudentRepository studentRepository;
	 * private UserRepository userRepository;
	 * 
	 * ProductServiceBackendApplication(@Qualifier("tpc_mentorRepository")
	 * MentorRepository mentorRepository,
	 * StudentRepository studentRepository,
	 * UserRepository userRepository) {
	 * 
	 * this.mentorRepository = mentorRepository;
	 * this.studentRepository = studentRepository;
	 * this.userRepository = userRepository;
	 */
	}

	public static void main(String[] args) {
		SpringApplication.run(ProductServiceBackendApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		/*
		 * Mentor mentor = new Mentor(); mentor.setName("Shubham");
		 * mentor.setEmail("abc@gmail.com"); mentor.setAvgRating(99.1);
		 * 
		 * mentorRepository.save(mentor);
		 * 
		 * 
		 * Student stu = new Student(); stu.setName("Kaushit"); stu.setPsp(70);
		 * stu.setEmail("xyz@gmail.com");
		 * 
		 * studentRepository.save(stu);
		 * 
		 * User user = new User(); user.setName("Shubham");
		 * user.setEmail("axc@gmail.com");
		 * 
		 * userRepository.save(user);
		 * 
		 * List<User> users = userRepository.findAll();
		 * 
		 * for(User user1: users) { System.out.println(user1.toString()); }
		 */

		Mentor mentor = new Mentor();
		mentor.setName("Shubham");
		mentor.setEmail("abc@gmail.com");
		mentor.setAvgRating(4.8);
		mentorRepository.save(mentor);

		Student student = new Student();
		student.setName("Kaushit");
		student.setEmail("xyz@gmail.com");
		student.setPsp(97);
		studentRepository.save(student);

		User user = new User();
		user.setName("Moon");
		user.setEmail("moon@gmail.com");
		userRepository.save(user);

	}

}
