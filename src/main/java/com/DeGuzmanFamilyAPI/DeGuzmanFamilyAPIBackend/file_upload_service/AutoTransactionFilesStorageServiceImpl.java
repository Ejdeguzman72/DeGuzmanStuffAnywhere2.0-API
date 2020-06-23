package com.DeGuzmanFamilyAPI.DeGuzmanFamilyAPIBackend.file_upload_service;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class AutoTransactionFilesStorageServiceImpl implements AutoTransactionFilesStorageService {

	private final Path root = Paths.get("auto-uploads");
	
	@Override
	public void init() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void save(MultipartFile file) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAllAutoFiles() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Stream<Path> loadAllAUtoFiles() {
		// TODO Auto-generated method stub
		return null;
	}

}
