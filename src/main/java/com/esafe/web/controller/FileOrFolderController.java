package com.esafe.web.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.esafe.web.model.FileOrFolder;
import com.esafe.web.repository.FileOrFolderRepository;

@RestController
public class FileOrFolderController {

	private static final Logger LOGGER=LoggerFactory.getLogger(FileOrFolderController.class);
	
    @Autowired
    private FileOrFolderRepository fileOrFolderRepository;

    // Find
    @GetMapping("/files")
    List<FileOrFolder> findAll() {
    	LOGGER.error("Inside FileOrFolderController findAll method");
    	return fileOrFolderRepository.findAll();
    }

    // Save
    @PostMapping("/saveFile")
    @ResponseStatus(HttpStatus.CREATED)
    FileOrFolder saveFileorFolder(@RequestBody FileOrFolder fileOrFolder) {
    	LOGGER.error("Inside FileOrFolderController saveFileorFolder method");
    	return fileOrFolderRepository.save(fileOrFolder);
    }

}
