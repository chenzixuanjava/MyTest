package com.segi.springmvc.model;

import com.google.common.hash.HashCode;
import lombok.Data;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.io.Serializable;
import java.util.Date;

/**
 * @author chenzx
 * @date 2018-10-09 下午 2:28
 */
@Data
public class Spittle implements Serializable {
    private Long id;
    private String message;
    private Date time;
    private Double lagitude;
    private Double longitude;

    public Spittle() {
    }

    public Spittle(String message, Date time) {
        this(message, time, null, null);
    }

    public Spittle(String message, Date time, Double lagitude, Double longitude) {
        this.id = null;
        this.message = message;
        this.time = time;
        this.lagitude = lagitude;
        this.longitude = longitude;
    }

    @Override
    public boolean equals(Object that) {
        return EqualsBuilder.reflectionEquals(this, that, "id", "time");
    }

    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this, "id", "time");
    }
}
