package com.empay.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.empay.entity.CustomerManagementEntity;
import com.empay.repository.CustomerManagementRepo;
import com.empay.service.CustomerManagementService;
import com.empay.service.FileService;
import com.empay.valueobject.CustomerManagementValueObject;
import com.empay.valueobject.FileResponse;
import com.empay.valueobject.JsonValueObject;
import com.google.gson.Gson;

@CrossOrigin(origins = "http://localhost:3000/")
@RestController
@RequestMapping(value = "/get/csmt/")
public class CustomerManagementController {
	public static void main(String[] args) {
		CustomerManagementController ss = new CustomerManagementController();
		ss.react();
	}

	@Autowired
	CustomerManagementService service;

	@Autowired
	CustomerManagementRepo Repo;
	
	@Autowired
	FileService fileService;
	
	@Value("${project.image}")
	private String path;

	@GetMapping(value = "/hit")
	public String getCustomerManagement(@RequestParam(value = "id") String id) {
		System.out.println(id);
		return id;

	}

	@GetMapping(value = "/hitt")
	public String getCustomerManagement() {
		System.out.println("Hitting!!!!!!!");
		return "hitting";
	}

	@GetMapping(value = "/hit/json")
	public String getCustomerManagementJsonObject(@RequestHeader(value = "id") Integer serialNumber) {

		String a = service.getJsonObject(serialNumber);
		return a;
	}

	@PostMapping(value = "/hit/save")
	public ResponseEntity<String> saveCustomerManagement(@RequestBody CustomerManagementValueObject Object) {
		try {
			Integer serialNumber = null;
			service.saveCustomerManagement(Object, serialNumber);
			return new ResponseEntity<String>("Saved SuccessFully", HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>("Failed to Save", HttpStatus.METHOD_FAILURE);
		}
	}

	@PatchMapping(value = "/hit/{serialNumber}")
	public ResponseEntity<String> editCustomerManagement(@RequestBody CustomerManagementValueObject valueObject,
			@PathVariable(value = "serialNumber") Integer serialNumber) {
		try {
			service.saveCustomerManagement(valueObject, serialNumber);
			return new ResponseEntity<>("Edited Successfully", HttpStatus.ACCEPTED);
		} catch (Exception e) {
			return new ResponseEntity<String>("Edited Failed", HttpStatus.METHOD_FAILURE);
		}
	}

	@PostMapping(value = "/hit/delete")
	public ResponseEntity<String> deleteCustomerManagement(@RequestHeader(value = "DELETE") Integer head) {
		System.out.println("controller");
		System.out.println("serialNumbr:" + head);
		service.deleteCustomerManagement(head);
		return new ResponseEntity<>("Delete Successfully", HttpStatus.ACCEPTED);
	}

	@GetMapping("/hello")
	ResponseEntity<String> hello() {

		return new ResponseEntity<>("Hello World!", HttpStatus.ACCEPTED);
	}

	@PostMapping(value = "/hit/procedure")
	public String customerManagementProcedure(@RequestParam(value = "serialnumber") Integer serialNumber,
			@RequestParam(value = "inscode") Integer insCode) {
		String a = service.customerManagementProcedure(serialNumber, insCode);
		return a;
	}

	@GetMapping(value = "/hit/getcustomer")
	public List<CustomerManagementEntity> getCustomer() {
		return Repo.findAll();

	}

	@PostMapping(value = "/hit/reactsave", produces = "application/json")
	public String add(@RequestBody CustomerManagementValueObject valueObject) {
		System.out.println("CustomerManagementController.add()");

		System.out.println(valueObject.getCustomerGender());
		System.out.println("hitting");
		return service.saveReactObject(valueObject);

	}

	@GetMapping(value = "/hit/reactlink", produces = "application/json")
	public List<JsonValueObject> react() {

		JsonValueObject valueObjectDemo = new JsonValueObject();
		valueObjectDemo.setPage("Demo");
		valueObjectDemo.setTitle("Demo");
		
		JsonValueObject valueObjectUserManagement = new JsonValueObject();
		valueObjectUserManagement.setPage("UserManagement");
		valueObjectUserManagement.setTitle("User Management");

		JsonValueObject valueObjectMerchantManagement = new JsonValueObject();
		valueObjectMerchantManagement.setPage("MerchantManagement");
		valueObjectMerchantManagement.setTitle("Merchant Management");
		
		JsonValueObject valueObjectMerchantPayment = new JsonValueObject();
		valueObjectMerchantPayment.setPage("MerchantPayment");
		valueObjectMerchantPayment.setTitle("Merchant Payment");
		
		JsonValueObject valueObjectParameters = new JsonValueObject();
		valueObjectParameters.setPage("Parameters");
		valueObjectParameters.setTitle("Parameters");
		
		JsonValueObject valueObjectFileUpload = new JsonValueObject();
		valueObjectParameters.setPage("FileUpload");
		valueObjectParameters.setTitle("File Upload");


		List<JsonValueObject> list = new ArrayList<>();
		list.add(valueObjectUserManagement);
		list.add(valueObjectMerchantManagement);
		list.add(valueObjectMerchantPayment);
		list.add(valueObjectParameters);
		list.add(valueObjectDemo);
		list.add(valueObjectFileUpload);
		System.out.println("************");

		return list;
	}
	@PostMapping("/upload")
	public ResponseEntity<String>fileUpload(
			@RequestParam("image")  MultipartFile image){
		try {
	String fileName =this.fileService.uploadImage(path, image);
	System.out.println("hitting");
	return new ResponseEntity<>("upload Successfully", HttpStatus.ACCEPTED);
		}catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>("Failed to upload", HttpStatus.METHOD_FAILURE);
		}
		
	}

}
