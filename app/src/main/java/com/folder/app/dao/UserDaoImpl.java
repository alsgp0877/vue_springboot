package com.folder.app.dao;

import java.util.List;
import org.springframework.stereotype.Repository;
import com.folder.app.dto.UserDTO;
import com.folder.app.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;

@Repository
public class UserDaoImpl implements UserDao {

    @Autowired UserMapper uMapper;
    
    @Override
    public List<UserDTO> findAll() {
        return uMapper.findAll();
    }

    @Override
    public int editById(UserDTO uDto) {
        return uMapper.editById(uDto); 
    }

    @Override
    public int delete(int no) {
        return uMapper.delete(no);    
    }

    @Override
    public int save(UserDTO uDto) {
        return uMapper.save(uDto);     
    }
    
    
}
