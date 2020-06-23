package com.DeGuzmanFamilyAPI.DeGuzmanFamilyAPIBackend.service;

import java.nio.file.Path;
import java.util.stream.Stream;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

public interface GeneralTransactionFileStorageService {
	public void init();
	
	public void save(MultipartFile file);
	
	public Resource load(String filename);
	
	public void deleteAllGeneralFiles();
	
	public Stream<Path> loadAllGeneralFiles();

}
