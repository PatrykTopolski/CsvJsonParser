package com.patryk.dao;

import com.patryk.model.User;

import java.util.List;

public interface DataReader {
    public List<User> ReadData(String fileName);
}
