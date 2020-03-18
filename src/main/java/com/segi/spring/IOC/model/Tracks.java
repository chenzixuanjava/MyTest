package com.segi.spring.IOC.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author chenzx
 * @date 2018-10-08 下午 4:06
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Tracks {
    private List<Track> tracks;
}
