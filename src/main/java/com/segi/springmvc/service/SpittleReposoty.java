package com.segi.springmvc.service;

import com.segi.springmvc.model.Spittle;

import java.util.List;

/**
 * @author chenzx
 * @date 2018-10-09 下午 2:46
 */
public interface SpittleReposoty {
    List<Spittle> findSpittles(Long max, Integer count);

    Spittle findOne(Long id);
}
