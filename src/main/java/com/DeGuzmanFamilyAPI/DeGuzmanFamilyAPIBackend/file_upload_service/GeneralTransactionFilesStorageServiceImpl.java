package com.DeGuzmanFamilyAPI.DeGuzmanFamilyAPIBackend.file_upload_service;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

import org.jboss.logging.Logger;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.FileSystemUtils;
import org.springframework.web.multipart.MultipartFile;

import com.DeGuzmanFamilyAPI.DeGuzmanFamilyAPIBackend.logger.ExternalFileLogger;
import com.DeGuzmanFamilyAPI.DeGuzmanFamilyAPIBackend.message.LoggerMessage;

@Service
public class GeneralTransactionFilesStorageServiceImpl implements GeneralTransactionFileStorageService {
	
	private static final Logger LOGGER = Logger.getLogger(GeneralTransactionFilesStorageServiceImpl.class);
	
	private final Path root = Paths.get("general-transaction-uploads");

	@Override
	public void init() {
		try {
			Files.createDirectory(root);
			LOGGER.info(LoggerMessage.CREATE_GENERAL_TRANSACTION_UPLOADS_INFO_MESSAGE = ": " + root);
		} catch (IOException e) {
			LOGGER.warn(LoggerMessage.GET_GENERAL_TRANSACTION_FILE_ERROR_MESSAGE);
			throw new RuntimeException("Could not initialize folder for upload");
		}
		
	}

	@Override
	public void save(MultipartFile file) {
		try {
			Files.copy(file.getInputStream(), this.root.resolve(file.getOriginalFilename()));
			LOGGER.info(LoggerMessage.SAVE_GENERAL_TRANSACTION_FILE_INFO_MESSAGE + ": " + file.getOriginalFilename());
		} catch (Exception e) {
			e.printStackTrace();
			LOGGER.info(LoggerMessage.SAVE_GENERAL_TRANSACTION_FILE_ERROR_MESSAGE + ": " + file.getOriginalFilename());
		}
	}

	@Override
	public Resource load(String filename) {
		try {
			Path file = root.resolve(filename);
			Resource resource = new UrlResource(file.toUri());
			
			if (resource.exists() || resource.isReadable()) {
				LOGGER.info(LoggerMessage.GET_GENERAL_TRANSACTION_FILE_INFO_MESAGE + ": " + file.getFileName());
				return resource;
			} else {
				LOGGER.warn(LoggerMessage.GET_GENERAL_TRANSACTION_FILE_ERROR_MESSAGE + ": " + file.getFileName());
				throw new RuntimeException("Could not read the file");
			}
		} catch (MalformedURLException e) {
			LOGGER.warn(LoggerMessage.GET_GENERAL_TRANSACTION_FILE_ERROR_MESSAGE + " " + e.getMessage());
			throw new RuntimeException("Error" + e.getMessage());
		}
	}

	@Override
	public void deleteAllGeneralFiles() {
		FileSystemUtils.deleteRecursively(root.toFile());
		
	}

	@Override
	public Stream<Path> loadAllGeneralFiles() {
		try {
			return Files.walk(this.root, 1).filter(path -> !path.equals(this.root)).map(this.root::relativize);
		} catch (IOException e) {
			throw new RuntimeException("Could not load the files");
		}
	}
}
