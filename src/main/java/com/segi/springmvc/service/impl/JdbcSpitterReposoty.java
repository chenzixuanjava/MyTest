package com.segi.springmvc.service.impl;

import com.segi.springmvc.model.Spitter;
import com.segi.springmvc.service.SpitterReposoty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.stereotype.Service;

/**
 * @author chenzx
 * @date 2018-10-26 上午 11:28
 */
@Service
public class JdbcSpitterReposoty implements SpitterReposoty {

    @Autowired
    JdbcOperations jdbcOperations;

    @Override
    public Spitter save(Spitter spitter) {
        jdbcOperations.update("sql", spitter.getId(), spitter.getUsername(), spitter.getPassword(), spitter.getEmail());
        return null;
    }

    @Override
    public Spitter findByUsername(String username) {
        return null;
    }
}
