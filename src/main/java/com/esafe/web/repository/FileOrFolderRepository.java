
  package com.esafe.web.repository;
  
  import org.springframework.data.jpa.repository.JpaRepository;

import com.esafe.web.model.FileOrFolder;
  
  
  public interface FileOrFolderRepository extends JpaRepository<FileOrFolder, Long> { }
 