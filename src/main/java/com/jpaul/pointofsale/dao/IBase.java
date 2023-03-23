package com.jpaul.pointofsale.dao;

import java.util.List;

public interface IBase<O> {
    List<O> fetch(O o) throws Exception;
    O gotoId(O o) throws Exception;
    O save(O o) throws Exception;
    O update(O o) throws Exception;
    O delete(O o) throws Exception;
    List<O> search(O o) throws Exception;
    O set()throws Exception;
    List<O> setAll()throws Exception;
}
