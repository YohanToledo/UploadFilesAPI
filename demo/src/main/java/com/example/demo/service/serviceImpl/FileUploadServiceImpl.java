package com.example.demo.service.serviceImpl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.model.UploadedFile;
import com.example.demo.repository.FileUploadRepository;
import com.example.demo.service.FileUploadService;

@Service
public class FileUploadServiceImpl implements FileUploadService{

	@Autowired
	private FileUploadRepository fileRepo;
	private String uploadFolderPath = "C:\\Users\\yohan\\Desktop\\upload-dir\\uploaded_";
	
	@Override
	public void uploadToLocal(MultipartFile file) {
		
		try {
			byte[] fileData = file.getBytes();
			Path path = Paths.get(uploadFolderPath + file.getOriginalFilename());
			Files.write(path, fileData);
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void uploadToDatabase(MultipartFile multipartFile) {
		UploadedFile file = new UploadedFile();
		file.setFileName(multipartFile.getOriginalFilename());
		file.setFileType(multipartFile.getContentType());
		try {
			file.setFileData(multipartFile.getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}
		fileRepo.save(file);
	}	
	
}
