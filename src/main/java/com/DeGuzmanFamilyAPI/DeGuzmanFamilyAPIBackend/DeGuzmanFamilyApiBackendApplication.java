package com.DeGuzmanFamilyAPI.DeGuzmanFamilyAPIBackend;

import javax.annotation.Resource;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.DeGuzmanFamilyAPI.DeGuzmanFamilyAPIBackend.file_upload_service.AutoTransactionFilesStorageService;
import com.DeGuzmanFamilyAPI.DeGuzmanFamilyAPIBackend.file_upload_service.GeneralTransactionFileStorageService;
import com.DeGuzmanFamilyAPI.DeGuzmanFamilyAPIBackend.file_upload_service.MedicalTransactionFilesStorageService;

@SpringBootApplication
public class DeGuzmanFamilyApiBackendApplication implements CommandLineRunner {
	
	@Resource
	GeneralTransactionFileStorageService generalTrxfilesStorageService;
	
	@Resource
	MedicalTransactionFilesStorageService medicalTrxFilesStorageService;
	
	@Resource
	AutoTransactionFilesStorageService autoTrxFilesStorageService;

	public static void main(String[] args) {
		SpringApplication.run(DeGuzmanFamilyApiBackendApplication.class, args);
		int port = 8080;
		
		System.out.println("You are using port: " + port);
	}

	@Override
	public void run(String... args) throws Exception {
		generalTrxfilesStorageService.deleteAllGeneralFiles();
		generalTrxfilesStorageService.init();
		
		medicalTrxFilesStorageService.deleteAllMedicalFiles();
		medicalTrxFilesStorageService.init();
		
		autoTrxFilesStorageService.deleteAllAutoFiles();
		autoTrxFilesStorageService.init();
	}
}
