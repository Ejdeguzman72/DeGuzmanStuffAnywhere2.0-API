package com.DeGuzmanFamilyAPI.DeGuzmanFamilyAPIBackend.file_upload_service;

import java.nio.file.Path;
import java.util.stream.Stream;

import javax.annotation.Resource;

import org.springframework.web.multipart.MultipartFile;

public interface MedicalTransactionFilesStorageService {

	public void init();
	
	public void save(MultipartFile file);
	
	public Resource load(String filename);
	
	public void deleteAllMedicalFiles();
	
	public Stream<Path> laodAllMedicalFiles();
}
