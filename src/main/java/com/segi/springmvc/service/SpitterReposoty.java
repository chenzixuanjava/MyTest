package com.segi.springmvc.service;

import com.segi.springmvc.model.Spitter;

/**
 * @author chenzx
 * @date 2018-10-09 下午 4:17
 */
public interface SpitterReposoty {
    Spitter save(Spitter spitter);

    Spitter findByUsername(String username);
}
