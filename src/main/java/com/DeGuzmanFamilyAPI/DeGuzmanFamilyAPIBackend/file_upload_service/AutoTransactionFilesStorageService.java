package com.DeGuzmanFamilyAPI.DeGuzmanFamilyAPIBackend.file_upload_service;

import java.nio.file.Path;
import java.util.stream.Stream;

import org.springframework.web.multipart.MultipartFile;

public interface AutoTransactionFilesStorageService {

	public void init();
	
	public void save(MultipartFile file);
	
	public void deleteAllAutoFiles();
	
	public Stream<Path> loadAllAUtoFiles();
}
