package com.epam.mjc.io;

import java.io.FileNotFoundException;

public class CustomRuntimeException extends Throwable {
    public CustomRuntimeException(FileNotFoundException e) {
    }
}
