package com.sparta.sonam.csvproject.reader;

import org.junit.jupiter.api.*;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

class CSVFileReaderTest {
    @BeforeEach
    void setUp(){
    }

    @Test
    @DisplayName("Reading file from a non existent file should throw IOException with message 'File not found'")
    void readFromFileCatchIOException() {
        String fileName = "D:\\SpartaGlobal\\Course\\Week 5\\FileIO\\src\\main\\resources\\ThereIsNoFile.csv";
        String message = "File not found";
        Assertions.assertThrows(IOException.class, () -> new FileReader(fileName), message);
    }
}