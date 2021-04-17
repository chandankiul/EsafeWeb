package com.esafe.test;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.esafe.web.controller.FileOrFolderController;
import com.esafe.web.model.FileOrFolder;
import com.esafe.web.repository.FileOrFolderRepository;

//@WebMvcTest(FileOrFolderController.class)
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class FileOrFolderControllerTest {


    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private FileOrFolderRepository mockRepository;

    @Before
    public void init() {
        FileOrFolder fileOrFolder = new FileOrFolder(1L, "TitleAB", "Environment", "Operator","Yes",LocalDate.now().toString());
        when(mockRepository.findById(1L)).thenReturn(Optional.of(fileOrFolder));
    }

    @Test
    public void find_allBook_OK() throws Exception {

        List<FileOrFolder> fileOrFolder = Arrays.asList(
                new FileOrFolder(1L, "TitleA", "Attendance", "Operator","No",LocalDate.now().toString()),
                new FileOrFolder(2L, "TitleB", "Leaves", "OperatorEconomy","Yes",LocalDate.now().toString()));

        when(mockRepository.findAll()).thenReturn(fileOrFolder);

        mockMvc.perform(get("/files"))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].id", is(1)))
                .andExpect(jsonPath("$[0].name", is("Book A")))
                .andExpect(jsonPath("$[0].author", is("Ah Pig")))
                .andExpect(jsonPath("$[0].price", is(1.99)))
                .andExpect(jsonPath("$[1].id", is(2)))
                .andExpect(jsonPath("$[1].name", is("Book B")))
                .andExpect(jsonPath("$[1].author", is("Ah Dog")))
                .andExpect(jsonPath("$[1].price", is(2.99)));

        verify(mockRepository, times(1)).findAll();
    }

}
