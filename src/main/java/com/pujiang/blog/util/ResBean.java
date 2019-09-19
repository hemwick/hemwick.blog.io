package com.pujiang.blog.util;

import java.util.List;

public class ResBean {
    public Boolean valid;
    public  Integer code;

    public List rows;
    public Long total;

    public ResBean() {
    }

    public ResBean(Long total) {
        this.total = total;
    }

    public ResBean(List rows) {
        this.rows = rows;
    }

    public ResBean(Boolean valid) {
        this.valid = valid;
    }

    public ResBean(Integer code) {
        this.code = code;
    }

    public ResBean(List rows, Long total) {
        this.rows = rows;
        this.total = total;
    }

    public ResBean(Boolean valid, Integer code) {
        this.valid = valid;
        this.code = code;
    }

    public Boolean getValid() {
        return valid;
    }

    public void setValid(Boolean valid) {
        this.valid = valid;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public List getRows() {
        return rows;
    }

    public void setRows(List rows) {
        this.rows = rows;
    }

    @Override
    public String toString() {
        return "ResBean{" +
                "valid=" + valid +
                ", code=" + code +
                ", rows=" + rows +
                ", total=" + total +
                '}';
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }
}
