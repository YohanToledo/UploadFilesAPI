package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.UploadedFile;

@Repository
public interface FileUploadRepository extends JpaRepository<UploadedFile,String>{

}
