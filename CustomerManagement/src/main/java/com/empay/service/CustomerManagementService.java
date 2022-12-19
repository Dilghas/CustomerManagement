package com.empay.service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.empay.entity.CustomerManagementEntity;
import com.empay.repository.CustomerManagementRepo;
import com.empay.valueobject.CustomerManagementValueObject;


@Service
public class CustomerManagementService implements FileService {
	
//public static void main(String[] args) {
//	System.out.println(new CustomerManagementValueObject().getSerialNumber());
//}

	@Autowired
	CustomerManagementRepo cusRepo;
	
	@Autowired
	EntityManager entityManager;
	
	@Autowired
	Environment env;
	
	public static final Logger logger= LoggerFactory.getLogger(CustomerManagementService.class);
	
	 public List<CustomerManagementValueObject> getCustomerManagement(Integer serialNumber) {
		 CustomerManagementValueObject cusVO=new CustomerManagementValueObject();
		 List<CustomerManagementValueObject>object=new ArrayList<CustomerManagementValueObject>();
		 try {
			 CustomerManagementEntity entity=cusRepo.findSerialNumber(serialNumber);
			 cusVO.setCustomerFullName(entity.getCustomerFirstName()+entity.getCustomerMiddleName()+entity.getCustomerLastName());
			 cusVO.setCustomerAge(entity.getCustomerAge());
			 cusVO.setCustomerAmount(entity.getCustomerAmount());
			 cusVO.setCustomerGender(entity.getCustomerGender());
			 object.add(cusVO);
		
		 } catch (Exception e) {
			logger.error("ERROR:getCustomerManagement():",e);
		}
		 return object;
	 }
	 
	 public void saveCustomerManagement(CustomerManagementValueObject valueObject,Integer serialNumber) throws ParseException {
       
		 SimpleDateFormat sdf= new SimpleDateFormat("dd/MM/yyyy");
		 CustomerManagementEntity entity= new CustomerManagementEntity();
		 entity.setSerialNumber(serialNumber);
		 entity.setCustomerTitle(valueObject.getCustomerTitle());
		 entity.setCustomerFirstName(valueObject.getCustomerFirstName());
		 entity.setCustomerMiddleName(valueObject.getCustomerMiddleName());
		 entity.setCustomerLastName(valueObject.getCustomerLastName());
		 entity.setCustomerAge(valueObject.getCustomerAge());
		 java.util.Date utilStartDate= sdf.parse(valueObject.getCustomerDateOfBirth());
			java.sql.Date sqldob= new java.sql.Date(utilStartDate.getTime()); 
			entity.setCustomerDateOfBirth(sqldob); 
		 entity.setCustomerCountry(valueObject.getCustomerCountry());
		 entity.setCustomerGender(valueObject.getCustomerGender());
		 entity.setCustomerAddresOne(valueObject.getCustomerAddressOne());
		 entity.setCustomerAddresTwo(valueObject.getCustomerAddressTwo());
		 entity.setCustomerAmount(valueObject.getCustomerAmount());
		 entity.setInstitutionCode(109);
		 entity.setLastUpdate(sqldob);
		 cusRepo.save(entity);
	 } 
	 public void deleteCustomerManagement(Integer serialNumber) {
		 cusRepo.deleteById(serialNumber);
	 }
	 
	 public String customerManagementProcedure(Integer serialNumber,Integer insCode) {

		 int errorCode=0;
		 String errorMsg="";
		 Integer user=Integer.parseInt(env.getProperty("user.customer"));
		 /* String res = env.getProperty("spring.datasource.password"); */
		
		 try {
			 StoredProcedureQuery storedProcedure = entityManager.createStoredProcedureQuery("DPR_INS_CUSTOMER_INSERT");
			 storedProcedure.registerStoredProcedureParameter(0,Integer.class,ParameterMode.IN);
			 storedProcedure.registerStoredProcedureParameter(1,Integer.class,ParameterMode.IN);
			 storedProcedure.registerStoredProcedureParameter(2,Integer.class,ParameterMode.IN);
			 storedProcedure.registerStoredProcedureParameter(3,Integer.class,ParameterMode.OUT);
			 storedProcedure.registerStoredProcedureParameter(4,String.class,ParameterMode.OUT);
			 storedProcedure.setParameter(0,serialNumber);
			 storedProcedure.setParameter(1,user);
			 storedProcedure.setParameter(2, insCode);
			 storedProcedure.execute();
			 errorCode=(Integer) storedProcedure.getOutputParameterValue(3);
			 errorMsg=(String) storedProcedure.getOutputParameterValue(4);
			 
		 } catch (Exception e){
			 logger.error("ERROR:customerManagementProcedure():",e);
		 }
		return errorMsg;
	 }
	 
	 public String getJsonObject(Integer serialNumber) {
		 JSONObject Object=new JSONObject();
		 CustomerManagementEntity entity=cusRepo.findSerialNumber(serialNumber);
		 Object.put("FullName",entity.getCustomerFirstName()+" "+entity.getCustomerMiddleName()+" "+entity.getCustomerLastName());
		 Object.put("Country",entity.getCustomerCountry());
		 Object.put("Age",entity.getCustomerAge());
		 Object.put("Address",entity.getCustomerAddresOne()+" "+entity.getCustomerAddresTwo());
		 Object.put("Amount",entity.getCustomerAmount());
		 return Object.toString();
		 
	 }
	 
	 public String saveReactObject(CustomerManagementValueObject valueObject) {
		CustomerManagementEntity entity= new CustomerManagementEntity();
		entity.setCustomerFirstName(valueObject.getCustomerFirstName());
		entity.setCustomerAge(valueObject.getCustomerAge());
		entity.setCustomerGender(valueObject.getCustomerGender());
		entity.setCustomerAmount(valueObject.getCustomerAmount());
		entity.setCustomerAddresOne(valueObject.getCustomerAddressOne());
		cusRepo.save(entity);
		return "saved Succesfully";
	 }
	 
	 @Override
	 public String uploadImage(String path,MultipartFile file) {
		 
	try {	
		 //File name
		 String name=file.getOriginalFilename();
		 
		 //random name generate file
		 String randomId =UUID.randomUUID().toString();
		 String fileName1= randomId.concat(name.substring(name.lastIndexOf(".")));
		 
		 //FullPath
		 String filePath=path+fileName1;
		 
		 //create folder if not created
		 File f=new File(path);
		 if(!f.exists()) {
			 f.mkdir();
		 }
		 
		 //file copy
		 Files.copy(file.getInputStream(),Paths.get(filePath));
		 return name ;
	}catch (Exception e) {
		e.printStackTrace();
		return "failed";
	}
	 }
}