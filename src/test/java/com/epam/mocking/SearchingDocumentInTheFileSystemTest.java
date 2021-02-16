package com.epam.mocking;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.stubbing.OngoingStubbing;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class SearchingDocumentInTheFileSystemTest {
    private static File mockFile;
    private static SearchingDocumentInTheFileSystem searchingDocumentInTheFileSystem;
    private static String fileName;
    private static ArrayList<String> contents;
    private static Path path;

    @BeforeClass
    public static void mocking() {
        searchingDocumentInTheFileSystem = Mockito.mock(SearchingDocumentInTheFileSystem.class);
        contents = new ArrayList<String>();
        contents.add("wtf.jpg");
        fileName = "wtf.jpg";
        path = Paths.get("C:\\Users\\acer\\Desktop\\tmp\\wtf.jpg");
    }

    @Before
    public void whatMethodsShouldDo() {
        Mockito.when(searchingDocumentInTheFileSystem.viewTheContentsOfTheCurrentDirectory(path))
                .thenReturn(contents);
        Mockito.when(searchingDocumentInTheFileSystem.searchInTheCurrentDirectoryByFileName(fileName))
                .thenReturn(path);
        Mockito.when(searchingDocumentInTheFileSystem.buildFullPathFromTheRootByTheFileName(fileName))
                .thenReturn(path);
    }

    @Test
    public void viewTheContentsOfTheCurrentDirectory() {
        Mockito.verify(searchingDocumentInTheFileSystem).viewTheContentsOfTheCurrentDirectory(path);
//        assertTrue(when(mockFile.isDirectory()).thenReturn(true));
    }

    @Test
    public void searchInTheCurrentDirectoryByFileNameWorksCorrect() {
        Mockito.verify(searchingDocumentInTheFileSystem).searchInTheCurrentDirectoryByFileName(fileName);
    }

    @Test
    public void buildFullPathFromTheRootByTheFileNameWorksCorrect() {
        Mockito.verify(searchingDocumentInTheFileSystem).buildFullPathFromTheRootByTheFileName(fileName);
    }
}
