package com.nttech.controller;




import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;


import com.nttech.entity.DatabaseIntranetJDBC;
import com.nttech.entity.Director;
import com.nttech.entity.Employee;
import com.nttech.entity.User;

@Controller
@RequestMapping("/")
public class HomeController {
	@Autowired
	SessionFactory sessionFatory;
	
	@Transactional
	@GetMapping
	public String index(ModelMap map) {
		ApplicationContext context = new ClassPathXmlApplicationContext("IoC.xml");
//		1. Connect with JDBC
//		DatabaseIntranetJDBC databaseIntranet = (DatabaseIntranetJDBC) context.getBean("dbIntranet");
//		databaseIntranet.getUser();
		
//		2. Connect with Hibenate
		Session session = sessionFatory.getCurrentSession();
		String sql = "from User";
		List<User> list = session.createQuery(sql).getResultList();
		for(User user : list) {
			System.out.println("Name: " + user.getName() + "Age: " + user.getAge() + "Address: " + user.getAddress());
		}
//		
//		
		
		((ClassPathXmlApplicationContext)context).close();
		return "index";
	}
	
	
	//RequestParam
//	@RequestMapping(path = "/detail", method = RequestMethod.GET)
//	public String Detail(@RequestParam(name = "id") int id, ModelMap map) {
	
	
	//PathVariable
//	@RequestMapping(path = "/detail/{id}/{productName}", method = RequestMethod.GET)
//	public String Detail(@PathVariable(name = "id") int id, @PathVariable("productName") String productName, ModelMap map) {
//		map.addAttribute("id",id);
//		map.addAttribute("productName", productName);
//		return "detail";
//	}
//	
//	@RequestMapping(path = "detail", method = RequestMethod.POST)
//	public String PostDetail(@RequestParam String username, @RequestParam int password,  ModelMap modelMap) {
//		modelMap.addAttribute("userName",username);
//		modelMap.addAttribute("passWord",password);
//		return "detail";
//	}
	

//	@ResponseBody
//	public ModelAndView index() {

	
	
	public String index1(ModelMap map) {
		ApplicationContext context = new ClassPathXmlApplicationContext("IoC.xml");
		map.addAttribute("name", "Nguyen Thuan");
		map.addAttribute("age", 18);
		Employee employee = new Employee();
		employee.setName("Nguyen Thuan");
		employee.setAdress("Nghia Thuan-Tu Nghia - Quang Ngai");
		employee.setAge(28);
		
		Employee employee2 = new Employee();
		employee2.setName("Nguyen Van Tien");
		employee2.setAdress("Nghia Thuan - Tu Nghia - Quang Ngai");
		employee2.setAge(27);

		List<Employee> list = new ArrayList<>();
		list.add(employee);
		list.add(employee2);
		map.addAttribute("list", list);
//		ModelAndView andView = new ModelAndView();
//		andView.setViewName("index");
//		String username = "thuan.ng";
//		String password = "191291";
//		
//		andView.addObject("username", username);
//		andView.addObject("password", password);
//		
//		Employee employee = new Employee();
//		employee.setName("Nguyen Thuan");
//		employee.setAdress("Nghia Thuan - Tu Nghia - Quang Ngai");
//		employee.setAge(28);
//		map.addAttribute("data", employee);
		((ClassPathXmlApplicationContext)context).close();
		
		
		return "index";
	}
	
	
	
	
	
//	@RequestMapping("/")
//	@ResponseBody
	public String indexLearn() {
//		return "Hello Mr.Thuan";
		ApplicationContext context = new ClassPathXmlApplicationContext("IoC.xml");
		Employee employee = (Employee) context.getBean("employee");
		
//		List
//		for(String value : employee.getList()) {
//			System.out.println(value);
//		}
//		employee.getMessage();
	
		//Map
//		for(Entry<String, Object> value : employee.getMap().entrySet()) {
//			System.out.println("key: " + value.getKey() + "Value:" + value.getValue());
//		}
			
//		Properties
//		String username = employee.getProperties().getProperty("user");
//		System.out.println("Username: " + username);
		
//		Singleton
//		Employee employee1 = (Employee) context.getBean("employee");
//		employee.setName("Mr Thuan dep trai");
//		System.out.println("Username: " + employee.getName());
//		
//		Employee employee2 = (Employee) context.getBean("employee");
//		employee2.setName("Mr Thuan dep trai quas");
//		System.out.println("Username: " + employee2.getName());
//		
//		Employee employee3 = (Employee) context.getBean("employee");
//		System.out.println("Username 3: " + employee3.getName());
		
	
//		System.out.println("Inser bean: " + employee.getDirector().getPosition());
		
//		Resource
//		Resource resource  = context.getResource("classpath:text.txt");
		//C1
//		CustomResourceLoader resourceLoader = new CustomResourceLoader();
//		resourceLoader.setResourceLoader(context);
//		C2
		CustomResourceLoader resourceLoader = (CustomResourceLoader) context.getBean("resourceLoader");
		Resource resource = resourceLoader.getResource("classpath:text.txt");
		
		try {
			InputStream inputStream = resource.getInputStream();
			InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
			BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
			String line = "";
			StringBuilder data = new StringBuilder();
			while((line = bufferedReader.readLine()) != null) {
				data.append(line + "\n");
			}
			bufferedReader.close();
			inputStreamReader.close();
			inputStream.close();
			System.out.println("Data" + data.toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		((ClassPathXmlApplicationContext)context).close();
		return "index";
	}
	
	@RequestMapping("/login")
	@ResponseBody
	public String Login() {
		return "login";
	}
}
