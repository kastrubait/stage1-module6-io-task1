package com.epam.mjc.io;

import java.io.FileNotFoundException;

public class CustomRuntimeException extends FileNotFoundException {
    public CustomRuntimeException(FileNotFoundException e) {
    }
}
